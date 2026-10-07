# ui.fx.kit

[English](README.md) | [简体中文](README.zh-CN.md)

JavaFX components built on [ui](https://github.com/normlanguage/ui), [ui.fx](https://github.com/normlanguage/ui.fx), and [ui.theme](https://github.com/normlanguage/ui.theme).

## Use

```norm
dependency(repository: "github", name: "ui.fx.kit", version: 6)
```

Use the public Norm widgets, bindings and field models defined by [module.norm](ui/fx/kit/module.norm). Native component adapters are private implementation details. Applications that need JavaFX types import `ui.fx.native.*` and use [nativeComponent](https://github.com/normlanguage/ui.fx/blob/main/ui/fx/native.norm).

Layout and UI configuration protocols belong to `ui`; this library provides components and component-specific configuration. Typed form validation and reset are defined in [inputs.norm](ui/fx/kit/inputs.norm).

## Examples

The [gallery](samples/gallery/application.norm) and its [catalog](samples/gallery/catalog.norm) cover the component API. Its [module](samples/gallery/module.norm) resolves released packages by default. Gallery documentation, styling, images and capture support live in a separate sample artifact; they are not part of the production component JAR.

## Build and verify

Run `./scripts/prepare.ps1 -UiRoot <ui-source>` to build the artifacts and verify the pinned component digest and module. Run `./scripts/update-pin.ps1 -UiRoot <ui-source>` intentionally after changing Java artifacts. Verification does not rewrite descriptors. Use an explicit `-NormHome` containing source-built dependencies for integration work; regular descriptors remain released dependency declarations.

Gallery documentation embeds the public UI source from an explicit `-UiRoot` input. Use the `ui@8` release source for published artifact verification. Missing source files fail the build.

[build.gradle.kts](build.gradle.kts) owns Java dependencies, reproducible archives and tests. Java tests generate theme fixtures through [the fixture entry point](samples/fixtures/application.norm), using the canonical `ui.fx.themeCss`. The default test task includes theme rendering contracts. `-PskipThemeFixtures` is available for focused tests that do not use CSS fixtures.

[Norm tests](ui/fx/kit/tests), [Java tests](src/test/java/dev/normlanguage/ui/component), and [gallery window tests](samples/gallery/tests) own executable verification. The [workflow](.github/workflows/package.yml) owns release checks.

## License

[MPL-2.0](LICENSE). Published Java archives carry the license in `META-INF/LICENSE`.
