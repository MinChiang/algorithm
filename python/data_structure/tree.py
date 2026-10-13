from __future__ import annotations

from collections import deque


class TreeNode[T]:
    def __init__(
        self,
        value: T,
        left: TreeNode[T] | None = None,
        right: TreeNode[T] | None = None,
    ) -> None:
        self.value = value
        self.left = left
        self.right = right


class Tree[T]:
    def __init__(self, root: TreeNode[T]):
        self.root = root

    @classmethod
    def from_list(cls, data: list[T | None]) -> Tree[T]:
        if not data:
            raise IndexError()
        if data[0] is None:
            raise IndexError("first data element can not be None")
        node = TreeNode(data[0])
        result = cls(node)
        q = deque()
        q.append(node)
        index = 1
        while q:
            node = q.popleft()
            if index < len(data) and data[index] is not None:
                left = TreeNode(data[index])
                node.left = left
                q.append(left)
            if index + 1 < len(data) and data[index + 1] is not None:
                right = TreeNode(data[index + 1])
                node.right = right
                q.append(right)
            index += 2
        return result

    @classmethod
    def from_list_recursion(cls, data: list[T | None]) -> Tree[T]:
        def build(index: int, size: int) -> TreeNode[T] | None:
            if index >= size:
                return None
            value = data[index]
            if value is None:
                return None
            node = TreeNode(value)
            node.left = build(index * 2 + 1, size)
            node.right = build(index * 2 + 2, size)
            return node

        root = build(0, len(data))
        if root is None:
            raise ValueError("first elment can not be None")
        return cls(root)

    def hierarchy_traversal(self) -> list[list[T]]:
        result: list[list[T]] = []
        q = deque()
        q.append(self.root)
        while q:
            hierarchy = []
            for _ in range(len(q)):
                node = q.popleft()
                if node is not None:
                    hierarchy.append(node.value)
                    q.append(node.left)
                    q.append(node.right)
            result.append(hierarchy)
        return result

    def __repr__(self) -> str:
        data = self.hierarchy_traversal()
        return "\n".join(",".join(map(str, row)) for row in data)

    def pre_order_recursion(self) -> list[T]:
        def _order(result: list[T], node: TreeNode[T] | None):
            while node:
                result.append(node.value)
                _order(result, node.left)
                _order(result, node.right)

        result: list[T] = []
        _order(result, self.root)
        return result

    def in_order_recursion(self) -> list[T]:
        def _order(result: list[T], node: TreeNode[T] | None):
            while node:
                _order(result, node.left)
                result.append(node.value)
                _order(result, node.right)

        result: list[T] = []
        _order(result, self.root)
        return result

    def post_order_recursion(self) -> list[T]:
        def _order(result: list[T], node: TreeNode[T] | None):
            while node:
                _order(result, node.left)
                _order(result, node.right)
                result.append(node.value)

        result = []
        _order(result, self.root)
        return result

    def pre_order_iteration(self) -> list[T]:
        if self.root is None:
            return []
        result: list[T] = []
        stack = [self.root]
        while stack:
            node = stack.pop()
            result.append(node.value)
            if node.right is not None:
                stack.append(node.right)
            if node.left is not None:
                stack.append(node.left)
        return result

    def post_order_iteration(self) -> list[T]:
        if self.root is None:
            return []
        tmp: list[T] = []
        stack = [self.root]
        while stack:
            node = stack.pop()
            tmp.append(node.value)
            if node.left is not None:
                stack.append(node.left)
            if node.right is not None:
                stack.append(node.right)
        result: list[T] = []
        while tmp:
            result.append(tmp.pop())
        return result

    def in_order_iteration(self) -> list[T]:
        if self.root is None:
            return []
        stack: list[TreeNode[T]] = []
        result: list[T] = []
        node = self.root
        while node is not None or stack:
            while node is not None:
                stack.append(node)
                node = node.left
            node = stack.pop()
            result.append(node.value)
            node = node.right
        return result
