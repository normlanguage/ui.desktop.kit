# 示例

[English](README.md)

先按[仓库构建入口](../README.zh-CN.md)准备环境，再从仓库根目录运行下列命令。依赖版本以各示例的模块声明为准；源码联调需要把对应候选包装入同一开发缓存。

| 示例 | 启动 | 用途与可观察结果 |
| --- | --- | --- |
| [任务管理器](tasks/README.md) | `./scripts/norm.ps1 run samples/tasks` | 添加同名任务、完成、筛选和本地保存；未保存时拦截窗口关闭 |
| [订单管理台](orders/README.md) | `./scripts/norm.ps1 run samples/orders` | 精确金额排序、记录筛选和表单编辑；提交成功后更新保存基线 |
| [文件任务工作台](jobs/README.md) | `./scripts/norm.ps1 run samples/jobs` | 真实文件处理、进度、取消、重试和虚拟行呈现 |
| [笔记入门](../docs/usage.md) | `./scripts/norm.ps1 run samples/guide` | 学习绑定、分页签与主题切换 |
| [组件目录](gallery/application.norm) | `./scripts/gallery.ps1 -UiRoot <ui-source>` | 查看单个控件的效果与示例源码 |

应用示例自己定义业务行为和存储策略，调用公共组件 API，不复制组件实现。测试与对应应用代码放在一起。

[主题样本](fixtures/application.norm)为统一主题渲染测试生成输入。[原生扩展示例](native/application.norm)单独说明平台扩展入口，常规页面使用 Widget 组合。
