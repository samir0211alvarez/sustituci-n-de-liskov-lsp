# Ejemplo 2: Rectángulo y Cuadrado (el clásico)

**Autor:** Sebastian Lasso Vidal
**Paquetes:** `com.programacion2.liskov.figuras.violacion` y `com.programacion2.liskov.figuras.solucion`
**Pruebas:** `FigurasViolacionTest` y `FigurasSolucionTest`

## 1. El problema

En matemáticas todo cuadrado es un rectángulo, así que parece natural que `Cuadrado` herede de `Rectangulo`.
Pero en código, el cuadrado debe mantener el ancho igual al alto:

```java
public class Rectangulo {
    protected int ancho, alto;
    public void setAncho(int a) { ancho = a; }
    public void setAlto(int h)  { alto = h; }
    public int area() { return ancho * alto; }
}

public class Cuadrado extends Rectangulo {
    @Override public void setAncho(int a) { ancho = a; alto = a; }
    @Override public void setAlto(int h)  { ancho = h; alto = h; }
}
```

## 2. Por qué viola el principio

El contrato implícito de `Rectangulo` es que `setAncho` cambia **solo** el ancho y `setAlto` cambia **solo** el alto.
El código cliente se escribe confiando en eso:

```java
public static int areaTrasAjustar(Rectangulo r, int ancho, int alto) {
    r.setAncho(ancho);
    r.setAlto(alto);
    return r.area();
}
```

| Objeto | Cálculo | Resultado |
|---|---|---|
| `new Rectangulo()` con (5, 4) | 5 × 4 | **20** (lo esperado) |
| `new Cuadrado()` con (5, 4) | `setAlto(4)` también pone el ancho en 4: 4 × 4 | **16** (rompe lo esperado) |

`Cuadrado` rompe la **postcondición** de `Rectangulo` («el otro lado no cambia»). Un código escrito para
`Rectangulo` deja de funcionar con `Cuadrado`: no puede sustituirlo.

> **Idea clave:** el «es un» de las matemáticas no es el mismo «es un» de la programación.
> En programación, B «es un» A solo si **se comporta** como A en todo lo que A promete.

## 3. La solución

### Abstracción común

Se crea una interfaz con lo que **todas** las formas pueden hacer, y dos clases independientes:

```java
public interface Forma {
    double area();
    double perimetro();
}

public record Rectangulo(double ancho, double alto) implements Forma { ... }
public record Cuadrado(double lado) implements Forma { ... }
```

### Objetos inmutables

Las clases no tienen setters. En lugar de modificarse, devuelven un objeto nuevo:

```java
Rectangulo r = new Rectangulo(1, 1).conAncho(5).conAlto(4);   // area = 20
```

Así desaparece el problema de «cambiar un lado y afectar al otro». Además, el constructor valida las
**invariantes** (los lados deben ser positivos).

## 4. Comparación

| | Violación | Solución |
|---|---|---|
| Relación | `Cuadrado extends Rectangulo` | Ambas implementan `Forma` |
| Estado | Mutable (setters) | Inmutable (`conAncho`, `conLado`) |
| ¿Se puede sustituir? | No: 16 en lugar de 20 | Sí: cada clase respeta su propio contrato |
| Invariantes | No se validan | Lados positivos validados |

## 5. Qué demuestran las pruebas

| Prueba | Qué demuestra |
|---|---|
| `rectanguloCumpleLoEsperado` | Rectángulo (5, 4) da área 20 |
| `cuadradoNoSustituyeAlRectangulo` | Cuadrado (5, 4) da 16: la violación |
| `rectanguloInmutable` | Cambiar un lado no afecta al otro |
| `cuadradoIndependiente` | Cuadrado funciona con su propio contrato |
| `sustitucionPolimorfica` | Cualquier `Forma` puede sustituir a `Forma` |
| `invariantes` | No se permiten lados no positivos |

Ejecutar: `mvn test -Dtest="Figuras*Test"`
