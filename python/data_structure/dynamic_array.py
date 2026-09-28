class DynamicArray[T]:
    def __init__(self, capacity=10):
        self.capacity = capacity
        self.size = 0
        self.data: list[T | None] = [None] * capacity

    def append(self, value: T):
        if self.size == self.capacity:
            self.resize()
        self.data[self.size] = value
        self.size += 1

    def resize(self):
        self.capacity = self.capacity * 2
        new_data: list[T | None] = [None] * self.capacity
        for i in range(self.size):
            new_data[i] = self.data[i]
        self.data = new_data

    def get(self, index: int) -> T | None:
        if index < 0 or index >= self.size:
            raise IndexError("invalid index")
        return self.data[index]

    def insert(self, index: int, value: T):
        if index < 0 or index > self.size:
            raise IndexError("invalid index")
        if self.size == self.capacity:
            self.resize()
        for i in range(self.size - 1, index - 1, -1):
            self.data[i + 1] = self.data[i]
        self.data[index] = value
        self.size += 1

    def remove(self, index: int) -> T | None:
        if index < 0 or index >= self.size:
            raise IndexError("invalid index")
        result = self.data[index]
        for i in range(index + 1, self.size, 1):
            self.data[i - 1] = self.data[i]
        self.data[self.size - 1] = None
        self.size -= 1
        return result

    def contains(self, value: T) -> bool:
        for i in range(self.size):
            if self.data[i] == value:
                return True
        return False

    def reverse(self):
        size = int(self.size / 2)
        for i in range(size):
            self.data[i], self.data[self.size - i - 1] = (
                self.data[self.size - i - 1],
                self.data[i],
            )

    def __str__(self):
        return str(self.data[: self.size])

    def __repr__(self):
        return (
            f"DynamicArray(size={self.size}, capacity={self.capacity},data={self.data}"
        )


if __name__ == "__main__":
    arr = DynamicArray(2)

    arr.append(1)
    arr.append(2)
    arr.append(3)

    arr.insert(0, 100)
    arr.insert(2, 200)
    arr.insert(arr.size, 300)

    arr.remove(0)
    arr.remove(arr.size - 1)

    print(arr.contains(200))

    arr.reverse()

    print(arr)
