param(
    [string]$UiRoot = (Join-Path (Split-Path $PSScriptRoot -Parent) '../ui'),
    [string]$UiFxRoot = (Join-Path (Split-Path $PSScriptRoot -Parent) '../ui-fx'),
    [string]$DiRoot = (Join-Path (Split-Path $PSScriptRoot -Parent) '../di'),
    [string]$FxBaseRoot = (Join-Path (Split-Path $PSScriptRoot -Parent) '../fx-base'),
    [string]$FxGraphicsRoot = (Join-Path (Split-Path $PSScriptRoot -Parent) '../fx-graphics'),
    [string]$FxControlsRoot = (Join-Path (Split-Path $PSScriptRoot -Parent) '../fx-controls'),
    [string]$ThemeRoot = (Join-Path (Split-Path $PSScriptRoot -Parent) '../theme')
)
$ErrorActionPreference = 'Stop'
$root = Split-Path $PSScriptRoot -Parent
$ui = (Resolve-Path -LiteralPath $UiRoot).Path
$uiFx = (Resolve-Path -LiteralPath $UiFxRoot).Path
$di = (Resolve-Path -LiteralPath $DiRoot).Path
$fxBase = (Resolve-Path -LiteralPath $FxBaseRoot).Path
$fxGraphics = (Resolve-Path -LiteralPath $FxGraphicsRoot).Path
$fxControls = (Resolve-Path -LiteralPath $FxControlsRoot).Path
$theme = (Resolve-Path -LiteralPath $ThemeRoot).Path
$norm = Join-Path $PSScriptRoot 'norm.ps1'
$packages = Join-Path $root '.norm-home/.norm/cache/packages'
$maven = Join-Path $root '.norm-home/.norm/cache/maven'
New-Item -ItemType Directory -Force $packages, $maven | Out-Null

function Invoke-Norm {
    param([string[]]$Arguments)
    & $norm @Arguments
    if ($LASTEXITCODE -ne 0) { throw "Norm command failed: $($Arguments -join ' ')" }
}

$themeRepository = Join-Path $theme 'build/repository'
if (!(Test-Path -LiteralPath (Join-Path $themeRepository 'dev/normlanguage/theme-colors/1/theme-colors-1.jar'))) {
    throw 'Theme color artifact is missing; build the theme repository first'
}
Copy-Item -Path (Join-Path $themeRepository '*') -Destination $maven -Recurse -Force

Invoke-Norm -Arguments @('package', (Join-Path $theme 'theme'), '--output', $packages)
$diWorkspace = Split-Path $di -Parent
foreach ($module in @('jakarta-inject/jakarta/inject', 'jakarta-annotation/jakarta/annotation', 'micronaut-inject/micronaut/inject', 'micronaut-inject-processor/micronaut/inject/processor')) {
    Invoke-Norm -Arguments @('package', (Join-Path $diWorkspace $module), '--output', $packages)
}
Invoke-Norm -Arguments @('package', (Join-Path $di 'di'), '--output', $packages)
Invoke-Norm -Arguments @('package', (Join-Path $fxBase 'fx/base'), '--output', $packages)
Invoke-Norm -Arguments @('package', (Join-Path $fxGraphics 'fx/graphics'), '--output', $packages)
Invoke-Norm -Arguments @('package', (Join-Path $fxControls 'fx/controls'), '--output', $packages)
Invoke-Norm -Arguments @('package', (Join-Path $ui 'ui'), '--output', $packages)
& (Join-Path $uiFx 'gradlew.bat') -p $uiFx publish --console=plain
if ($LASTEXITCODE -ne 0) { throw 'JavaFX layout artifact build failed' }
Copy-Item -Path (Join-Path $uiFx 'build/repository/*') -Destination $maven -Recurse -Force
Invoke-Norm -Arguments @('package', (Join-Path $uiFx 'ui/fx'), '--output', $packages)

& (Join-Path $root 'gradlew.bat') -p $root "-PuiRoot=$ui" publish normDependencies --console=plain
if ($LASTEXITCODE -ne 0) { throw 'Java component artifact build failed' }
Copy-Item -Path (Join-Path $root 'build/repository/*') -Destination $maven -Recurse -Force

$bindingModule = Join-Path $root 'ui/kit/fx/module.norm'
$source = Get-Content -LiteralPath $bindingModule -Raw
$withoutPin = [regex]::Replace($source,
    '(artifact: "ui-component", version: "4"), resolution: sha256\("[a-f0-9]+"\)', '$1')
if ($withoutPin -eq $source -and $source -notmatch 'artifact: "ui-component", version: "4"') {
    throw 'Component Java artifact declaration is missing'
}
if ($withoutPin -ne $source) { Set-Content -LiteralPath $bindingModule -Value $withoutPin -NoNewline }
Invoke-Norm -Arguments @('resolve', (Join-Path $root 'ui/kit/fx'))
Invoke-Norm -Arguments @('package', (Join-Path $root 'ui/kit/fx'), '--output', $packages)
Invoke-Norm -Arguments @('package', (Join-Path $root 'ui/kit'), '--output', $packages)
Invoke-Norm -Arguments @('check', (Join-Path $root 'samples/gallery'))
