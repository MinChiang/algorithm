from __future__ import annotations

import queue


class TreeNode[T]:
    def __init__(
        self,
        value: T,
        left: TreeNode[T] | None = None,
        right: TreeNode[T] | None = None,
    ) -> None:
        self.left = left
        self.right = right
        self.value = value


class Tree[T]:
    def __init__(self, root: TreeNode[T]):
        self.root = root

    @classmethod
    def from_list(cls, data: list[T]) -> Tree[T]:
        node = TreeNode(data[0])
        result = cls(node)
        q = queue.Queue()
        q.put(node)
        index = 1
        while node is not None:
            if index < len(data):
                left = TreeNode(data[index])
                node.left = left
                q.put(left)
            if index + 1 < len(data):
                right = TreeNode(data[index + 1])
                node.right = right
                q.put(right)
            index += 2
            node = q.get()
        return result
