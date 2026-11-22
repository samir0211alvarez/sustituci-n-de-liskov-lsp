package com.programacion2.liskov.aves.violacion;

/**
 * VIOLACION del LSP (Ejemplo 1).
 * <p>
 * Esta clase promete que TODAS las aves vuelan: {@link #volar()} es parte de su contrato.
 * Ese es el error de modelado: no todas las aves cumplen la promesa.
 *
 * @author Samir Correa Alvarez
 */
public class Ave {

    /** Contrato: el ave vuela y devuelve una descripcion de lo que hizo. Nunca lanza excepciones. */
    public String volar() {
        return "El ave esta volando";
    }

    public String comer() {
        return "El ave esta comiendo";
    }
}
