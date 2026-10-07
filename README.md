# ui.fx.kit

`ui.fx.kit` 是面向 Norm 应用的 JavaFX 组件库。公开组件实现 `ui.Widget`，用普通字段保存局部状态，用 `Binding<T>`连接可编辑值；`ui` 渲染器负责重绘、子树复用与释放。颜色由独立的 [`ui.theme`](https://github.com/normlanguage/ui.theme) 生成。

```norm
import ui.Widget
import ui.Column
import ui.Text
import ui.fx.kit.Button

class SaveExample implements Widget {
  private Integer saves = 0

  Widget build() {
    Column {
      Text(text: "已保存 " + saves.toString() + " 次")
      Button(text: "保存", action: () { saves = saves + 1 })
    }
  }
}
```

从 [ui 与 ui.fx.kit 使用指南](docs/usage.md)开始；完整可运行示例位于 [samples/guide](samples/guide)。模块依赖以 [ui.fx.kit/module.norm](ui/fx/kit/module.norm) 为准。

工具链要求见 [使用指南](docs/usage.md)。发布制品使用 `norm package ui/fx/kit --output build/repository` 生成；GitHub Release 提供 `.nar` 与对应 `.sha256`。底层运行依赖由包携带，应用无需复制库源码。

公开入口见 [ui.fx.kit 模块](ui/fx/kit/module.norm)及 [组件索引](docs/components.md)。[Norm 示例](samples/gallery)展示实际交互；可直接使用的 JavaFX 控件和绑定位于 [Java 源码](src/main/java/dev/normlanguage/ui/component)及同包内部绑定 [`internal`](ui/fx/kit/module.norm)。应用代码以 Widget 层为入口，JavaFX 原生扩展通过 [`ui` 原生视图协议](https://github.com/normlanguage/ui)接入同一渲染树。

在 Windows 上运行示例：`.\scripts\gallery.ps1`。验证示例：`.\scripts\gallery.ps1 -Verify`。依赖仓库不在同级目录时可传 `-UiRoot`、`-UiFxRoot`、`-DiRoot`、`-JavaFxRoot` 和 `-ThemeRoot`；DI 绑定仓库也放在 `di` 的同级目录。Norm 编译器默认使用同级 `Norm` 仓库的构建产物，也可用 `NORM_EXECUTABLE` 指定。

本地构建需要 JDK 25。Gradle 解析对应平台的 JavaFX 依赖；定向 Java 验证可运行：

```powershell
.\gradlew.bat compileJava --console=plain
.\gradlew.bat test -PtestSource=NavigationLayoutAdapterTest --tests '*NavigationLayoutAdapterTest' --console=plain
```

模块分层、主题和生命周期边界见 [架构](docs/architecture.md)。

原生开关、动画和绑定验证：[samples/native/application.norm](samples/native/application.norm)。使用 `norm build samples/native/application.norm` 构建并运行产物；该验证无需截图或 AWT。
