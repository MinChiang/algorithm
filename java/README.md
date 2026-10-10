# Java

这是独立的 Maven 工程，`pom.xml` 在本目录。当前代码主要是 LeetCode 题解：

- `src/main/java/com/algorithm/leetcode/editor/cn/`：按题目命名的解答。
- `src/main/java/com/algorithm/leetcode/common/`：题解共用的节点类型。

在仓库根目录编译：

```powershell
mvn -f java/pom.xml compile
```

也可以在 `java/` 目录运行 `mvn compile`。新建 Java 代码时，按现有包路径放入 `src/main/java/`；若添加测试，放入 `src/test/java/` 下对应的包目录。
