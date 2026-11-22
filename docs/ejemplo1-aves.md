# Ejemplo 1: Ave y Pingüino

**Autor:** Samir Correa Alvarez
**Paquetes:** `com.programacion2.liskov.aves.violacion` y `com.programacion2.liskov.aves.solucion`
**Pruebas:** `AvesViolacionTest` y `AvesSolucionTest`

## 1. El problema

Es el ejemplo más intuitivo del principio. Se modela que **todas las aves vuelan**:

```java
public class Ave {
    public String volar() { return "El ave esta volando"; }
}

public class Pinguino extends Ave {
    @Override
    public String volar() {
        throw new UnsupportedOperationException("Los pinguinos no vuelan");
    }
}
```

Un pingüino **es un ave** en el mundo real, pero en el código no puede cumplir lo que `Ave` promete.
Para esconder esa realidad, lanza una excepción.

## 2. Por qué viola el principio

El código cliente está escrito pensando en `Ave`:

```java
public static String hacerVolar(Ave ave) {
    return ave.volar();
}
```

| Llamada | Resultado |
|---|---|
| `hacerVolar(new Gorrion())` | Funciona |
| `hacerVolar(new Pinguino())` | **Lanza `UnsupportedOperationException`** |

El pingüino **no puede sustituir al ave**. Se rompen estas reglas:

- **Sin excepciones nuevas:** `Ave.volar()` nunca lanzaba excepciones y `Pinguino.volar()` sí.
- **Postcondición más débil:** `volar()` promete que el ave vuela; el pingüino no lo hace.

Además, el proyecto incluye `hacerVolarConParche`, que usa `instanceof Pinguino` para evitar el fallo.
Eso es una **señal de alerta**: si hay que preguntar por la subclase concreta, las subclases no son intercambiables.

> La causa de fondo es un **error de modelado**: `Ave` prometió algo que no todas las aves cumplen.

## 3. La solución

Se separa lo que **todas** las aves hacen de lo que **solo algunas** hacen:

```java
public abstract class Ave {
    public abstract String comer();
}

public interface Volador { String volar(); }
public interface Nadador { String nadar(); }

public class Gorrion  extends Ave implements Volador { ... }
public class Aguila   extends Ave implements Volador { ... }
public class Pinguino extends Ave implements Nadador { ... }
```

El código cliente ahora pide exactamente lo que necesita:

```java
public static String hacerVolar(Volador volador) {
    return volador.volar();
}
```

Un `Pinguino` **ni siquiera compila** si se intenta pasar a este método: el error se detecta al compilar
y no en ejecución.

## 4. Comparación

| | Violación | Solución |
|---|---|---|
| ¿Qué promete `Ave`? | Que vuela | Solo que come |
| ¿Quién vuela? | Todas (aunque no puedan) | Solo las que implementan `Volador` |
| ¿Cuándo se detecta el error? | En ejecución | En compilación |
| ¿Hace falta `instanceof`? | Sí | No |

## 5. Alternativa: composición

Otra salida válida es que `Ave` **tenga** un comportamiento de vuelo intercambiable
(patrón *Strategy*): un `ComportamientoDeVuelo` que puede ser «volar» o «no volar».
Se prefiere composición cuando las capacidades cambian con frecuencia.

## 6. Qué demuestran las pruebas

| Prueba | Qué demuestra |
|---|---|
| `gorrionSustituyeAlAve` | Un gorrión sí cumple el contrato |
| `pinguinoRompeElContrato` | El pingüino lanza una excepción inesperada (violación) |
| `elParcheUsaInstanceof` | El parche con `instanceof` es la señal de alerta |
| `todasLasAvesComen` | Todas las aves pueden sustituir a `Ave` |
| `todosLosVoladoresVuelan` | Todo `Volador` puede sustituir a `Volador` |
| `pinguinoNoPrometeVolar` | El pingüino es `Nadador` y no es `Volador` |

Ejecutar: `mvn test -Dtest="Aves*Test"`
