# ui.fx.kit

[English](README.md) | [简体中文](README.zh-CN.md)

基于 [ui](https://github.com/normlanguage/ui)、[ui.fx](https://github.com/normlanguage/ui.fx)和 [ui.theme](https://github.com/normlanguage/ui.theme)的 JavaFX 组件库。

## 使用

```norm
dependency(repository: "github", name: "ui.fx.kit", version: 6)
```

公开 Norm 控件、绑定与字段模型由 [module.norm](ui/fx/kit/module.norm)定义。原生组件适配器属于内部实现。应用需要 JavaFX 类型时，使用 `ui.fx.native.*` 与 [nativeComponent](https://github.com/normlanguage/ui.fx/blob/main/ui/fx/native.norm)。

布局与通用 UI 配置协议属于 `ui`；本库提供业务控件和组件专属配置。类型化表单的验证与重置以 [inputs.norm](ui/fx/kit/inputs.norm)为准。

## 示例

[组件示例](samples/gallery/application.norm)与[目录](samples/gallery/catalog.norm)展示组件 API。[示例模块](samples/gallery/module.norm)默认解析正式发布包。示例文档、样式、图片和截图支持位于独立示例产物，不进入组件生产 JAR。

## 构建与验证

运行 `./scripts/prepare.ps1 -UiRoot <ui-source>` 构建产物并验证固定摘要和模块；修改 Java 产物后，明确运行 `./scripts/update-pin.ps1 -UiRoot <ui-source>` 更新摘要。验证不会重写模块声明。联调源码时，显式提供已装入源码依赖包的 `-NormHome`；常规声明始终指向正式依赖。

示例文档源码使用显式 `-UiRoot` 输入；发布归档使用 `ui@8` 发布源码，缺失文件会中止构建。

[build.gradle.kts](build.gradle.kts)统一管理 Java 依赖、可复现归档与测试。Java 测试通过[主题样本入口](samples/fixtures/application.norm)调用唯一的 `ui.fx.themeCss` 生成样式，默认测试任务包含主题渲染契约。不读取主题样本的定向测试可使用 `-PskipThemeFixtures`。

验证索引：[Norm 测试](ui/fx/kit/tests)、[Java 测试](src/test/java/dev/normlanguage/ui/component)、[示例窗口测试](samples/gallery/tests)。[工作流](.github/workflows/package.yml)负责发布检查。

## 许可证

[MPL-2.0](LICENSE)。发布 Java 归档在 `META-INF/LICENSE` 携带许可证。
