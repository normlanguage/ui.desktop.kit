# Orders

A JavaFX order workspace using `ui.fx.kit`. Orders use stable IDs, exact decimal totals, typed status, and independently sortable table columns. The detail form validates edits and tracks the last accepted save. Data lives in the current session.

From the repository root after preparing the local packages:

```powershell
./scripts/norm.ps1 run samples/orders
./scripts/norm.ps1 test samples/orders
```

The entry point and UI are in [application.norm](application.norm), domain data in [model.norm](model.norm), model acceptance in [workflow tests](tests/test/workflow/case.norm), and native input and form acceptance in [window tests](tests/test/runtime/case.norm).
