# 组件索引

组件的名称、构造参数和行为以 [公开 Norm 模块](../ui/fx/kit/module.norm)所导出的源码为准；此页只提供领域入口，避免维护第二份 API 清单。JavaFX 控件的原生实现位于 [Java 源码目录](../src/main/java/dev/normlanguage/ui/component)，与 Norm Widget 的投影边界见 [架构](architecture.md)。

| 领域 | Norm Widget | 交互示例 |
| --- | --- | --- |
| 基础元素 | [ui 元素](https://github.com/normlanguage/ui/blob/main/ui/elements.norm) | [基本示例](../samples/gallery/general.norm) |
| 通用 | [general.norm](../ui/fx/kit/general.norm) | [general.norm](../samples/gallery/general.norm) |
| 分隔控件 | [layout.norm](../ui/fx/kit/layout.norm) | [layout.norm](../samples/gallery/layout.norm) |
| 导航 | [navigation.norm](../ui/fx/kit/navigation.norm) | [navigation.norm](../samples/gallery/navigation.norm) |
| 数据录入 | [inputs.norm](../ui/fx/kit/inputs.norm) | [inputs.norm](../samples/gallery/inputs.norm) |
| 数据展示 | [display.norm](../ui/fx/kit/display.norm) | [display.norm](../samples/gallery/display.norm) |
| 反馈 | [feedback.norm](../ui/fx/kit/feedback.norm) | [overlays.norm](../samples/gallery/overlays.norm) |
| 状态与提示 | [status.norm](../ui/fx/kit/status.norm)、[notices.norm](../ui/fx/kit/notices.norm) | [status.norm](../samples/gallery/status.norm)、[overlays.norm](../samples/gallery/overlays.norm) |
| 根配置与组合 | [configuration.norm](../ui/fx/kit/configuration.norm)、[surface.norm](../ui/fx/kit/surface.norm) | [status.norm](../samples/gallery/status.norm) |

[Norm 组件测试](../ui/fx/kit/tests)覆盖 Widget 入口，[JavaFX 定向测试](../src/test/java/dev/normlanguage/ui/component)覆盖原生控件与投影桥。原生控件需要直接嵌入 JavaFX 应用时，以对应 Java 类为入口；Norm 应用直接使用本表的 Widget。

卡片标题区域的原生验证：[CardLayoutTest](../src/test/java/dev/normlanguage/ui/component/CardLayoutTest.java)。语义颜色参数复用 [`ui.theme`](https://github.com/normlanguage/ui.theme)，组件映射以 [connection.norm](../ui/fx/kit/internal/connection.norm) 为准。
