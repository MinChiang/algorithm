class Stack[T]:
    def __init__(self):
        self.data = []

    def push(self, item: T) -> None:
        self.data.append(item)

    def pop(self) -> T:
        return self.data.pop()

    def peek(self) -> T:
        if self.is_empty():
            return None
        return self.data[- 1]

    def is_empty(self) -> bool:
        return len(self.data) == 0

    def __repr__(self) -> str:
        elements = ','.join(repr(data) for data in self.data)
        return (
            f"Stack(data={elements})"
        )

    def __str__(self) -> str:
        return repr(self)
