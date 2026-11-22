package com.programacion2.liskov.aves.solucion;

import java.util.ArrayList;
import java.util.List;

/**
 * Codigo cliente de la solucion: pide exactamente lo que necesita (un {@link Volador}).
 * Un Pinguino ni siquiera compila si se intenta pasar aqui: el error se detecta
 * en tiempo de compilacion y no en ejecucion.
 */
public final class ExhibicionAerea {

    private ExhibicionAerea() {
    }

    public static String hacerVolar(Volador volador) {
        return volador.volar();
    }

    public static List<String> hacerVolarATodos(List<? extends Volador> voladores) {
        List<String> resultados = new ArrayList<>();
        for (Volador v : voladores) {
            resultados.add(v.volar());
        }
        return resultados;
    }
}
