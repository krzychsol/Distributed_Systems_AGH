from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class AddCarOptionalRequest(_message.Message):
    __slots__ = ("brand", "model", "year")
    BRAND_FIELD_NUMBER: _ClassVar[int]
    MODEL_FIELD_NUMBER: _ClassVar[int]
    YEAR_FIELD_NUMBER: _ClassVar[int]
    brand: str
    model: str
    year: int
    def __init__(self, brand: _Optional[str] = ..., model: _Optional[str] = ..., year: _Optional[int] = ...) -> None: ...

class AddCarNoOptionalRequest(_message.Message):
    __slots__ = ("brand", "model", "year")
    BRAND_FIELD_NUMBER: _ClassVar[int]
    MODEL_FIELD_NUMBER: _ClassVar[int]
    YEAR_FIELD_NUMBER: _ClassVar[int]
    brand: str
    model: str
    year: int
    def __init__(self, brand: _Optional[str] = ..., model: _Optional[str] = ..., year: _Optional[int] = ...) -> None: ...

class AddCarResponse(_message.Message):
    __slots__ = ("response",)
    RESPONSE_FIELD_NUMBER: _ClassVar[int]
    response: bool
    def __init__(self, response: bool = ...) -> None: ...
