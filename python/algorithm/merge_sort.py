from algorithm.common import SupportCompare


class MergeSort[T: SupportCompare]:
    def __init__(self, data: list[T] | None = None) -> None:
        self._data = [] if data is None else list(data)

    def sort(self) -> None:
        self._data = self._sort(self._data)

    def _sort(self, arr: list[T]) -> list[T]:
        if len(arr) <= 1:
            return arr

        n = len(arr) // 2
        left = arr[:n]
        right = arr[n:]
        left = self._sort(left)
        right = self._sort(right)
        return self.merge(left, right)

    def merge(self, left: list[T], right: list[T]) -> list[T]:
        result: list[T] = []
        i = 0
        j = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                result.append(left[i])
                i += 1
            else:
                result.append(right[j])
                j += 1
        result.extend(left[i:])
        result.extend(right[j:])
        return result
