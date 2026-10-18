from __future__ import annotations
from typing import Protocol, Self


class SupportLessThan(Protocol):
    def __lt__(self, other: Self, /): ...


class TreeNode[T: SupportLessThan]:
    def __init__(
        self,
        value: T,
        left: TreeNode[T] | None = None,
        right: TreeNode[T] | None = None,
    ) -> None:
        self.value = value
        self.left = left
        self.right = right


class BSTTree[T: SupportLessThan]:
    def __init__(self, root: TreeNode[T]):
        self.root = root

    def bst_contain(self, target: T) -> bool:
        node = self.root
        while node is not None:
            if node.value == target:
                return True
            if node.value < target:
                node = node.right
            elif node.value > target:
                node = node.left
        return False

    def bst_insert(self, target: T) -> bool:
        node = TreeNode(target)
        if self.root is None:
            self.root = node
            return True
        current = self.root
        while True:
            if current.value < target:
                if current.right is None:
                    current.right = node
                    return True
                current = current.right
            elif current.value > target:
                if current.left is None:
                    current.left = node
                    return True
                current = current.left
            else:
                return False
