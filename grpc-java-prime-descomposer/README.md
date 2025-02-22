### 📌 Proyecto gRPC - Factores Primos (Streaming Server gRPC)

# PrimeFactorizer - gRPC Prime Factorization Service

Este proyecto implementa un servicio gRPC que permite calcular los **factores primos** de un número. Utiliza **Streaming Server**, donde el servidor envía los factores primos al cliente **a medida que se calculan**.

---

## 🚀 Tecnologías Utilizadas
- Java 11 o superior
- Maven 3.6 o superior
- gRPC y Protocol Buffers

---

## 📂 Estructura del Proyecto

```
grpc-prime-factorizer/
├── src/main/proto/           # Definición del servicio gRPC (prime.proto)
├── src/main/java/com/server/ # Implementación del servidor gRPC
├── src/main/java/com/client/ # Implementación del cliente gRPC
├── pom.xml                   # Configuración de dependencias
```

---

## 📜 Definición del servicio gRPC (prime.proto)

```protobuf
syntax = "proto3";

package com.prime.grpc;

option java_package = "com.prime.grpc";
option java_multiple_files = true;

message PrimeRequest {
    int32 value = 1;
}

message PrimeResponse {
    int32 result = 1;
}

service PrimeService {
    rpc execute(PrimeRequest) returns (stream PrimeResponse);
}
```

---

## 📥 Instalación y Configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/devluisvargas/grpc-examples.git
   cd grpc-examples/grpc-java-prime-descomposer
   ```
   
2. **Compilar el proyecto**
   ```bash
   mvn clean install
   ```
3. **Ejecutar el servidor**
   ```bash
   mvn exec:java -Dexec.mainClass="com.devluis.server.GrpcServer"
   ```
4. **Ejecutar el cliente**
   ```bash
   mvn exec:java -Dexec.mainClass="com.devluis.client.GrpcClient"
   ```

---

## 📌 Autor
👤 **Luis Vargas**
- GitHub: [tu-usuario](https://github.com/tu-usuario)
- LinkedIn: [tu-linkedin](https://linkedin.com/in/tu-linkedin)

---

## 📜 Licencia
Este proyecto está bajo la licencia MIT.
