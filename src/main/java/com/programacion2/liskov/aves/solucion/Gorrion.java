package com.programacion2.liskov.aves.solucion;

public class Gorrion extends Ave implements Volador {

    public Gorrion() {
        super("Gorrion");
    }

    @Override
    public String comer() {
        return "El gorrion picotea semillas";
    }

    @Override
    public String volar() {
        return "El gorrion vuela entre las ramas";
    }
}
