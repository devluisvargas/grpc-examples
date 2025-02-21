# PrimeFactorizer - gRPC Prime Factorization Service

Este proyecto es una implementación de un servicio gRPC para realizar la descomposición en factores primos de un número. Utiliza la comunicación de **Streaming Server** de gRPC para enviar los factores primos al cliente a medida que se calculan.

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior
- IntelliJ IDEA (opcional, pero recomendado)
- gRPC y Protocol Buffers

## Estructura del Proyecto

- `src/main/proto`: Contiene el archivo `prime.proto` que define el servicio gRPC.
- `src/main/java`: Contiene las clases generadas por Protobuf y las implementaciones del servidor y cliente.

## Archivo .proto

```protobuf
syntax = 'proto3';

package com.prime.grpc;
option java_package = 'com.prime.grpc';
option java_multiple_files = true;

message PrimeRequest{
  int32 value = 1;
}

message PrimeResponse{
  int32 result = 1;
}

service PrimeService{
  rpc execute(PrimeRequest) returns (stream PrimeResponse);
}
```
