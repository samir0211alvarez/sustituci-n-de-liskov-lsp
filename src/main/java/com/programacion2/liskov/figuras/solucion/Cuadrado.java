package com.programacion2.liskov.figuras.solucion;

/** Cuadrado independiente de Rectangulo: comparte solo la interfaz {@link Forma}. */
public record Cuadrado(double lado) implements Forma {

    public Cuadrado {
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser positivo");
        }
    }

    public Cuadrado conLado(double nuevoLado) {
        return new Cuadrado(nuevoLado);
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;
    }
}
