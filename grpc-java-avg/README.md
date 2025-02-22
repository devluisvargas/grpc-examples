# gRPC Streaming Client - Práctica con Java

Este proyecto es una implementación de un servidor y cliente gRPC utilizando **Streaming Client** en Java. El servidor recibe un flujo de datos del cliente, calcula el promedio y envía el resultado al cliente cuando termina el flujo.

## 🚀 Tecnologías Utilizadas

- Java 17
- gRPC
- Maven
- Protobuf

---

## 📌 Estructura del Proyecto

```
grpc-java-avg/
├── src/main/java/com/devluis/
│   ├── client/        # Implementación del cliente gRPC
│   ├── server/        # Implementación del servidor gRPC
│   │   ├── impl/      # Lógica de servicios gRPC
│   ├── utils/         # Configuraciones y constantes
├─ src/main/proto      # Definiciones de Protobuf
├── pom.xml            # Configuración de dependencias
```

---

## 📥 Instalación y Configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/devluisvargas/grpc-examples.git
   cd grpc-examples/grpc-java-avg
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

## 🔧 Implementación

### 🌐 Definición del Servicio gRPC (Proto)

El servicio gRPC está definido en `avg.proto`:

```proto
syntax = "proto3";
package com.avg.proto;

service AvgService {
    rpc Execute (stream AvgRequest) returns (AvgResponse);
}

message AvgRequest {
    int32 value = 1;
}

message AvgResponse {
    double result = 1;
}
```

### 🖥️ Servidor gRPC

- **Recibe una secuencia de datos enviados por el cliente**.
- **Al completar el flujo, calcula el promedio y envía el resultado al cliente**.

```java
@Override
public StreamObserver<AvgRequest> execute(StreamObserver<AvgResponse> responseObserver) {
    List<Integer> items = new ArrayList<>();
    return new StreamObserver<>() {
        @Override
        public void onNext(AvgRequest avgRequest) {
            items.add(avgRequest.getValue());
        }

        @Override
        public void onCompleted() {
            double result = items.stream().mapToInt(Integer::intValue).average().orElse(0);
            responseObserver.onNext(AvgResponse.newBuilder().setResult(result).build());
            responseObserver.onCompleted();
        }
    };
}
```

### 📡 Cliente gRPC

- **Envía un flujo de datos al servidor**.
- **Espera la respuesta con el promedio calculado**.

```java
CountDownLatch latch = new CountDownLatch(1);
StreamObserver<AvgRequest> streams = avgServiceStub.execute(new StreamObserver<>() {
    @Override
    public void onNext(AvgResponse avgResponse) {
        System.out.println("Avg: " + avgResponse.getResult());
    }

    @Override
    public void onCompleted() {
        latch.countDown();
    }
});

List.of(2, 3, 5, 2, 4, 5).forEach(e -> streams.onNext(AvgRequest.newBuilder().setValue(e).build()));
streams.onCompleted();
latch.await(3, TimeUnit.SECONDS);
```

---

## 📌 Contribuir

Si quieres mejorar este proyecto, siéntete libre de enviar un **Pull Request** o abrir un **Issue**.

---

## 📜 Licencia

Este proyecto está bajo la licencia MIT. Puedes ver los detalles en [LICENSE](LICENSE).

---

## ✨ Autor

👤 **Luis Vargas**
- GitHub: [devluisvargas](https://github.com/devluisvargas)
- LinkedIn: [luis-vargas-penafiel](https://www.linkedin.com/in/luis-vargas-penafiel/)

