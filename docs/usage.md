# ui 与 ui.kit 使用指南

`ui` 提供 Widget、布局、基础元素、主题上下文、状态观察、Binding 和子树协调；`ui.kit` 提供页面控件。桌面窗口、调度和 JavaFX 渲染由 `ui.fx` 实现。应用通常从 `ui.kit` 组合页面，只有自定义原生节点时才需要了解底层投影协议。

当前 kit 使用 JavaFX 后端。这组新模块与所有权能力尚未全部发布；请先使用匹配的开发版 Norm 和已合并的依赖源码，不要假定旧版编译器或现有 Release 可以运行下面的示例。依赖版本的唯一来源是 [示例模块声明](../samples/guide/module.norm)与 [kit 模块声明](../ui/kit/module.norm)，这里不维护第二份版本表。

## 从一个可运行应用开始

完整的 [笔记应用](../samples/guide/application.norm)只有一个窗口与两个 Tab，展示输入、保存、列表和主题切换。入口创建 `ThemeManager`，把 `Notes` 交给 `DesktopApp`，窗口运行结束后在 `finally` 中关闭主题。`App` 是页面的主题根；`DesktopApp` 是窗口入口，二者职责不同。

在本仓库使用 JDK 25 和匹配的 Norm CLI，按 [README 的本地构建入口](../README.md)准备依赖。仓库不在同级目录时，把真实 checkout 路径传给 `prepare.ps1` 对应的 Root 参数。

```powershell
$env:NORM_EXECUTABLE = '你的匹配版 Norm CLI 路径/norm.bat'
./scripts/prepare.ps1
./scripts/norm.ps1 check samples/guide
./scripts/norm.ps1 run samples/guide/application.norm
```

`prepare.ps1` 在本仓库的隔离开发目录打包依赖并准备 Java 制品；`norm.ps1` 使用同一开发目录。因此准备和运行应走同一组脚本。已完整发布后，外部应用可依据模块声明直接解析包，不需要复制组件实现。脚本定义见 [prepare.ps1](../scripts/prepare.ps1)与 [norm.ps1](../scripts/norm.ps1)。

## Widget 与局部状态

实现 `ui.Widget` 的对象通过 `build()` 返回另一个 Widget。`Column`、`Row`、控件和自定义 Widget 都能参与组合；构建器内可使用条件、循环和 `ForEach`。协议定义见 [widget.norm](https://github.com/normlanguage/ui/blob/main/ui/widget.norm)，布局构造入口见 [ui 布局](https://github.com/normlanguage/ui/blob/main/ui/layouts.norm)。

笔记应用把 `draft`、`notes`、`selected` 和 `dark` 保存为 `Notes` 的普通字段。渲染器观察构建期间读取的 class Widget 字段（value Widget 用作值描述）；事件修改字段后，调度器协调界面。没有额外的 `setState` API。需要保留页面局部状态时，保留同一个页面对象；对持有页面状态的对象，直接复用同一个实例最容易表达其生命周期。同类型同 key 的新 class Widget 描述会把公开字段同步到挂载对象，私有局部字段则由挂载对象保留；不要把重新传入的公开字段误当成永不覆盖的局部状态，具体语义见 [对象协调测试](https://github.com/normlanguage/ui/blob/main/ui/tests/test/objects/case.norm)。

`build()` 描述当前界面，不适合启动网络请求、注册长期监听或创建需要手动关闭的宿主资源。Widget 的 `init()` 与 `dispose()` 是挂载与卸载钩子；`build()` 可以多次执行。状态观察和挂载语义以 [ui 实现](https://github.com/normlanguage/ui/tree/main/ui)及其测试为准。

## Binding 与事件

`Binding<T>` 连接读取和写入函数。示例中 `Input` 的 `read` 返回 `draft`，`write` 更新同一个字段；两个方向连接同一份状态。传给 `Text` 的字符串是构建时的展示值，传给可编辑控件的 Binding 则保留写回能力。

示例复用 `save` 方法作为 `Input.submit` 和 `Button.action`：回车和按钮走同一个写入口。按钮的 `enabled` 来自当前状态。控件已经接入挂载作用域的回调管理，普通应用无需额外注册原生 JavaFX 监听器。准确参数与默认值见 [Input](../ui/kit/inputs.norm)和 [Button](../ui/kit/general.norm)。

需要多行输入时使用 [TextArea](https://github.com/normlanguage/ui/blob/main/ui/elements.norm)，敏感文本输入可使用 `Input(password: true)`。只读、禁用和不可编辑是不同行为，应按各控件公开参数表达。

## 列表身份与 Tabs

可插入、删除或重排的列表使用 `ui.ForEach`。示例为笔记内容指定 `ValueKey<String>`，同时阻止重复内容，因此同一层的 key 唯一。实际业务通常选择稳定的记录 ID；内容允许重复时，不能继续用文字作身份。也可由实体的身份字段派生 key，入口见 [foreach.norm](https://github.com/normlanguage/ui/blob/main/ui/foreach.norm)。

`key` 表示节点身份，不是当前索引或随机值。它帮助同类型节点在协调时复用已有的状态与资源；稳定 key 不能替代稳定的状态对象，也不意味着被移除的组件会无限保留。一般静态内容可直接放进 `Column`，不必给每个节点加 key。

[Tabs](../ui/kit/navigation.norm)的 `selected` 使用整数 Binding，必须指向现有页面，且列表至少有一页。示例给 `Tab` 使用明确的 `NodeKey.Named`；未传 key 时默认使用标题，因此重复标题或可变标题宜改用显式稳定 key。

Tab 默认包裹滚动容器，并保留页面节点。页面本身负责滚动，或嵌套另一组 Tabs 时，在外层 `Tab` 设置 `scroll: false`，避免重复滚动。Tabs 默认禁止关闭页面。页面重排保留 key 对应的节点，选中值仍是索引；若希望重排后跟随某个业务页面，应由应用重新计算该索引。

## 主题、App 与 ConfigProvider

[ThemeManager](https://github.com/normlanguage/theme)生成并发布主题；`App(theme: ..., content: ...)`把主题接入控件树并提供组件样式。示例的设置页调用 `setMode` 切换主题，不需要遍历控件设置颜色。

`ui.UiProvider` 为子树提供通用字体、方向和动效配置，设置页示例使用 `UiConfiguration(fontSize: 16.0)`。`ui.kit.ConfigProvider` 提供控件专属的 `KitConfiguration`，定义见 [configuration.norm](../ui/kit/configuration.norm)。`Button` 的 `Tone` 与 `Appearance` 使用 `theme` 的同一套语义类型。主题及通用配置继承入口见 [`ui`](https://github.com/normlanguage/ui/blob/main/ui/configuration.norm)。

`ui.ThemeProvider` 管理主题订阅，`App` / `ConfigProvider` 组合这一协议，不接管调用方共享的 `ThemeManager`。创建主题的应用负责在窗口和渲染树清理之后关闭它。多个页面共享同一个主题时，不要让其中一个页面的 `dispose()` 关闭全局主题。

## 生命周期与原生扩展

普通页面使用 Widget 控件即可。窗口入口管理 Renderer；组件卸载时由渲染树释放其节点、绑定、回调与组件资源。手动使用 Renderer 的扩展应为整个渲染过程提供明确的 `close()` 出口，不要只关闭窗口而留下渲染树。

需要扩展原生控件时，先读 [架构与生命周期](architecture.md)、[`ui.fx` 原生组件桥](https://github.com/normlanguage/ui-fx/blob/main/ui/fx/native.norm)以及 [`ui` 原生视图协议](https://github.com/normlanguage/ui/blob/main/ui/native.norm)。组件创建在 ViewScope 内执行；匹配的 Norm 工具链把 owned 宿主资源接入当前资源所有者，避免同一资源被多个别名重复登记。

借用返回值通过 [ui.kit.fx 的 borrowed 声明](../ui/kit/fx/module.norm)标注，例如宿主的 `node()`。调用方可以使用借用节点，但不能把它当成独立拥有的资源关闭，也不能让它逃逸并在宿主释放后继续使用。新绑定应根据实际所有权声明 borrowed，不要因返回类型是 Node 就推断所有权。此机制需要支持该契约的编译器；旧工具链不能作为等价替代。

## 验证自己的页面

先 `check`，再运行真实控件验证。配套 [定向测试](../samples/guide/tests/test/guide/case.norm)挂载同一个示例 Widget，通过原生按钮执行保存与主题切换，验证列表跨 Tab 保留，并检查运行结束后的清理完成。它不依赖模拟渲染器，也不需要物理鼠标键盘。

```powershell
./scripts/norm.ps1 test samples/guide --filter guide.test.guide
```

在窗口回调中验证时，应在 `run()` 返回后确认完成标志。仅在 `finally` 中关闭窗口不能证明回调内所有断言通过。更深入的状态、原生输入和 Tabs 验证见 [kit 测试](../ui/kit/tests)，其他控件从 [组件索引](components.md)进入，不需要在本文复制全部 API。
