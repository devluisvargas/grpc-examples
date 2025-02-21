# Proyecto gRPC - Suma de Valores

Este proyecto es una implementación de un servicio gRPC para realizar la suma de dos valores. Incluye tanto el servidor gRPC como el cliente gRPC.

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior
- IntelliJ IDEA (opcional, pero recomendado)
- gRPC y Protocol Buffers

## Estructura del Proyecto

- `src/main/proto`: Contiene el archivo `sum.proto` que define el servicio gRPC.
- `src/main/java`: Contiene las clases generadas por Protobuf y las implementaciones del servidor y cliente.

## Archivo .proto

```protobuf
syntax = "proto3";

package com.proto.operation;

option java_multiple_files = true;
option java_package = "com.proto.operation";

message SumRequest {
    int32 value1 = 1;
    int32 value2 = 2;
}

message SumResponse {
    int32 result = 1;
}

service SumService {
    rpc execute(SumRequest) returns (SumResponse);
}
