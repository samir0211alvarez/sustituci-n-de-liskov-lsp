package com.programacion2.liskov.figuras;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.programacion2.liskov.figuras.violacion.Cuadrado;
import com.programacion2.liskov.figuras.violacion.PruebaDeSustitucion;
import com.programacion2.liskov.figuras.violacion.Rectangulo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Estas pruebas DOCUMENTAN la violacion: pasan porque demuestran que Cuadrado rompe el contrato. */
class FigurasViolacionTest {

    @Test
    @DisplayName("Un Rectangulo con ancho 5 y alto 4 tiene area 20")
    void rectanguloCumpleLoEsperado() {
        assertEquals(20, PruebaDeSustitucion.areaTrasAjustar(new Rectangulo(), 5, 4));
    }

    @Test
    @DisplayName("VIOLACION: un Cuadrado en lugar de Rectangulo da 16, no 20")
    void cuadradoNoSustituyeAlRectangulo() {
        int area = PruebaDeSustitucion.areaTrasAjustar(new Cuadrado(), 5, 4);
        assertEquals(16, area);
        assertNotEquals(20, area);
    }
}
