class Heap[T]:
    def __init__(self, data = None) -> None:
        if data is None:
            data = []
        self.data = list(data)
        self._heapify() 

    def _heapify(self) -> None:
        index = len(self.data) // 2 - 1
        while index >= 0:
            self._sift_down(index)
            index -= 1

    def __len__(self) -> int:
        return len(self.data)

    def peek(self):
        if not self.data:
            raise IndexError()
        return self.data[0]

    def push(self, value: T) -> None:
        self.data.append(value)
        self._sift_up(len(self.data) - 1)

    def _sift_up(self, index: int) -> None:
        while index > 0:
            father_index = (index - 1) // 2
            father = self.data[father_index]
            current = self.data[index]
            if current >= father:
                return
            self.data[father_index], self.data[index] = current, father
            index = father_index

    def _sift_down(self, index:int) -> None:
        while True:
            left = 2 * index + 1
            right = 2 * index + 2
            smallest = index
            if left < len(self.data) and self.data[left] < self.data[smallest]:
                smallest = left
            if right < len(self.data) and self.data[right] < self.data[smallest]:
                smallest = right
            if smallest == index:
                break
            self.data[smallest], self.data[index] = self.data[index], self.data[smallest]
            index = smallest

    def pop(self) -> T:
        if not self.data:
            raise IndexError()
        last = self.data.pop()
        if not self.data:
            return last

        first = self.data[0]
        self.data[0] = last
        self._sift_down(0)
        return first

    def __repr__(self) -> str:
        return f"Heap(data={self.data!r}"
