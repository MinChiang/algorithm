from __future__ import annotations
from collections import deque
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

    def contains(self, target: T) -> bool:
        node = self.root
        while node is not None:
            if node.value == target:
                return True
            if node.value < target:
                node = node.right
            elif node.value > target:
                node = node.left
        return False

    def delete(self, target: T) -> bool:
        # 判断当前根节点是否为空
        if self.root is None:
            return False

        # 获得删除的目标以及对应的父节点
        current = self.root
        father = None
        while current is not None:
            if current.value == target:
                break
            father = current
            if current.value > target:
                current = current.left
            else:
                current = current.right
        if current is None:
            return False

        # 判断被删除的节点有两个节点的情况
        if current.left is not None and current.right is not None:
            node_father = current
            node = current.right
            while node.left is not None:
                node_father = node
                node = node.left
            current.value = node.value
            if node_father.left is node:
                node_father.left = node.right
            else:
                node_father.right = node.right
            return True

        # 被删除节点只有一个子节点的情况
        if current.left is not None:
            # 获取整个左子树
            child = current.left
        else:
            # 获取整个右子树
            child = current.right

        if father is None:
            # 删除就是根节点的情况，把整个子树返回即可
            self.root = child
        elif father.left is current:
            # 删除的是父节点左子节点，把子树挂到父节点的左节点
            father.left = child
        else:
            # 删除的是父节点的右子节点，把子树挂到父节点的右节点
            father.right = child
        return True

    def insert(self, target: T) -> bool:
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

    def in_order_recursion(self) -> list[T]:
        def _order(current: TreeNode[T] | None, data: list[T]) -> None:
            if current is None:
                return
            _order(current.left, data)
            data.append(current.value)
            _order(current.right, data)

        result: list[T] = []
        _order(self.root, result)
        return result

    def in_order_iteration(self) -> list[T]:
        stack = []
        result = []
        current = self.root
        while stack or current is not None:
            if current is not None:
                stack.append(current)
                current = current.left
                continue
            current = stack.pop()
            result.append(current.value)
            current = current.right
        return result

    def is_valid_bst_iteration(self) -> bool:
        if self.root is None:
            return True
        q = deque()
        q.append((self.root, None, None))
        while q:
            node, lower, upper = q.popleft()
            if (lower is not None and not (lower < node.value)) or (
                upper is not None and not (upper > node.value)
            ):
                return False
            if node.left is not None:
                q.append((node.left, lower, node.value))
            if node.right is not None:
                q.append((node.right, node.value, upper))
        return True

    def is_valid_bst_recursion(self) -> bool:
        def _is_valid(
            node: TreeNode[T] | None, lower: T | None, upper: T | None
        ) -> bool:
            if node is None:
                return True

            if (lower is not None and not (lower < node.value)) or (
                upper is not None and not (upper > node.value)
            ):
                return False

            return _is_valid(node.left, lower, node.value) and _is_valid(
                node.right, node.value, upper
            )

        return _is_valid(self.root, None, None)
