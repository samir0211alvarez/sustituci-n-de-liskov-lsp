package com.programacion2.liskov.aves;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.programacion2.liskov.aves.solucion.Aguila;
import com.programacion2.liskov.aves.solucion.Ave;
import com.programacion2.liskov.aves.solucion.ExhibicionAerea;
import com.programacion2.liskov.aves.solucion.Gorrion;
import com.programacion2.liskov.aves.solucion.Nadador;
import com.programacion2.liskov.aves.solucion.Pinguino;
import com.programacion2.liskov.aves.solucion.Volador;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AvesSolucionTest {

    @Test
    @DisplayName("Todas las aves pueden sustituir a Ave y comer sin sorpresas")
    void todasLasAvesComen() {
        List<Ave> aves = List.of(new Gorrion(), new Aguila(), new Pinguino());
        for (Ave ave : aves) {
            assertFalse(ave.comer().isBlank());
        }
    }

    @Test
    @DisplayName("Todo Volador puede sustituir a Volador")
    void todosLosVoladoresVuelan() {
        List<String> resultados = ExhibicionAerea.hacerVolarATodos(List.of(new Gorrion(), new Aguila()));
        assertEquals(2, resultados.size());
        assertEquals("El aguila planea a gran altura", resultados.get(1));
    }

    @Test
    @DisplayName("El Pinguino es Ave y Nadador, pero no Volador")
    void pinguinoNoPrometeVolar() {
        Ave pinguino = new Pinguino();
        assertTrue(pinguino instanceof Nadador);
        assertFalse(pinguino instanceof Volador);
    }
}
