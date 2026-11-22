package com.programacion2.liskov.figuras.solucion;

/**
 * Rectangulo inmutable: en lugar de modificarse, devuelve un objeto nuevo.
 * Asi desaparece el problema de "cambiar un lado y afectar al otro".
 */
public record Rectangulo(double ancho, double alto) implements Forma {

    public Rectangulo {
        if (ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("Ancho y alto deben ser positivos");
        }
    }

    public Rectangulo conAncho(double nuevoAncho) {
        return new Rectangulo(nuevoAncho, alto);
    }

    public Rectangulo conAlto(double nuevoAlto) {
        return new Rectangulo(ancho, nuevoAlto);
    }

    @Override
    public double area() {
        return ancho * alto;
    }

    @Override
    public double perimetro() {
        return 2 * (ancho + alto);
    }
}
