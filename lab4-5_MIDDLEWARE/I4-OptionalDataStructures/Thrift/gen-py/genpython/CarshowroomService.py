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
import logging
from .ttypes import *
from thrift.Thrift import TProcessor
from thrift.transport import TTransport
all_structs = []


class Iface(object):
    def addCarOptional(self, brand, model, year):
        """
        Parameters:
         - brand
         - model
         - year

        """
        pass

    def addCarNoOptional(self, brand, model, year):
        """
        Parameters:
         - brand
         - model
         - year

        """
        pass

    def addCarStructOptional(self, car):
        """
        Parameters:
         - car

        """
        pass

    def addCarStructNoOptional(self, car):
        """
        Parameters:
         - car

        """
        pass


class Client(Iface):
    def __init__(self, iprot, oprot=None):
        self._iprot = self._oprot = iprot
        if oprot is not None:
            self._oprot = oprot
        self._seqid = 0

    def addCarOptional(self, brand, model, year):
        """
        Parameters:
         - brand
         - model
         - year

        """
        self.send_addCarOptional(brand, model, year)
        return self.recv_addCarOptional()

    def send_addCarOptional(self, brand, model, year):
        self._oprot.writeMessageBegin('addCarOptional', TMessageType.CALL, self._seqid)
        args = addCarOptional_args()
        args.brand = brand
        args.model = model
        args.year = year
        args.write(self._oprot)
        self._oprot.writeMessageEnd()
        self._oprot.trans.flush()

    def recv_addCarOptional(self):
        iprot = self._iprot
        (fname, mtype, rseqid) = iprot.readMessageBegin()
        if mtype == TMessageType.EXCEPTION:
            x = TApplicationException()
            x.read(iprot)
            iprot.readMessageEnd()
            raise x
        result = addCarOptional_result()
        result.read(iprot)
        iprot.readMessageEnd()
        if result.success is not None:
            return result.success
        raise TApplicationException(TApplicationException.MISSING_RESULT, "addCarOptional failed: unknown result")

    def addCarNoOptional(self, brand, model, year):
        """
        Parameters:
         - brand
         - model
         - year

        """
        self.send_addCarNoOptional(brand, model, year)
        return self.recv_addCarNoOptional()

    def send_addCarNoOptional(self, brand, model, year):
        self._oprot.writeMessageBegin('addCarNoOptional', TMessageType.CALL, self._seqid)
        args = addCarNoOptional_args()
        args.brand = brand
        args.model = model
        args.year = year
        args.write(self._oprot)
        self._oprot.writeMessageEnd()
        self._oprot.trans.flush()

    def recv_addCarNoOptional(self):
        iprot = self._iprot
        (fname, mtype, rseqid) = iprot.readMessageBegin()
        if mtype == TMessageType.EXCEPTION:
            x = TApplicationException()
            x.read(iprot)
            iprot.readMessageEnd()
            raise x
        result = addCarNoOptional_result()
        result.read(iprot)
        iprot.readMessageEnd()
        if result.success is not None:
            return result.success
        raise TApplicationException(TApplicationException.MISSING_RESULT, "addCarNoOptional failed: unknown result")

    def addCarStructOptional(self, car):
        """
        Parameters:
         - car

        """
        self.send_addCarStructOptional(car)
        return self.recv_addCarStructOptional()

    def send_addCarStructOptional(self, car):
        self._oprot.writeMessageBegin('addCarStructOptional', TMessageType.CALL, self._seqid)
        args = addCarStructOptional_args()
        args.car = car
        args.write(self._oprot)
        self._oprot.writeMessageEnd()
        self._oprot.trans.flush()

    def recv_addCarStructOptional(self):
        iprot = self._iprot
        (fname, mtype, rseqid) = iprot.readMessageBegin()
        if mtype == TMessageType.EXCEPTION:
            x = TApplicationException()
            x.read(iprot)
            iprot.readMessageEnd()
            raise x
        result = addCarStructOptional_result()
        result.read(iprot)
        iprot.readMessageEnd()
        if result.success is not None:
            return result.success
        raise TApplicationException(TApplicationException.MISSING_RESULT, "addCarStructOptional failed: unknown result")

    def addCarStructNoOptional(self, car):
        """
        Parameters:
         - car

        """
        self.send_addCarStructNoOptional(car)
        return self.recv_addCarStructNoOptional()

    def send_addCarStructNoOptional(self, car):
        self._oprot.writeMessageBegin('addCarStructNoOptional', TMessageType.CALL, self._seqid)
        args = addCarStructNoOptional_args()
        args.car = car
        args.write(self._oprot)
        self._oprot.writeMessageEnd()
        self._oprot.trans.flush()

    def recv_addCarStructNoOptional(self):
        iprot = self._iprot
        (fname, mtype, rseqid) = iprot.readMessageBegin()
        if mtype == TMessageType.EXCEPTION:
            x = TApplicationException()
            x.read(iprot)
            iprot.readMessageEnd()
            raise x
        result = addCarStructNoOptional_result()
        result.read(iprot)
        iprot.readMessageEnd()
        if result.success is not None:
            return result.success
        raise TApplicationException(TApplicationException.MISSING_RESULT, "addCarStructNoOptional failed: unknown result")


class Processor(Iface, TProcessor):
    def __init__(self, handler):
        self._handler = handler
        self._processMap = {}
        self._processMap["addCarOptional"] = Processor.process_addCarOptional
        self._processMap["addCarNoOptional"] = Processor.process_addCarNoOptional
        self._processMap["addCarStructOptional"] = Processor.process_addCarStructOptional
        self._processMap["addCarStructNoOptional"] = Processor.process_addCarStructNoOptional
        self._on_message_begin = None

    def on_message_begin(self, func):
        self._on_message_begin = func

    def process(self, iprot, oprot):
        (name, type, seqid) = iprot.readMessageBegin()
        if self._on_message_begin:
            self._on_message_begin(name, type, seqid)
        if name not in self._processMap:
            iprot.skip(TType.STRUCT)
            iprot.readMessageEnd()
            x = TApplicationException(TApplicationException.UNKNOWN_METHOD, 'Unknown function %s' % (name))
            oprot.writeMessageBegin(name, TMessageType.EXCEPTION, seqid)
            x.write(oprot)
            oprot.writeMessageEnd()
            oprot.trans.flush()
            return
        else:
            self._processMap[name](self, seqid, iprot, oprot)
        return True

    def process_addCarOptional(self, seqid, iprot, oprot):
        args = addCarOptional_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = addCarOptional_result()
        try:
            result.success = self._handler.addCarOptional(args.brand, args.model, args.year)
            msg_type = TMessageType.REPLY
        except TTransport.TTransportException:
            raise
        except TApplicationException as ex:
            logging.exception('TApplication exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = ex
        except Exception:
            logging.exception('Unexpected exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = TApplicationException(TApplicationException.INTERNAL_ERROR, 'Internal error')
        oprot.writeMessageBegin("addCarOptional", msg_type, seqid)
        result.write(oprot)
        oprot.writeMessageEnd()
        oprot.trans.flush()

    def process_addCarNoOptional(self, seqid, iprot, oprot):
        args = addCarNoOptional_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = addCarNoOptional_result()
        try:
            result.success = self._handler.addCarNoOptional(args.brand, args.model, args.year)
            msg_type = TMessageType.REPLY
        except TTransport.TTransportException:
            raise
        except TApplicationException as ex:
            logging.exception('TApplication exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = ex
        except Exception:
            logging.exception('Unexpected exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = TApplicationException(TApplicationException.INTERNAL_ERROR, 'Internal error')
        oprot.writeMessageBegin("addCarNoOptional", msg_type, seqid)
        result.write(oprot)
        oprot.writeMessageEnd()
        oprot.trans.flush()

    def process_addCarStructOptional(self, seqid, iprot, oprot):
        args = addCarStructOptional_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = addCarStructOptional_result()
        try:
            result.success = self._handler.addCarStructOptional(args.car)
            msg_type = TMessageType.REPLY
        except TTransport.TTransportException:
            raise
        except TApplicationException as ex:
            logging.exception('TApplication exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = ex
        except Exception:
            logging.exception('Unexpected exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = TApplicationException(TApplicationException.INTERNAL_ERROR, 'Internal error')
        oprot.writeMessageBegin("addCarStructOptional", msg_type, seqid)
        result.write(oprot)
        oprot.writeMessageEnd()
        oprot.trans.flush()

    def process_addCarStructNoOptional(self, seqid, iprot, oprot):
        args = addCarStructNoOptional_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = addCarStructNoOptional_result()
        try:
            result.success = self._handler.addCarStructNoOptional(args.car)
            msg_type = TMessageType.REPLY
        except TTransport.TTransportException:
            raise
        except TApplicationException as ex:
            logging.exception('TApplication exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = ex
        except Exception:
            logging.exception('Unexpected exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = TApplicationException(TApplicationException.INTERNAL_ERROR, 'Internal error')
        oprot.writeMessageBegin("addCarStructNoOptional", msg_type, seqid)
        result.write(oprot)
        oprot.writeMessageEnd()
        oprot.trans.flush()

# HELPER FUNCTIONS AND STRUCTURES


class addCarOptional_args(object):
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
        oprot.writeStructBegin('addCarOptional_args')
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
all_structs.append(addCarOptional_args)
addCarOptional_args.thrift_spec = (
    None,  # 0
    (1, TType.STRING, 'brand', 'UTF8', None, ),  # 1
    (2, TType.STRING, 'model', 'UTF8', None, ),  # 2
    (3, TType.I32, 'year', None, None, ),  # 3
)


class addCarOptional_result(object):
    """
    Attributes:
     - success

    """


    def __init__(self, success=None,):
        self.success = success

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 0:
                if ftype == TType.BOOL:
                    self.success = iprot.readBool()
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
        oprot.writeStructBegin('addCarOptional_result')
        if self.success is not None:
            oprot.writeFieldBegin('success', TType.BOOL, 0)
            oprot.writeBool(self.success)
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
all_structs.append(addCarOptional_result)
addCarOptional_result.thrift_spec = (
    (0, TType.BOOL, 'success', None, None, ),  # 0
)


class addCarNoOptional_args(object):
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
        oprot.writeStructBegin('addCarNoOptional_args')
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
all_structs.append(addCarNoOptional_args)
addCarNoOptional_args.thrift_spec = (
    None,  # 0
    (1, TType.STRING, 'brand', 'UTF8', None, ),  # 1
    (2, TType.STRING, 'model', 'UTF8', None, ),  # 2
    (3, TType.I32, 'year', None, None, ),  # 3
)


class addCarNoOptional_result(object):
    """
    Attributes:
     - success

    """


    def __init__(self, success=None,):
        self.success = success

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 0:
                if ftype == TType.BOOL:
                    self.success = iprot.readBool()
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
        oprot.writeStructBegin('addCarNoOptional_result')
        if self.success is not None:
            oprot.writeFieldBegin('success', TType.BOOL, 0)
            oprot.writeBool(self.success)
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
all_structs.append(addCarNoOptional_result)
addCarNoOptional_result.thrift_spec = (
    (0, TType.BOOL, 'success', None, None, ),  # 0
)


class addCarStructOptional_args(object):
    """
    Attributes:
     - car

    """


    def __init__(self, car=None,):
        self.car = car

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
                if ftype == TType.STRUCT:
                    self.car = CarOptional()
                    self.car.read(iprot)
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
        oprot.writeStructBegin('addCarStructOptional_args')
        if self.car is not None:
            oprot.writeFieldBegin('car', TType.STRUCT, 1)
            self.car.write(oprot)
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
all_structs.append(addCarStructOptional_args)
addCarStructOptional_args.thrift_spec = (
    None,  # 0
    (1, TType.STRUCT, 'car', [CarOptional, None], None, ),  # 1
)


class addCarStructOptional_result(object):
    """
    Attributes:
     - success

    """


    def __init__(self, success=None,):
        self.success = success

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 0:
                if ftype == TType.BOOL:
                    self.success = iprot.readBool()
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
        oprot.writeStructBegin('addCarStructOptional_result')
        if self.success is not None:
            oprot.writeFieldBegin('success', TType.BOOL, 0)
            oprot.writeBool(self.success)
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
all_structs.append(addCarStructOptional_result)
addCarStructOptional_result.thrift_spec = (
    (0, TType.BOOL, 'success', None, None, ),  # 0
)


class addCarStructNoOptional_args(object):
    """
    Attributes:
     - car

    """


    def __init__(self, car=None,):
        self.car = car

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
                if ftype == TType.STRUCT:
                    self.car = CarNoOptional()
                    self.car.read(iprot)
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
        oprot.writeStructBegin('addCarStructNoOptional_args')
        if self.car is not None:
            oprot.writeFieldBegin('car', TType.STRUCT, 1)
            self.car.write(oprot)
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
all_structs.append(addCarStructNoOptional_args)
addCarStructNoOptional_args.thrift_spec = (
    None,  # 0
    (1, TType.STRUCT, 'car', [CarNoOptional, None], None, ),  # 1
)


class addCarStructNoOptional_result(object):
    """
    Attributes:
     - success

    """


    def __init__(self, success=None,):
        self.success = success

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 0:
                if ftype == TType.BOOL:
                    self.success = iprot.readBool()
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
        oprot.writeStructBegin('addCarStructNoOptional_result')
        if self.success is not None:
            oprot.writeFieldBegin('success', TType.BOOL, 0)
            oprot.writeBool(self.success)
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
all_structs.append(addCarStructNoOptional_result)
addCarStructNoOptional_result.thrift_spec = (
    (0, TType.BOOL, 'success', None, None, ),  # 0
)
fix_spec(all_structs)
del all_structs
