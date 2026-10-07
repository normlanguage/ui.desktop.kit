# File task workbench

Run from the repository root:

```powershell
./scripts/norm.ps1 run samples/jobs
./scripts/norm.ps1 test samples/jobs --filter jobs.test.jobs
```

The initial job uses [source.txt](data/source.txt). Enter a different UTF-8 source file and output directory before adding another job. Each job exports 200 files under its own directory. Cancelling preserves files already committed; retrying replaces the same numbered files atomically. Sources are limited to 1 MiB.

[application.norm](application.norm) owns UI state, task ownership, retry identities and the close decision. [batch.norm](batch.norm) owns filesystem operations. [Tests](tests/test/jobs/case.norm) cover actual output, cancellation, repeated start and the JavaFX application flow.

[中文](README.zh-CN.md)
