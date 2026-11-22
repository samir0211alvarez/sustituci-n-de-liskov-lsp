package com.programacion2.liskov.figuras.violacion;

/**
 * Subclase que VIOLA el LSP.
 * <p>
 * Matematicamente un cuadrado es un rectangulo, pero en codigo mantiene ancho == alto,
 * asi que cada setter cambia AMBOS lados. Rompe la postcondicion de {@link Rectangulo}
 * ("el otro lado no cambia").
 */
public class Cuadrado extends Rectangulo {

    @Override
    public void setAncho(int ancho) {
        this.ancho = ancho;
        this.alto = ancho;
    }

    @Override
    public void setAlto(int alto) {
        this.ancho = alto;
        this.alto = alto;
    }
}
