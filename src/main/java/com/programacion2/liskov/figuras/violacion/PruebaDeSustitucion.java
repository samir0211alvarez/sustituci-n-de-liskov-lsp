package com.programacion2.liskov.figuras.violacion;

/** Codigo cliente escrito pensando en {@link Rectangulo}. */
public final class PruebaDeSustitucion {

    private PruebaDeSustitucion() {
    }

    /** Fija ancho y alto y devuelve el area. Para un Rectangulo con (5, 4) se espera 20. */
    public static int areaTrasAjustar(Rectangulo r, int ancho, int alto) {
        r.setAncho(ancho);
        r.setAlto(alto);
        return r.area();
    }
}
