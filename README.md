# 数据结构与算法练习

本仓库按语言划分为两个独立子工程。进入对应目录后，使用各自的工具运行和学习。

```text
algorithm/
├── java/                  # Maven 工程；目前主要是 LeetCode 题解
│   ├── pom.xml
│   └── src/main/java/com/algorithm/leetcode/
│       ├── common/        # 题解共用的节点类型
│       └── editor/cn/     # LeetCode 题解
└── python/                # Python 3.12 练习
    ├── pyproject.toml     # Python 类型检查配置
    ├── data_structure/    # 数据结构实现
    ├── algorithm/         # 算法实现
    └── tests/             # Python 测试
```

具体运行命令见 [Java 说明](java/README.md) 和 [Python 说明](python/README.md)。

新增内容时，先放进对应语言的子工程；Python 实现按数据结构或算法归档，测试放在 `python/tests/`。Java 题解沿用现有包名，避免破坏已有的类与导入。
