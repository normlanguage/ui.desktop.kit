# 架构与生命周期

公开模块与依赖以 [`ui.kit` 声明](../ui/kit/module.norm)和 [`ui.kit.fx` 绑定声明](../ui/kit/fx/module.norm)为准。当前职责边界如下：

| 层 | 唯一职责 | 源码入口 |
| --- | --- | --- |
| `ui.kit` | 面向页面的控件与组合式子内容 | [组件模块](../ui/kit) |
| `ui` / `ui.fx` | `ui` 定义组件协议、布局、基础元素、主题上下文、状态和协调；`ui.fx` 实现 JavaFX 后端、调度和桌面入口 | [`ui` 仓库](https://github.com/normlanguage/ui) / [`ui.fx` 仓库](https://github.com/normlanguage/ui-fx) |
| `ui.kit.fx` | 将控件 JAR 和少量强类型投影桥暴露给 Norm Widget 实现 | [绑定声明](../ui/kit/fx/module.norm) / [投影适配器](../src/main/java/dev/normlanguage/ui/component/NavigationLayoutAdapter.java) |
| JavaFX 控件 JAR | 原生控件节点、属性、弹层与资源释放 | [Java 源码](../src/main/java/dev/normlanguage/ui/component) |
| `theme` | 由少量输入色生成完整主题；组件只消费结果 | [`theme` 仓库](https://github.com/normlanguage/theme) / [主题连接](../ui/kit/fx/connection.norm) |

Widget 普通字段由 `ui` 观察；字段变化重建描述，同类同键的原生节点和子节点由渲染器保留。组件专属 JavaFX 投影及作用域接入以 [原生组件桥](https://github.com/normlanguage/ui-fx/blob/main/ui/fx/native.norm) 为准；宿主返回值的借用契约以 [绑定声明](../ui/kit/fx/module.norm) 为准。原生 JavaFX 资源仍由相应控件的 `close()` 或 [通用关闭入口](../src/main/java/dev/normlanguage/ui/component/Util.java)处理。复杂容器把 Norm 子 Widget 交给统一子树协调，再把最终 JavaFX 节点列表投影进原生布局。

主题继承与订阅由 [`ui.ThemeProvider`](https://github.com/normlanguage/ui/blob/main/ui/theme.norm)和统一渲染器管理；kit 的 App 与 ConfigProvider 只组合这一协议及控件专属配置。公开配置定义见 [configuration.norm](../ui/kit/configuration.norm)，公共配置的控件接入见 [component_bridge.norm](../ui/kit/component_bridge.norm)，原生投影见 [ComponentConfig](../src/main/java/dev/normlanguage/ui/component/ComponentConfig.java)，后端颜色映射见 [`ui.fx` 主题桥](https://github.com/normlanguage/ui-fx/blob/main/ui/fx/theme.norm)，控件样式见 [components.css](../src/main/resources/dev/normlanguage/ui/component/components.css)。JavaFX 节点变更、弹层显示和关闭在 JavaFX 应用线程执行。

日期、时间和其他 JDK 类型由 [`java.base`](https://github.com/normlanguage/Norm/blob/main/norm/stdlib/java/base/module.norm) 定义。组件范围以 [模块导出](../ui/kit/module.norm)和 [Gallery 示例](../samples/gallery)为索引，实际交互验证见 [Norm 测试](../ui/kit/tests)及 [Java 测试](../src/test/java/dev/normlanguage/ui/component)。
