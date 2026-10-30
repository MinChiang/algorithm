from algorithm.common import SupportCompare


class SelectSort[T: SupportCompare]:
    def __init__(self, data: list[T] | None = None) -> None:
        self._data = [] if data is None else list(data)

    def sort(self) -> None:
        for i in range(len(self._data) - 1):
            min_index = i 
            for j in range(i + 1, len(self._data)):
                if self._data[j] < self._data[min_index]:
                    min_index = j
            self._data[min_index], self._data[i] = self._data[i], self._data[min_index]
                
