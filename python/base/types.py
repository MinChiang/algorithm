from collections.abc import Iterator
from contextlib import contextmanager
from dataclasses import dataclass
from functools import wraps
from threading import Lock
from typing import Any, Callable, Iterable, Sequence
import uuid

numbers: list[int] = [1, 2, 3, 4]
numbers.append(5)


def calculate_total(numbers: Sequence[int]) -> int:
    return sum(numbers)


def print_items(items: Iterable[str]) -> None:
    for item in items:
        print(item)


print_items(["Java", "Python", "Go", "Rust"])

it: Iterator[int] = iter([1, 2, 3, 4])


@dataclass
class TraceIdSaver:
    _trace_id: str | None = None
    _lock = Lock()

    def _generate_trace_id(self) -> str:
        with self._lock:
            if self._trace_id is not None:
                return self._trace_id
            self._trace_id = str(uuid.uuid4())
            return self._trace_id

    def _acquire_or_generate_trace_id(self) -> str:
        return self._generate_trace_id() if self._trace_id is None else self._trace_id

    def __init__(self, trace_id: str | None = None):
        self._trace_id = trace_id

    @property
    def trace_id(self) -> str:
        return self._acquire_or_generate_trace_id()


tis = TraceIdSaver("123")
