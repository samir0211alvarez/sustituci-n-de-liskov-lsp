package com.programacion2.liskov.figuras.violacion;

/**
 * VIOLACION del LSP (Ejemplo 2).
 * <p>
 * Contrato implicito: {@code setAncho} cambia SOLO el ancho y {@code setAlto} cambia SOLO el alto.
 *
 * @author Sebastian Lasso Vidal
 */
public class Rectangulo {

    protected int ancho;
    protected int alto;

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int area() {
        return ancho * alto;
    }
}
