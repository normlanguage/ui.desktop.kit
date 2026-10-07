param([string]$NormHome = (Join-Path (Split-Path $PSScriptRoot -Parent) '.norm-home'))
$ErrorActionPreference = 'Stop'
$root = Split-Path $PSScriptRoot -Parent
$module = Join-Path $root 'ui/fx/kit/module.norm'
$source = [IO.File]::ReadAllText($module)
if ($source -notmatch 'resolution: sha256\("[a-f0-9]{64}"\)') { throw 'Module resolution is not pinned; use update-pin.ps1 intentionally' }
& (Join-Path $PSScriptRoot 'build.ps1') -NormHome $NormHome
$previous = $env:JAVA_TOOL_OPTIONS
try {
    $env:JAVA_TOOL_OPTIONS = "$previous --enable-native-access=ALL-UNNAMED -Duser.home=`"$NormHome`""
    $executable = if ($env:NORM_EXECUTABLE) { $env:NORM_EXECUTABLE } else { 'norm' }
    & $executable check (Join-Path $root 'ui/fx/kit')
    if ($LASTEXITCODE -ne 0) { throw 'Module check failed' }
} finally { $env:JAVA_TOOL_OPTIONS = $previous }
if ([IO.File]::ReadAllText($module) -ne $source) { throw 'Verification changed the module descriptor' }
