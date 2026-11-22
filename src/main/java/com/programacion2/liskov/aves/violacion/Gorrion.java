package com.programacion2.liskov.aves.violacion;

/** Subclase correcta: cumple el contrato de {@link Ave}. */
public class Gorrion extends Ave {

    @Override
    public String volar() {
        return "El gorrion vuela entre las ramas";
    }
}
