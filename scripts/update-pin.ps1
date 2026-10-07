param(
    [string]$UiRoot,
    [string]$NormHome = (Join-Path (Split-Path $PSScriptRoot -Parent) '.norm-home'),
    [string]$ModulePath = 'ui/desktop/kit'
)
$ErrorActionPreference = 'Stop'
$root = Split-Path $PSScriptRoot -Parent
& (Join-Path $PSScriptRoot 'build.ps1') -NormHome $NormHome -UiRoot $UiRoot
$module = Join-Path $root ($ModulePath + '/module.norm')
$source = [IO.File]::ReadAllText($module)
$source = [regex]::Replace($source, ', resolution: sha256\("[a-f0-9]+"\)', '')
[IO.File]::WriteAllText($module, $source, [Text.UTF8Encoding]::new($false))
$previous = $env:JAVA_TOOL_OPTIONS
try {
    $env:JAVA_TOOL_OPTIONS = "$previous --enable-native-access=ALL-UNNAMED -Duser.home=`"$NormHome`""
    $executable = if ($env:NORM_EXECUTABLE) { $env:NORM_EXECUTABLE } else { 'norm' }
    & $executable resolve (Join-Path $root $ModulePath)
    if ($LASTEXITCODE -ne 0) { throw 'Resolution update failed' }
} finally { $env:JAVA_TOOL_OPTIONS = $previous }
