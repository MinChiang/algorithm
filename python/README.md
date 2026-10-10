# Python

这是独立的 Python 3.12 练习目录：

- `data_structure/`：数据结构实现。
- `algorithm/`：算法实现。
- `tests/`：测试。
- `pyproject.toml`：Pyright 配置。

在仓库根目录运行现有测试：

```powershell
python -m unittest discover -s python/tests -p 'test_*.py' -v
```

也可以进入 `python/` 后运行 `python -m unittest discover -s tests -p 'test_*.py' -v`。现有树的测试目前只有一个占位方法，尚未覆盖树的实际行为。
