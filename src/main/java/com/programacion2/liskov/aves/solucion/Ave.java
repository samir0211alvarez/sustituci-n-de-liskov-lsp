package com.programacion2.liskov.aves.solucion;

/**
 * SOLUCION (Ejemplo 1): la clase base solo promete lo que TODAS las aves hacen.
 *
 * @author Samir Correa Alvarez
 */
public abstract class Ave {

    private final String nombre;

    protected Ave(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String comer();
}
