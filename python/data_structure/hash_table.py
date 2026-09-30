class Node[K, V]:
    def __init__(self, key: K, value: V):
        self.key = key
        self.value = value

    def __repr__(self) -> str:
        return f"({self.key}, {self.value})"


class HashMap[K, V]:
    def __init__(self, capacity: int = 8):
        if capacity <= 0:
            raise ValueError()
        self.capacity: int = capacity
        self.data: list[list[Node[K, V]]] = [[] for _ in range(capacity)]
        self._size = 0

    def put(self, key: K, value: V) -> V | None:
        index: int = hash(key) % self.capacity
        chain: list[Node[K, V]] = self.data[index]
        for item in chain:
            if item.key == key:
                old = item.value
                item.value = value
                return old

        self._resize()

        index: int = hash(key) % self.capacity
        chain: list[Node[K, V]] = self.data[index]
        chain.append(Node(key, value))
        self._size += 1
        return None

    def get(self, key: K) -> V | None:
        index: int = hash(key) % self.capacity
        chain: list[Node[K, V]] = self.data[index]
        for item in chain:
            if item.key == key:
                return item.value
        return None

    def remove(self, key: K) -> V | None:
        index: int = hash(key) % self.capacity
        chain: list[Node[K, V]] = self.data[index]
        for i, item in enumerate(chain):
            if item.key == key:
                node = chain.pop(i)
                self._size -= 1
                return node.value
        return None

    def size(self) -> int:
        return self._size

    def contains_key(self, key: K):
        index: int = hash(key) % self.capacity
        chain: list[Node[K, V]] = self.data[index]
        for item in chain:
            if item.key == key:
                return True
        return False

    def _resize(self):
        if (self._size + 1) / self.capacity <= 0.75:
            return
        new_capacity = self.capacity * 2
        new_data: list[list[Node[K, V]]] = [[] for _ in range(new_capacity)]
        for nodes in self.data:
            for node in nodes:
                new_index = hash(node.key) % new_capacity
                new_chain = new_data[new_index]
                new_chain.append(node)
        self.capacity = new_capacity
        self.data = new_data

    def __repr__(self) -> str:
        data_str = []
        for i, da in enumerate(self.data):
            data_str.append(f"{i}: {','.join([repr(d) for d in da])}")

        return (
            f"HashMap(capacity={self.capacity}\n"
            f"size={self._size}\n"
            f"data=\n{'\n'.join(data_str)}\n"
            f")"
        )

    def __contains__(self, value: K) -> bool:
        return self.contains_key(value)


if __name__ == '__main__':
    m = HashMap()
    m.put("jm", 33)
    m.put("zyp", 29)
    print(m)
