package com.programacion2.liskov.aves.violacion;

/**
 * Subclase que VIOLA el LSP.
 * <p>
 * Un pinguino es un ave, pero no vuela. Para "esconder" esa realidad lanza una excepcion
 * que {@link Ave#volar()} nunca lanzaba: se rompe la regla de "sin excepciones nuevas"
 * y la postcondicion de que volar() realmente hace volar.
 */
public class Pinguino extends Ave {

    @Override
    public String volar() {
        throw new UnsupportedOperationException("Los pinguinos no vuelan");
    }
}
