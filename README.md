# Refactoring U11-Post2

---

# Objetivo

Aplicar técnicas avanzadas de refactorización para reducir la complejidad ciclomatica (CC) mediante:

- Replace Conditional with Polymorphism
- Guard Clauses

Verificando los resultados mediante SonarQube y documentando las mejoras obtenidas.

---

# Tecnologías Utilizadas

- Java 21
- Spring Boot
- Maven
- SonarQube
- JUnit 5
- JaCoCo

---

# Problemas Identificados

## 1. Switch Statement Smell

El método `calcularEnvio()` utilizaba un `switch` con múltiples casos:

```java
switch (tipoEnvio) {
    case "ESTANDAR":
    case "EXPRESS":
    case "MISMO_DIA":
    case "GRATIS":
}
```

Este enfoque violaba el principio Open/Closed ya que cada nuevo tipo de envío requería modificar el método principal.

---

## 2. Arrow Code

El método `aprobarCredito()` contenía múltiples if anidados:

```java
if (c != null) {
    if (c.isActivo()) {
        if (c.getScore() >= 600) {
```

Esto aumentaba la complejidad ciclomatica y dificultaba la legibilidad.

---

# Técnicas de Refactorización Aplicadas

## Replace Conditional with Polymorphism

Se implementó el patrón Strategy mediante la interfaz:

```java
EstrategiaEnvio
```

y las implementaciones:

- EnvioEstandar
- EnvioExpress
- EnvioMismoDia

Esto permitió eliminar el switch statement y distribuir la lógica en clases independientes.

---

## Guard Clauses

El método `aprobarCredito()` fue refactorizado utilizando retornos anticipados:

```java
if (c == null) return "RECHAZADO";
if (!c.isActivo()) return "RECHAZADO";
```

reduciendo la complejidad y mejorando la legibilidad.

---

# Estructura del Proyecto

```txt
src/
 ├── model/
 ├── service/
 ├── strategy/
 └── test/
```

---

# Pruebas Unitarias

Se implementaron pruebas unitarias con JUnit 5 para verificar:

- cálculo de envío estándar
- envío express
- envío mismo día
- cliente nulo
- cliente inactivo
- score insuficiente
- crédito aprobado
- validación de límite de crédito

---

# Ejecución del Proyecto

## Ejecutar pruebas

```bash
./mvnw test
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

| Método | CC Antes | CC Después |
|---|---|---|
| calcularEnvio | 5 | 1 |
| aprobarCredito | 6 | 2 |

---

# Comparación General

| Métrica | Antes | Después |
|---|---|---|
| Coverage | 0% | 19.9% |
| Duplications | 0% | 0% |
| Maintainability | B | A |
| Reliability | A | A |

---


# Reflexión Open/Closed Principle

El patrón Strategy permitió separar las reglas de cálculo de envío en clases independientes. Gracias a esto, el sistema puede agregar nuevos tipos de envío sin modificar la clase principal `EnvioService`, cumpliendo el principio Open/Closed. Esta refactorización mejora la mantenibilidad, reduce la complejidad ciclomatica y facilita la escalabilidad del sistema.


---

# Resultados Obtenidos

- Reducción de complejidad ciclomatica.
- Eliminación de switch statement.
- Eliminación de arrow code.
- Aplicación correcta de Guard Clauses.
- Aplicación del patrón Strategy.
- Mejora de mantenibilidad.
- Código más modular y escalable.
- Cobertura de pruebas mejorada mediante JUnit 5.

---