package com.programacion2.liskov.aves.solucion;

/** El pinguino es un Ave y es Nadador, pero NO es Volador: no promete lo que no puede hacer. */
public class Pinguino extends Ave implements Nadador {

    public Pinguino() {
        super("Pinguino");
    }

    @Override
    public String comer() {
        return "El pinguino come pescado";
    }

    @Override
    public String nadar() {
        return "El pinguino nada velozmente";
    }
}
