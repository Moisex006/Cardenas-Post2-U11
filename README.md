# Refactoring U11 - Clean Code Profundo

Proyecto desarrollado para la Unidad 11 de Patrones de Diseño de Software.

## Objetivo

Aplicar técnicas avanzadas de refactorización para eliminar code smells tipo:

- Long Method
- Large Class
- Primitive Obsession

Usando:

- Extract Method
- Extract Class
- Value Objects

y verificando las mejoras mediante SonarQube.

---

# Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- SonarQube
- H2 Database
- Spring Data JPA

---

# Estructura del Proyecto

```txt
src/
 ├── model/
 ├── repository/
 ├── service/
 └── valueobject/
 
 ```
---
# Code Smells Identificados

## Antes de la refactorización

### Long Method

El método `procesarPedido()` tenía demasiadas responsabilidades:

- Validación
- Cálculo
- Descuento
- Persistencia
- Notificación

Todo dentro de un solo método.

---

### Large Class

`PedidoService` concentraba demasiada lógica de negocio.

---

### Primitive Obsession

Se utilizaban múltiples parámetros primitivos para representar información del cliente:

```java
String clienteNombre,
String clienteEmail,
String clienteTelefono,
String clienteDireccion,
String clienteCiudad,
String clienteCodigoPostal
```

---

# Técnicas de Refactorización Aplicadas

## 1. Extract Method

Se dividió el método `procesarPedido()` en métodos más pequeños:

- `calcularTotal()`
- `aplicarDescuento()`
- `persistirPedido()`

---

## 2. Extract Class

La lógica de notificaciones fue extraída a:

```txt
NotificacionService
```

---

## 3. Value Objects

Se crearon las clases:

- `DatosCliente`
- `Direccion`
- `LineaPedido`
- `CodigoDescuento`

para eliminar Primitive Obsession y mejorar la mantenibilidad.

---

# Ejecución del Proyecto

## Compilar

```bash
./mvnw compile
```

---

## Ejecutar análisis SonarQube

```bash
./mvnw verify sonar:sonar \
"-Dsonar.host.url=http://localhost:9000" \
"-Dsonar.token=TU_TOKEN" \
"-Dsonar.projectKey=refactoring-u11"
```


---

# Comparación de Métricas

| Métrica | Antes | Después |
|---|---|---|
| Code Smells | 12 | 3 |
| Complejidad Ciclomática | 18 | 2 |
| Maintainability | C | A |

---

# Resultados Obtenidos

- Reducción significativa de Code Smells.
- Disminución de complejidad ciclomatica.
- Código más modular y mantenible.
- Eliminación de responsabilidades mezcladas.
- Uso de clases inmutables para representar datos de dominio.