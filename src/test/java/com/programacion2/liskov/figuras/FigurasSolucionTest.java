package com.programacion2.liskov.figuras;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.programacion2.liskov.figuras.solucion.Cuadrado;
import com.programacion2.liskov.figuras.solucion.Forma;
import com.programacion2.liskov.figuras.solucion.Rectangulo;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FigurasSolucionTest {

    @Test
    @DisplayName("Rectangulo inmutable: cambiar un lado no afecta al otro")
    void rectanguloInmutable() {
        Rectangulo r = new Rectangulo(1, 1).conAncho(5).conAlto(4);
        assertEquals(20.0, r.area(), 1e-9);
    }

    @Test
    @DisplayName("Cuadrado tiene su propio comportamiento y no rompe a Rectangulo")
    void cuadradoIndependiente() {
        assertEquals(16.0, new Cuadrado(4).area(), 1e-9);
        assertEquals(16.0, new Cuadrado(1).conLado(4).perimetro(), 1e-9);
    }

    @Test
    @DisplayName("Cualquier Forma puede sustituir a Forma")
    void sustitucionPolimorfica() {
        List<Forma> formas = List.of(new Rectangulo(5, 4), new Cuadrado(4));
        double total = 0;
        for (Forma f : formas) {
            total += f.area();
        }
        assertEquals(36.0, total, 1e-9);
    }

    @Test
    @DisplayName("Las invariantes se respetan: no se permiten lados no positivos")
    void invariantes() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangulo(0, 3));
        assertThrows(IllegalArgumentException.class, () -> new Cuadrado(-1));
    }
}
