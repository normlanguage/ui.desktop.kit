param(
    [switch]$Verify,
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
& (Join-Path $PSScriptRoot 'prepare.ps1') -UiRoot $UiRoot -UiFxRoot $UiFxRoot -DiRoot $DiRoot -FxBaseRoot $FxBaseRoot -FxGraphicsRoot $FxGraphicsRoot -FxControlsRoot $FxControlsRoot -ThemeRoot $ThemeRoot
if ($LASTEXITCODE -ne 0) { throw 'Component preparation failed' }

$sample = Join-Path $root 'samples/gallery'
Push-Location $root
try {
    if ($Verify) {
        & (Join-Path $PSScriptRoot 'norm.ps1') test $sample
    } else {
        & (Join-Path $PSScriptRoot 'norm.ps1') run $sample
    }
    if ($LASTEXITCODE -ne 0) { throw 'Norm gallery failed' }
} finally {
    Pop-Location
}
