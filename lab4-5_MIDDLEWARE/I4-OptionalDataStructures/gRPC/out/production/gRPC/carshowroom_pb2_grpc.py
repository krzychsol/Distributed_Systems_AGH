# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc
import warnings

import carshowroom_pb2 as carshowroom__pb2

GRPC_GENERATED_VERSION = '1.63.0'
GRPC_VERSION = grpc.__version__
EXPECTED_ERROR_RELEASE = '1.65.0'
SCHEDULED_RELEASE_DATE = 'June 25, 2024'
_version_not_supported = False

try:
    from grpc._utilities import first_version_is_lower
    _version_not_supported = first_version_is_lower(GRPC_VERSION, GRPC_GENERATED_VERSION)
except ImportError:
    _version_not_supported = True

if _version_not_supported:
    warnings.warn(
        f'The grpc package installed is at version {GRPC_VERSION},'
        + f' but the generated code in carshowroom_pb2_grpc.py depends on'
        + f' grpcio>={GRPC_GENERATED_VERSION}.'
        + f' Please upgrade your grpc module to grpcio>={GRPC_GENERATED_VERSION}'
        + f' or downgrade your generated code using grpcio-tools<={GRPC_VERSION}.'
        + f' This warning will become an error in {EXPECTED_ERROR_RELEASE},'
        + f' scheduled for release on {SCHEDULED_RELEASE_DATE}.',
        RuntimeWarning
    )


class CarshowroomServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.AddCarOptional = channel.unary_unary(
                '/tutorial.CarshowroomService/AddCarOptional',
                request_serializer=carshowroom__pb2.AddCarOptionalRequest.SerializeToString,
                response_deserializer=carshowroom__pb2.AddCarResponse.FromString,
                _registered_method=True)
        self.AddCarNoOptional = channel.unary_unary(
                '/tutorial.CarshowroomService/AddCarNoOptional',
                request_serializer=carshowroom__pb2.AddCarNoOptionalRequest.SerializeToString,
                response_deserializer=carshowroom__pb2.AddCarResponse.FromString,
                _registered_method=True)


class CarshowroomServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def AddCarOptional(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def AddCarNoOptional(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_CarshowroomServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'AddCarOptional': grpc.unary_unary_rpc_method_handler(
                    servicer.AddCarOptional,
                    request_deserializer=carshowroom__pb2.AddCarOptionalRequest.FromString,
                    response_serializer=carshowroom__pb2.AddCarResponse.SerializeToString,
            ),
            'AddCarNoOptional': grpc.unary_unary_rpc_method_handler(
                    servicer.AddCarNoOptional,
                    request_deserializer=carshowroom__pb2.AddCarNoOptionalRequest.FromString,
                    response_serializer=carshowroom__pb2.AddCarResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'tutorial.CarshowroomService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class CarshowroomService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def AddCarOptional(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/tutorial.CarshowroomService/AddCarOptional',
            carshowroom__pb2.AddCarOptionalRequest.SerializeToString,
            carshowroom__pb2.AddCarResponse.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def AddCarNoOptional(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/tutorial.CarshowroomService/AddCarNoOptional',
            carshowroom__pb2.AddCarNoOptionalRequest.SerializeToString,
            carshowroom__pb2.AddCarResponse.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)
