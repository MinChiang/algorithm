from algorithm.common import SupportCompare


class BubbleSort[T: SupportCompare]:
    def __init__(self, data: list[T] | None = None) -> None:
        self._data = [] if data is None else list(data)

    def sort(self) -> None:
        for i in range(len(self._data) - 1):
            for j in range(len(self._data) - i - 1):
                if self._data[j] > self._data[j + 1]:
                    self._data[j], self._data[j + 1] = self._data[j + 1], self._data[j]
