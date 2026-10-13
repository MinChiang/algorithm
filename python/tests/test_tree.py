import pytest

from data_structure.tree import Tree, TreeNode


def test_from_list_recursion_when_data_empty() -> None:
    tree: Tree[int] = Tree.from_list_recursion(["A", "B", "C", "D", "E"])
    print(tree.in_order_iteration())
