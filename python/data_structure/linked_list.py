class Node[T]:
    def __init__(self, value: T):
        self.value: T = value
        self.next: Node[T] | None = None


class LinkedList[T]:
    def __init__(self):
        self.head: Node[T] | None = None
        self.size: int = 0

    def add_first(self, value: T) -> None:
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node
        self.size += 1

    def add_last(self, value: T) -> None:
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            self.size = 1
            return
        node = self.head
        while node.next is not None:
            node = node.next
        node.next = new_node
        self.size += 1

    def get(self, index: int) -> T:
        if index < 0 or self.size <= index:
            raise IndexError()
        node = self.head
        for _ in range(index):
            node = node.next
        return node.value

    def reverse(self) -> None:
        pre = None
        current = self.head

        while current is not None:
            next_node = current.next
            current.next = pre
            pre = current
            current = next_node
        self.head = pre

    def remove(self, index: int) -> T:
        if index < 0 or self.size <= index:
            raise IndexError()
        if index == 0:
            removed = self.head
            self.head = self.head.next
        else:
            prev = self.head
            for _ in range(index - 1):
                prev = prev.next
            removed = prev.next
            prev.next = removed.next
        self.size -= 1
        return removed.value

    def contains(self, value: T) -> bool:
        node = self.head
        while node is not None:
            if node.value == value:
                return True
            node = node.next
        return False

    def middle(self) -> T | None:
        if self.size == 0:
            return None
        slow = self.head
        fast = self.head
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            slow = slow.next
        return slow.value

    def __repr__(self) -> str:
        nodes = []
        current = self.head
        while current is not None:
            nodes.append(repr(current.value))
            current = current.next
        return f"LinkedList(size={self.size},nodes=[{','.join(nodes)}])"

    def __str__(self) -> str:
        return repr(self)

    def __len__(self) -> int:
        return self.size

    def __contains__(self, value: T) -> bool:
        return self.contains(value)
    
    def __getitem__(self, index: int) -> T:
        return self.get(index)

    def __iter__(self):
        current = self.head
        while current is not None:
            yield current.value
            current = current.next
