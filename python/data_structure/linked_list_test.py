import unittest

from .linked_list import LinkedList


class TestLinkedList(unittest.TestCase):
    def test_add_first(self):
        linked_list = LinkedList[int]()
        linked_list.add_first(1)
        linked_list.add_first(2)
        linked_list.add_first(3)

        self.assertEqual([3, 2, 1], list(linked_list))
        self.assertEqual(3, len(linked_list))

    def test_add_last(self):
        linked_list = LinkedList[int]()
        linked_list.add_last(1)
        linked_list.add_last(2)
        linked_list.add_last(3)

        self.assertEqual([1, 2, 3], list(linked_list))
        self.assertEqual(3, len(linked_list))

    def test_get(self):
        linked_list = self._create_linked_list(1, 2, 3)

        self.assertEqual(1, linked_list.get(0))
        self.assertEqual(2, linked_list.get(1))
        self.assertEqual(3, linked_list.get(2))

    def test_get_rejects_invalid_index(self):
        linked_list = self._create_linked_list(1, 2, 3)

        with self.assertRaises(IndexError):
            linked_list.get(-1)
        with self.assertRaises(IndexError):
            linked_list.get(3)

    def test_get_from_empty_list_raises_index_error(self):
        linked_list = LinkedList[int]()

        with self.assertRaises(IndexError):
            linked_list.get(0)

    def test_remove_middle(self):
        linked_list = self._create_linked_list(1, 2, 3)

        removed = linked_list.remove(1)

        self.assertEqual(2, removed)
        self.assertEqual([1, 3], list(linked_list))
        self.assertEqual(2, len(linked_list))

    def test_remove_first_and_last(self):
        linked_list = self._create_linked_list(1, 2, 3)

        self.assertEqual(1, linked_list.remove(0))
        self.assertEqual(3, linked_list.remove(1))
        self.assertEqual([2], list(linked_list))
        self.assertEqual(1, len(linked_list))

    def test_remove_only_node(self):
        linked_list = self._create_linked_list(1)

        self.assertEqual(1, linked_list.remove(0))
        self.assertEqual([], list(linked_list))
        self.assertEqual(0, len(linked_list))

    def test_remove_rejects_invalid_index(self):
        linked_list = self._create_linked_list(1, 2, 3)

        with self.assertRaises(IndexError):
            linked_list.remove(-1)
        with self.assertRaises(IndexError):
            linked_list.remove(3)

        self.assertEqual([1, 2, 3], list(linked_list))
        self.assertEqual(3, len(linked_list))

    def test_contains(self):
        linked_list = self._create_linked_list(1, 2, 3)

        self.assertTrue(linked_list.contains(1))
        self.assertTrue(linked_list.contains(2))
        self.assertTrue(linked_list.contains(3))
        self.assertFalse(linked_list.contains(4))
        self.assertIn(2, linked_list)
        self.assertNotIn(4, linked_list)

    def test_reverse(self):
        linked_list = self._create_linked_list(1, 2, 3)

        linked_list.reverse()

        self.assertEqual([3, 2, 1], list(linked_list))
        self.assertEqual(3, len(linked_list))

    def test_reverse_empty_and_single_node_lists(self):
        empty = LinkedList[int]()
        single = self._create_linked_list(1)

        empty.reverse()
        single.reverse()

        self.assertEqual([], list(empty))
        self.assertEqual([1], list(single))

    def test_middle_of_odd_length_list(self):
        linked_list = self._create_linked_list(1, 2, 3)

        self.assertEqual(2, linked_list.middle())

    def test_middle_of_even_length_list_returns_right_middle(self):
        linked_list = self._create_linked_list(1, 2, 3, 4)

        self.assertEqual(3, linked_list.middle())

    def test_middle_of_single_and_empty_lists(self):
        single = self._create_linked_list(1)
        empty = LinkedList[int]()

        self.assertEqual(1, single.middle())
        self.assertIsNone(empty.middle())

    def test_dunder_methods(self):
        linked_list = self._create_linked_list(1, 2, 3)

        self.assertEqual(3, len(linked_list))
        self.assertEqual(2, linked_list[1])
        self.assertEqual([1, 2, 3], list(iter(linked_list)))
        self.assertEqual("LinkedList(size=3,nodes=[1,2,3])", repr(linked_list))
        self.assertEqual(repr(linked_list), str(linked_list))

    @staticmethod
    def _create_linked_list(*values: int) -> LinkedList[int]:
        linked_list = LinkedList[int]()
        for value in values:
            linked_list.add_last(value)
        return linked_list


if __name__ == "__main__":
    unittest.main()
