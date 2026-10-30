from algorithm.common import SupportCompare


class InsertSort[T: SupportCompare]:
    def __init__(self, data: list[T] | None = None) -> None:
        self._data = [] if data is None else list(data)

    def sort(self) -> None:
        for i in range(1, len(self._data)):
            j = i - 1
            while j >= 0 and self._data[j] > self._data[i]:
                self._data[j + 1] = self._data[j]
                j -= 1
            self._data[j + 1] = self._data[i]
