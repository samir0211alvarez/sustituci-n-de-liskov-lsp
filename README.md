# Principio de Sustitución de Liskov (LSP) en Java

[![Build y pruebas](../../actions/workflows/maven.yml/badge.svg)](../../actions/workflows/maven.yml)

Proyecto Maven de **Programación II** sobre la **L de SOLID**: el *Principio de Sustitución de Liskov*.
Cada ejemplo muestra primero una **violación** del principio y luego su **solución**, con pruebas
unitarias y una explicación detallada.

## Integrantes

| Integrante | Ejemplo a cargo | Explicación |
|---|---|---|
| **Samir Correa Alvarez** | Ejemplo 1: Ave y Pingüino | [docs/ejemplo1-aves.md](docs/ejemplo1-aves.md) |
| **Sebastian Lasso Vidal** | Ejemplo 2: Rectángulo y Cuadrado | [docs/ejemplo2-figuras.md](docs/ejemplo2-figuras.md) |

**Materia:** Programación II · **Fecha:** 22/11/2026

## ¿Qué dice el principio?

> Una clase hija debe poder reemplazar a su clase padre **sin sorpresas**.

Si `B` hereda de `A`, debes poder usar un objeto `B` donde se espera un `A` sin que el programa falle
ni se comporte de forma inesperada. **Compilar no basta:** la subclase tiene que comportarse como
promete la clase padre. Fue presentado por Barbara Liskov en 1987 y formalizado con Jeannette Wing en 1994.

### Reglas que debe cumplir la subclase

- **No exigir más** que el padre (precondiciones no más estrictas).
- **No prometer menos** que el padre (postcondiciones no más débiles).
- **Sin excepciones nuevas** que el padre no lanza.
- **Respetar las invariantes** del padre.
- **Regla de historial:** no permitir cambios de estado que el padre no permite.

### Señales de alerta

Excepciones inesperadas (`UnsupportedOperationException`), métodos vacíos o que hacen algo distinto,
y uso de `instanceof` para tratar subclases como casos especiales.

## Estructura del proyecto

```
liskov-lsp/
├── pom.xml
├── README.md
├── docs/
│   ├── ejemplo1-aves.md
│   └── ejemplo2-figuras.md
└── src/
    ├── main/java/com/programacion2/liskov/
    │   ├── Main.java
    │   ├── aves/
    │   │   ├── DemoAves.java
    │   │   ├── violacion/   (Ave, Gorrion, Pinguino, ExhibicionAerea)
    │   │   └── solucion/    (Ave, Volador, Nadador, Gorrion, Aguila, Pinguino, ExhibicionAerea)
    │   └── figuras/
    │       ├── DemoFiguras.java
    │       ├── violacion/   (Rectangulo, Cuadrado, PruebaDeSustitucion)
    │       └── solucion/    (Forma, Rectangulo, Cuadrado)
    └── test/java/com/programacion2/liskov/
        ├── aves/     (AvesViolacionTest, AvesSolucionTest)
        └── figuras/  (FigurasViolacionTest, FigurasSolucionTest)
```

## Requisitos

- Java 17 o superior
- Maven 3.8 o superior

## Cómo ejecutarlo

```bash
# Ejecutar las pruebas
mvn test

# Compilar y ejecutar las demostraciones por consola
mvn compile exec:java

# Generar el .jar y ejecutarlo
mvn package
java -jar target/liskov-lsp-1.0.0.jar
```

## Resumen de los ejemplos

| | Violación | Por qué falla | Solución |
|---|---|---|---|
| **Ejemplo 1** | `Pinguino extends Ave` y `volar()` lanza una excepción | El pingüino no puede sustituir al ave: lanza una excepción que el padre no lanza | `Ave` solo promete `comer()`; `Volador` y `Nadador` son interfaces opcionales |
| **Ejemplo 2** | `Cuadrado extends Rectangulo` | `setAlto(4)` también cambia el ancho: `5 × 4` da 16 y no 20 | Interfaz `Forma` con clases inmutables e independientes |

## Idea clave

Antes de heredar, pregúntate: **¿puedo cambiar el padre por el hijo sin que nada falle?**
Si la respuesta es no, usa interfaces, composición o una abstracción distinta.

## Referencias

- Liskov, B. (1987). *Data Abstraction and Hierarchy*. Conferencia OOPSLA '87.
- Liskov, B. y Wing, J. M. (1994). *A Behavioral Notion of Subtyping*. ACM TOPLAS, 16(6).
- Martin, R. C. (2002). *Agile Software Development: Principles, Patterns, and Practices*. Prentice Hall.
