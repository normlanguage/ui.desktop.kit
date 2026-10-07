# 文件任务工作台

从仓库根目录运行：

```powershell
./scripts/norm.ps1 run samples/jobs
./scripts/norm.ps1 test samples/jobs --filter jobs.test.jobs
```

初始任务使用 [source.txt](data/source.txt)。添加任务前可以填写其他 UTF-8 源文件及输出目录。每个任务在独立目录导出 200 个文件。取消保留已经提交的文件；重试按相同编号原子替换。源文件最大为 1 MiB。

[application.norm](application.norm) 管理 UI 状态、任务归属、重试身份和退出确认。[batch.norm](batch.norm) 管理文件操作。[测试](tests/test/jobs/case.norm) 验证真实输出、取消、重复启动与 JavaFX 应用流程。

[English](README.md)
