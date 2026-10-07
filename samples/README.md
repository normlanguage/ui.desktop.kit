# Examples

[简体中文](README.zh-CN.md)

Use the [repository build instructions](../README.md) once, then run the commands below from the repository root. Module declarations own dependency versions. Source development requires the matching candidate packages in the same development home.

| Example | Run | Purpose and observable result |
| --- | --- | --- |
| [Tasks](tasks/README.md) | `./scripts/norm.ps1 run samples/tasks` | Add tasks with duplicate titles, mark completion, filter and save to a local file; unsaved changes guard window closure |
| [Orders](orders/README.md) | `./scripts/norm.ps1 run samples/orders` | Sort exact decimal amounts, filter records and edit through a validated form; submission establishes the saved baseline |
| [File jobs](jobs/README.md) | `./scripts/norm.ps1 run samples/jobs` | Process real local files with progress, cancellation, retry and virtualized rows |
| [Notes guide](../docs/usage.md) | `./scripts/norm.ps1 run samples/guide` | A small introduction to binding, tabs and theme switching |
| [Component gallery](gallery/application.norm) | `./scripts/gallery.ps1 -UiRoot <ui-source>` | Explore individual controls and their source examples |

The application examples own their domain behavior and storage decisions. They consume the public component APIs; they are not alternate component implementations. Their tests remain beside their application sources.

[Theme fixtures](fixtures/application.norm) generate test input for the shared theme rendering tests. [Native example](native/application.norm) demonstrates platform extension and is separate from the normal Widget composition path.
