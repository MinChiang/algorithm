class Node[T]:
    def __init__(self, value: T):
        self.value = value
        self.next: None | Node[T] = None


class LinkedList[T]:
    def __init__(self):
        self.head: Node[T] | None = None

    def add_first(self, value: T) -> None:
        node = Node(value)
        node.next = self.head
        self.head = node

    def add_last(self, value: T) -> None:
        node = self.head
        if node is None:
            self.head = Node(value)
            return
        while node.next is not None:
            node = node.next
        node.next = Node(value)

    def get(self, index: int) -> T:
        if index < 0:
            raise IndexError("invalid index")
        count = 0
        node = self.head
        if node is None:
            raise IndexError("invalid index")
        while count != index:
            node = node.next
            count += 1
            if node is None:
                raise IndexError("invalid index")
        return node.value

    def remove(self, index: int) -> T:
        if index < 0:
            raise IndexError("invalid index")
        if index == 0:
            if self.head is None:
                raise IndexError("invalid index")
            result = self.head.value
            self.head = self.head.next
            return result

        count = 0
        node = self.head
        pre = None
        while count != index:
            if node is None:
                raise IndexError("invalid index")
            pre = node
            node = node.next
            count += 1
        if node is None:
            raise IndexError("invalid index")
        assert pre is not None
        pre.next = node.next
        return node.value

    def contains(self, value: T) -> bool:
        node = self.head
        while node is not None:
            if node.value == value:
                return True
            node = node.next
        return False

    def reverse(self) -> None:
        pre = None
        current = self.head
        if current is None or current.next is None:
            return
        next = current.next
        while next is not None:
            current.next = pre
            pre = current
            current = next
            next = current.next
        current.next = pre
        self.head = current

    def middle(self) -> T:
        if self.head is None:
            raise IndexError()
        fast, slow = self.head, self.head
        while fast.next is not None:
            slow = slow.next
            fast = fast.next
            if fast is None:
                break
            else:
                fast = fast.next
        return slow.value
