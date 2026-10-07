# 应用开发与能力验收

[应用入口](../samples/README.zh-CN.md)提供任务、订单和文件处理三个独立软件。组件教学仍以 [Gallery](../samples/gallery) 为入口。

## 数据与身份

业务数据保留在应用模型中，通过 `Binding` 连接控件。表单控制器保存验证信息与提交基线，不另存一份待编辑数据。每个编辑器在初始化时创建稳定的控制器，页面构建只描述视图。可运行用法见[订单编辑器](../samples/orders/application.norm)与[表单示例](../samples/gallery/inputs.norm)。

编辑器切换业务记录时，用 `ui.Keyed` 包裹整个有局部状态的编辑器；同 key 保留状态，换 key 释放旧实例并重新初始化。给内部 Card 设置 key 不会重置外层编辑器。实现与生命周期契约见 [ui.Widget](https://github.com/normlanguage/ui/blob/main/ui/widget.norm)。

表格列使用稳定 `id`，标题只用于展示。行使用业务身份函数；标题、金额、排序位置不作为记录 ID。比较规则直接比较业务行，与文本格式和单元格 Widget 分离。没有比较规则的列不可排序。公共 API 以 [Table / TableColumn / TableSort](../ui/desktop/kit/display.norm) 为准。

`Listy` 使用固定行高和业务身份，仅为可见行构建 Widget。行离开可见区域后，局部作用域可以释放；需要跨滚动保留的编辑内容应放在应用模型中。不能把单元格局部状态当作业务数据仓库。行更新、排序和关闭验证见 [Norm 显示测试](../ui/desktop/kit/tests/test/display/case.norm)与 [Java 虚拟行测试](../src/test/java/dev/normlanguage/ui/component/ListyRowsTest.java)。

## 表单提交

[FormController 与 FormSubmission](../ui/desktop/kit/form.norm)定义提交规则：控制器验证字段后交出一次性提交票据，应用在操作成功、字段拒绝或取消时结束票据。处于提交中时不再发起同一个表单的第二次提交。

提交基线是开始提交时的字段快照。操作完成前用户继续编辑的内容仍是未保存更改，不能因先前请求成功而被当作已保存。服务端字段错误只用于仍匹配提交快照的字段，未知字段名会明确报错。表单卸载或替换控制器会使旧票据失效。

票据取消只结束表单的等待状态。实际工作仍由应用通过现有组件作用域任务管理；后台任务的完成处理应回到 UI 作用域，不能在工作线程直接修改表单或控件。任务取消、底层业务是否已经提交，以及失败后的重试，由对应操作定义。参考[字段与提交测试](../ui/desktop/kit/tests/test/inputs/case.norm)及[原生输入与卸载测试](../ui/desktop/kit/tests/test/inputs_runtime/case.norm)。

## 窗口与任务

桌面入口的 `onCloseRequested` 接收一次性 `CloseRequest`。未保存时可以先展示确认，选择继续编辑则取消请求，选择退出则接受请求。重复关闭请求不会创建第二个待决确认；程序主动关闭仍走原有清理流程。实现与验收由 [ui.desktop](https://github.com/normlanguage/ui.desktop/blob/main/ui/desktop/desktop.norm)维护。

文件工作台使用现有 `ViewScope` 与任务 API。文件写入成功、取消请求和任务实际终止是不同事件；取消后等待终止再确定资源已释放。[文件处理源码与测试](../samples/jobs)提供真实文件证据，未实现网络下载或断点续传。

## 验收边界与后续能力

| 场景 | 可执行证据 | 尚需独立设计的能力 |
| --- | --- | --- |
| 本地任务 | [原子存储与原生按钮测试](../samples/tasks/tests) | 多设备同步、复杂详情编辑 |
| 订单编辑 | [筛选、金额与表单测试](../samples/orders/tests) | 当前为会话内数据；持久化、服务端分页、批量操作与权限 |
| 文件任务 | [文件内容与取消测试](../samples/jobs/tests) | 网络协议、断点续传、大规模吞吐指标 |
| 虚拟单元格 | [真实窗口显示测试](../ui/desktop/kit/tests/test/display/case.norm) | 可变行高及不同规模下的系统性能基线 |

测试证明其覆盖的行为，不代表所有业务能力或性能指标已完成。Web 共用 `ui` 协议，由 `ui.web` 实现后端；这些 JavaFX 控件不是 Web 组件，不应通过依赖桌面 kit 的方式提供 Web 业务页面。
