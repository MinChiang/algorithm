class HeapSort[T]:
    def __init__(self, data: list[T] | None = None) -> None:
        if data is None:
            data = []
        self._data = data
        self._heapify()

    def _heapify(self) -> None:
        index = len(self._data) // 2 - 1
        while index >= 0:
            self._sift_down(index, len(self._data) - 1)
            index -= 1

    def _sift_down(self, index: int, end: int) -> None:
        while True:
            left = index * 2 + 1
            right = index * 2 + 2
            biggest = index
            if left <= end and self._data[left] > self._data[biggest]:
                biggest = left
            if right <= end and self._data[right] > self._data[biggest]:
                biggest = right
            if index == biggest:
                return
            self._data[biggest], self._data[index] = (
                self._data[index],
                self._data[biggest],
            )
            index = biggest

    def sort(self) -> None:
        end = len(self._data) - 1
        for i in range(len(self._data)):
            self._data[0], self._data[end - i] = self._data[end - i], self._data[0]
            self._sift_down(0, end - i - 1)
