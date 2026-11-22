package com.programacion2.liskov.aves;

import com.programacion2.liskov.aves.solucion.Aguila;
import com.programacion2.liskov.aves.solucion.Ave;
import com.programacion2.liskov.aves.solucion.Gorrion;
import com.programacion2.liskov.aves.solucion.Pinguino;
import java.util.List;

/**
 * Demostracion del Ejemplo 1 (Ave y Pinguino).
 *
 * @author Samir Correa Alvarez
 */
public final class DemoAves {

    private DemoAves() {
    }

    public static void ejecutar() {
        System.out.println("=== EJEMPLO 1: Ave y Pinguino (autor: Samir Correa Alvarez) ===");

        System.out.println("\n--- VIOLACION ---");
        com.programacion2.liskov.aves.violacion.Ave gorrion = new com.programacion2.liskov.aves.violacion.Gorrion();
        com.programacion2.liskov.aves.violacion.Ave pinguino = new com.programacion2.liskov.aves.violacion.Pinguino();
        System.out.println("Con Gorrion : " + com.programacion2.liskov.aves.violacion.ExhibicionAerea.hacerVolar(gorrion));
        try {
            System.out.println("Con Pinguino: " + com.programacion2.liskov.aves.violacion.ExhibicionAerea.hacerVolar(pinguino));
        } catch (UnsupportedOperationException e) {
            System.out.println("Con Pinguino: EXCEPCION INESPERADA -> " + e.getMessage());
            System.out.println("El pinguino NO puede sustituir al ave.");
        }

        System.out.println("\n--- SOLUCION ---");
        List<Ave> aves = List.of(new Gorrion(), new Aguila(), new Pinguino());
        for (Ave ave : aves) {
            System.out.println(ave.getNombre() + " -> " + ave.comer());
        }
        System.out.println("Solo los que implementan Volador vuelan:");
        com.programacion2.liskov.aves.solucion.ExhibicionAerea
                .hacerVolarATodos(List.of(new Gorrion(), new Aguila()))
                .forEach(s -> System.out.println("  " + s));
    }
}
