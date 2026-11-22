package com.programacion2.liskov;

import com.programacion2.liskov.aves.DemoAves;
import com.programacion2.liskov.figuras.DemoFiguras;

/**
 * Punto de entrada: ejecuta las demostraciones de los dos ejemplos del Principio de
 * Sustitucion de Liskov.
 *
 * @author Samir Correa Alvarez
 * @author Sebastian Lasso Vidal
 */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        DemoAves.ejecutar();
        DemoFiguras.ejecutar();
    }
}
