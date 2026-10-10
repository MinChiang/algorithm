import pytest

from data_structure.stack import Stack


def test_stack_is_last_in_first_out():
    stack = Stack[int]()
    stack.push(10)
    stack.push(20)

    assert stack.pop() == 20
    assert stack.pop() == 10
    assert stack.is_empty()

    with pytest.raises(IndexError):
        stack.pop()
