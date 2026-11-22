package com.programacion2.liskov.aves.violacion;

/**
 * Codigo cliente: esta escrito pensando en {@link Ave}, asi que deberia funcionar
 * con CUALQUIER subclase. Con {@link Pinguino} se rompe.
 */
public final class ExhibicionAerea {

    private ExhibicionAerea() {
    }

    /** Funciona con Gorrion, pero lanza una excepcion inesperada con Pinguino. */
    public static String hacerVolar(Ave ave) {
        return ave.volar();
    }

    /**
     * El "parche" tipico cuando se viola el LSP: preguntar por la subclase concreta.
     * Cada vez que aparece un instanceof asi, es una SENAL DE ALERTA: las subclases
     * no son realmente intercambiables.
     */
    public static String hacerVolarConParche(Ave ave) {
        if (ave instanceof Pinguino) {
            return "(se omite al pinguino)";
        }
        return ave.volar();
    }
}
