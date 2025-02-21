# Ejemplos de gRPC en Java

Este repositorio contiene dos proyectos de ejemplo que demuestran el uso de gRPC en Java. Cada proyecto se centra en un tipo diferente de comunicación gRPC:

1. **Unary Communication**: `grpc-java-sum`
2. **Streaming Server Communication**: `grpc-java-prime-descomposer`

## Estructura del Repositorio

- `grpc-java-prime-descomposer/`: Proyecto de descomposición en factores primos utilizando comunicación de Streaming Server.
- `grpc-java-sum/`: Proyecto de suma de valores utilizando comunicación Unary.


## Proyectos

### 1. grpc-java-sum

Este proyecto demuestra cómo implementar una comunicación gRPC Unary en Java. El cliente envía una solicitud con dos valores enteros y el servidor responde con la suma de estos valores.

**Detalles del proyecto:**
- **Archivo .proto:** Define el servicio `SumService` con una operación `execute` que toma un `SumRequest` y devuelve un `SumResponse`.
- **Servidor:** Implementa el servicio `SumService` y escucha en el puerto especificado.
- **Cliente:** Envía una solicitud al servidor y recibe la respuesta con el resultado de la suma.

### 2. grpc-java-prime-descomposer

Este proyecto demuestra cómo implementar una comunicación gRPC de Streaming Server en Java. El cliente envía una solicitud con un número entero y el servidor responde con un flujo de factores primos de ese número.

**Detalles del proyecto:**
- **Archivo .proto:** Define el servicio `PrimeService` con una operación `execute` que toma un `PrimeRequest` y devuelve un flujo de `PrimeResponse`.
- **Servidor:** Implementa el servicio `PrimeService` y escucha en el puerto especificado.
- **Cliente:** Envía una solicitud al servidor y recibe un flujo de respuestas con los factores primos del número proporcionado.

