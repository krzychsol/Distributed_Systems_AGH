#
# Autogenerated by Thrift Compiler (0.20.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#
#  options string: py
#

from thrift.Thrift import TType, TMessageType, TFrozenDict, TException, TApplicationException
from thrift.protocol.TProtocol import TProtocolException
from thrift.TRecursive import fix_spec

import sys

from thrift.transport import TTransport
all_structs = []


class CarOptional(object):
    """
    Attributes:
     - brand
     - model
     - year

    """


    def __init__(self, brand=None, model=None, year=None,):
        self.brand = brand
        self.model = model
        self.year = year

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRING:
                    self.brand = iprot.readString().decode('utf-8', errors='replace') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRING:
                    self.model = iprot.readString().decode('utf-8', errors='replace') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 3:
                if ftype == TType.I32:
                    self.year = iprot.readI32()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('CarOptional')
        if self.brand is not None:
            oprot.writeFieldBegin('brand', TType.STRING, 1)
            oprot.writeString(self.brand.encode('utf-8') if sys.version_info[0] == 2 else self.brand)
            oprot.writeFieldEnd()
        if self.model is not None:
            oprot.writeFieldBegin('model', TType.STRING, 2)
            oprot.writeString(self.model.encode('utf-8') if sys.version_info[0] == 2 else self.model)
            oprot.writeFieldEnd()
        if self.year is not None:
            oprot.writeFieldBegin('year', TType.I32, 3)
            oprot.writeI32(self.year)
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)


class CarNoOptional(object):
    """
    Attributes:
     - brand
     - model
     - year

    """


    def __init__(self, brand=None, model=None, year=None,):
        self.brand = brand
        self.model = model
        self.year = year

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRING:
                    self.brand = iprot.readString().decode('utf-8', errors='replace') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRING:
                    self.model = iprot.readString().decode('utf-8', errors='replace') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 3:
                if ftype == TType.I32:
                    self.year = iprot.readI32()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('CarNoOptional')
        if self.brand is not None:
            oprot.writeFieldBegin('brand', TType.STRING, 1)
            oprot.writeString(self.brand.encode('utf-8') if sys.version_info[0] == 2 else self.brand)
            oprot.writeFieldEnd()
        if self.model is not None:
            oprot.writeFieldBegin('model', TType.STRING, 2)
            oprot.writeString(self.model.encode('utf-8') if sys.version_info[0] == 2 else self.model)
            oprot.writeFieldEnd()
        if self.year is not None:
            oprot.writeFieldBegin('year', TType.I32, 3)
            oprot.writeI32(self.year)
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)
all_structs.append(CarOptional)
CarOptional.thrift_spec = (
    None,  # 0
    (1, TType.STRING, 'brand', 'UTF8', None, ),  # 1
    (2, TType.STRING, 'model', 'UTF8', None, ),  # 2
    (3, TType.I32, 'year', None, None, ),  # 3
)
all_structs.append(CarNoOptional)
CarNoOptional.thrift_spec = (
    None,  # 0
    (1, TType.STRING, 'brand', 'UTF8', None, ),  # 1
    (2, TType.STRING, 'model', 'UTF8', None, ),  # 2
    (3, TType.I32, 'year', None, None, ),  # 3
)
fix_spec(all_structs)
del all_structs
