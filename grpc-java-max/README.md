# 📡 Proyecto gRPC - Máximo de Valores (Streaming Bidireccional)

Este proyecto es una implementación de un servicio gRPC en Java que calcula el máximo valor en un flujo de números utilizando comunicación **Streaming Bidireccional**. A medida que el cliente envía números al servidor, este responde inmediatamente con el valor máximo encontrado hasta el momento.

## 🚀 Características
- Implementación de **gRPC con Streaming Bidireccional**.
- Cliente envía un flujo de valores enteros al servidor.
- El servidor responde en tiempo real con el máximo encontrado hasta el momento.

## 📋 Requisitos
- Java 11 o superior ☕
- Maven 3.6 o superior 🔧
- IntelliJ IDEA (opcional, pero recomendado) 🖥️
- gRPC y Protocol Buffers ⚡

## 📂 Estructura del Proyecto
```
├── src/main/proto/            # Definición del servicio gRPC
│   ├── max.proto              # Archivo .proto
├── src/main/java/com/devluis  # Código fuente
│   ├── client/GrpcClient.java # Cliente gRPC
│   ├── server/GrpcServer.java # Servidor gRPC
│   ├── server/impl/MaxServiceImpl.java # Implementación del servicio
```

## 📜 Definición del Servicio gRPC (.proto)
```protobuf
syntax = "proto3";

package com.max.proto;
option java_package = "com.max.proto";
option java_multiple_files = true;

message MaxRequest {
    int32 value = 1;
}

message MaxResponse {
    int32 result = 1;
}

service MaxService {
    rpc execute (stream MaxRequest) returns (stream MaxResponse);
}
```

## ⚙️ Implementación
### 🖥️ Servidor (`GrpcServer.java`)
1. **Inicia un servidor gRPC** que escucha en el puerto configurado.
2. **Registra el servicio `MaxServiceImpl`** que maneja las solicitudes.
3. **Maneja la finalización y apagado del servidor**.

### 🔢 Servicio (`MaxServiceImpl.java`)
1. **Recibe un flujo de valores enteros** desde el cliente.
2. **Mantiene un seguimiento del máximo encontrado**.
3. **Envía el nuevo máximo cada vez que cambia**.
4. **Finaliza la transmisión cuando el cliente completa el envío**.

### 💻 Cliente (`GrpcClient.java`)
1. **Crea un canal de comunicación con el servidor**.
2. **Envía una serie de valores enteros al servidor**.
3. **Escucha en tiempo real las respuestas del servidor**.

## ▶️ Cómo Ejecutarlo
### 1️⃣ Iniciar el Servidor
Ejecutar la clase `GrpcServer`:
```bash
mvn clean package
java -cp target/*.jar com.devluis.server.GrpcServer
```

### 2️⃣ Iniciar el Cliente
Ejecutar la clase `GrpcClient`:
```bash
java -cp target/*.jar com.devluis.client.GrpcClient
```

## 🛠️ Tecnologías Utilizadas
- **Java** ☕
- **gRPC** 📡
- **Protocol Buffers** 🔗
- **Maven** ⚙️

## 📌 Notas
- Asegúrate de que el **servidor esté ejecutándose antes de iniciar el cliente**.
- Puedes modificar la lista de números en el cliente para probar distintos escenarios.
- Para una mayor eficiencia en producción, considera el uso de **TLS/SSL en gRPC**.

📌 *¡Diviértete explorando gRPC con Streaming Bidireccional!* 🚀
