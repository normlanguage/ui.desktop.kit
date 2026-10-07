param(
    [string]$UiRoot,
    [switch]$Verify,
    [string]$NormHome = (Join-Path (Split-Path $PSScriptRoot -Parent) '.norm-home')
)
$ErrorActionPreference = 'Stop'
$root = Split-Path $PSScriptRoot -Parent
& (Join-Path $PSScriptRoot 'prepare.ps1') -NormHome $NormHome -UiRoot $UiRoot
$previous = $env:JAVA_TOOL_OPTIONS
Push-Location $root
try {
    $env:JAVA_TOOL_OPTIONS = "$previous --enable-native-access=ALL-UNNAMED -Duser.home=`"$NormHome`""
    $executable = if ($env:NORM_EXECUTABLE) { $env:NORM_EXECUTABLE } else { 'norm' }
    if ($Verify) { & $executable test samples/gallery }
    else { & $executable run samples/gallery }
    if ($LASTEXITCODE -ne 0) { throw 'Gallery failed' }
} finally {
    $env:JAVA_TOOL_OPTIONS = $previous
    Pop-Location
}
