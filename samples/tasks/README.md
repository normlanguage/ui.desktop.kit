# Tasks

A desktop task list with stable record identity, completion, search, local JSON persistence and unsaved-close confirmation. Duplicate titles are permitted. Failed saves retain the current edits.

Prepare the candidate dependencies using the [repository instructions](../../README.md), then run `./scripts/norm.ps1 run samples/tasks`. Data is stored in `tasks.json` under the application directory; the application does not automatically save edits on exit.

Run `./scripts/norm.ps1 test samples/tasks --filter tasks.test.storage` and `./scripts/norm.ps1 test samples/tasks --filter tasks.test.workflow`. Tests write only under `build/acceptance`, verify actual file contents and exercise native buttons in a real JavaFX window.

[Application](application.norm) · [Persistence](storage.norm) · [Module](module.norm)
