package com.programacion2.liskov.figuras;

import com.programacion2.liskov.figuras.solucion.Cuadrado;
import com.programacion2.liskov.figuras.solucion.Forma;
import com.programacion2.liskov.figuras.solucion.Rectangulo;
import com.programacion2.liskov.figuras.violacion.PruebaDeSustitucion;
import java.util.List;

/**
 * Demostracion del Ejemplo 2 (Rectangulo y Cuadrado).
 *
 * @author Sebastian Lasso Vidal
 */
public final class DemoFiguras {

    private DemoFiguras() {
    }

    public static void ejecutar() {
        System.out.println("\n=== EJEMPLO 2: Rectangulo y Cuadrado (autor: Sebastian Lasso Vidal) ===");

        System.out.println("\n--- VIOLACION ---");
        int areaRect = PruebaDeSustitucion.areaTrasAjustar(
                new com.programacion2.liskov.figuras.violacion.Rectangulo(), 5, 4);
        int areaCuad = PruebaDeSustitucion.areaTrasAjustar(
                new com.programacion2.liskov.figuras.violacion.Cuadrado(), 5, 4);
        System.out.println("Rectangulo setAncho(5), setAlto(4) -> area = " + areaRect + " (esperado: 20)");
        System.out.println("Cuadrado   setAncho(5), setAlto(4) -> area = " + areaCuad + " (rompe lo esperado)");

        System.out.println("\n--- SOLUCION ---");
        List<Forma> formas = List.of(
                new Rectangulo(5, 4),
                new Rectangulo(5, 4).conAncho(6),
                new Cuadrado(4));
        for (Forma f : formas) {
            System.out.println(f + " -> area = " + f.area() + ", perimetro = " + f.perimetro());
        }
    }
}
