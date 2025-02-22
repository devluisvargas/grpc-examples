### 📌 Proyecto gRPC - Suma de Valores

# gRPC - Servicio de Suma de Valores

Este proyecto implementa un servicio gRPC para calcular la suma de dos valores enteros. La comunicación entre cliente y servidor se realiza mediante una **llamada unaria**.

---

## 🚀 Tecnologías Utilizadas
- Java 11 o superior
- Maven 3.6 o superior
- gRPC y Protocol Buffers

---

## 📂 Estructura del Proyecto

```
grpc-suma-valores/
├── src/main/proto/                   # Definición del servicio gRPC (sum.proto)
├── src/main/java/com/devluis/server/ # Implementación del servidor gRPC
├── src/main/java/com/devluis/client/ # Implementación del cliente gRPC
├── pom.xml                           # Configuración de dependencias
```

---

## 📜 Definición del servicio gRPC (sum.proto)

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
```

---
## 📥 Instalación y Configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/devluisvargas/grpc-examples.git
   cd grpc-examples/grpc-java-sum
   ```

1. **Compilar el proyecto**
   ```bash
   mvn clean install
   ```
2. **Ejecutar el servidor**
   ```bash
   mvn exec:java -Dexec.mainClass="com.devluis.server.GrpcServer"
   ```
3. **Ejecutar el cliente**
   ```bash
   mvn exec:java -Dexec.mainClass="com.devluis.client.GrpcClient"
   ```

---

## 📌 Autor
👤 **Luis Vargas**
- GitHub: [devluisvargas](https://github.com/devluisvargas)
- LinkedIn: [luis-vargas-penafiel](https://www.linkedin.com/in/luis-vargas-penafiel/)

---

## 📜 Licencia
Este proyecto está bajo la licencia MIT.
