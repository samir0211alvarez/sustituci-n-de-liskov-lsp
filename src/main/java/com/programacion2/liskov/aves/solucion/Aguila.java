package com.programacion2.liskov.aves.solucion;

public class Aguila extends Ave implements Volador {

    public Aguila() {
        super("Aguila");
    }

    @Override
    public String comer() {
        return "El aguila caza un pez";
    }

    @Override
    public String volar() {
        return "El aguila planea a gran altura";
    }
}
