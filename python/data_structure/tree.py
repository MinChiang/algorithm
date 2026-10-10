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
        while not q:
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
