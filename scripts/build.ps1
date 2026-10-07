param([string]$UiRoot, [string]$NormHome = (Join-Path (Split-Path $PSScriptRoot -Parent) '.norm-home'))
$ErrorActionPreference = 'Stop'
if ([string]::IsNullOrWhiteSpace($UiRoot)) { throw 'Build requires -UiRoot <ui source repository>' }
$root = Split-Path $PSScriptRoot -Parent
$licenseDirectory = Join-Path $root 'ui/fx/kit/resources/META-INF/licenses/ui.fx.kit'
New-Item -ItemType Directory -Force $licenseDirectory | Out-Null
Copy-Item -LiteralPath (Join-Path $root 'LICENSE') -Destination (Join-Path $licenseDirectory 'LICENSE') -Force
& (Join-Path $root 'gradlew.bat') -p $root publish normDependencies "-PuiRoot=$UiRoot" --console=plain
if ($LASTEXITCODE -ne 0) { throw 'Component build failed' }
$maven = Join-Path $NormHome '.norm/cache/maven'
New-Item -ItemType Directory -Force $maven | Out-Null
Copy-Item -Path (Join-Path $root 'build/repository/*') -Destination $maven -Recurse -Force
