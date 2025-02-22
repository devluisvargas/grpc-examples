# 🚀 Ejemplos de gRPC en Java

Este repositorio contiene múltiples proyectos de ejemplo que demuestran el uso de **gRPC en Java**. Cada proyecto se enfoca en un tipo diferente de comunicación gRPC:

📌 **Unary Communication** → `grpc-java-sum`

📌 **Streaming Server Communication** → `grpc-java-prime-descomposer`

📌 **Streaming Client Communication** → `grpc-java-avg`

---

## 📂 Estructura del Repositorio
📁 `grpc-java-sum/` → **Suma de valores** usando comunicación **Unary**. 

📁 `grpc-java-prime-descomposer/` → **Descomposición en factores primos** usando **Streaming Server**.

📁 `grpc-java-avg/` → **Cálculo de promedio** usando **Streaming Client**.

---

## 🔥 Proyectos

### 1️⃣ `grpc-java-sum` ➕

Este proyecto demuestra cómo implementar una comunicación **Unary** en gRPC. El cliente envía una solicitud con dos valores enteros y el servidor responde con la suma de estos valores.

📝 **Detalles:**
- 📜 **Archivo .proto:** Define el servicio `SumService` con una operación `execute` que toma un `SumRequest` y devuelve un `SumResponse`.
- 🖥️ **Servidor:** Implementa el servicio `SumService` y escucha en el puerto especificado.
- 🏗️ **Cliente:** Envía una solicitud al servidor y recibe la respuesta con el resultado de la suma.

---

### 2️⃣ `grpc-java-prime-descomposer` 🔢

Este proyecto implementa una comunicación **Streaming Server** en gRPC. El cliente envía un número entero y el servidor responde con un flujo de sus factores primos.

📝 **Detalles:**
- 📜 **Archivo .proto:** Define el servicio `PrimeService` con una operación `execute` que toma un `PrimeRequest` y devuelve un flujo de `PrimeResponse`.
- 🖥️ **Servidor:** Implementa el servicio `PrimeService` y escucha en el puerto especificado.
- 🏗️ **Cliente:** Envía una solicitud al servidor y recibe un flujo de respuestas con los factores primos del número proporcionado.

---

### 3️⃣ `grpc-java-avg` 📊

Este proyecto muestra cómo implementar una comunicación **Streaming Client** en gRPC. El cliente envía múltiples valores enteros al servidor y, cuando finaliza el envío, el servidor responde con el promedio de estos valores.

📝 **Detalles:**
- 📜 **Archivo .proto:** Define el servicio `AvgService` con una operación `execute` que toma un flujo de `AvgRequest` y devuelve un único `AvgResponse` con el promedio calculado.
- 🖥️ **Servidor:** Implementa el servicio `AvgService` y escucha en el puerto especificado.
- 🏗️ **Cliente:** Envía un conjunto de valores al servidor y espera la respuesta con el promedio calculado.

---

## ✅ Requisitos

✔️ Java 11 o superior ☕

✔️ Maven 3.6 o superior 📦

✔️ IntelliJ IDEA (opcional, pero recomendado) 🛠️

✔️ gRPC y Protocol Buffers ⚡

---

Cada uno de estos proyectos ofrece un enfoque práctico sobre cómo utilizar **gRPC** en diferentes modos de comunicación en **Java**. 🚀💡

