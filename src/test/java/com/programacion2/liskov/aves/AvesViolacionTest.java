package com.programacion2.liskov.aves;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.programacion2.liskov.aves.violacion.Ave;
import com.programacion2.liskov.aves.violacion.ExhibicionAerea;
import com.programacion2.liskov.aves.violacion.Gorrion;
import com.programacion2.liskov.aves.violacion.Pinguino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Estas pruebas DOCUMENTAN la violacion: pasan porque demuestran que el pinguino rompe el contrato. */
class AvesViolacionTest {

    @Test
    @DisplayName("Un Gorrion puede sustituir a un Ave")
    void gorrionSustituyeAlAve() {
        Ave ave = new Gorrion();
        assertEquals("El gorrion vuela entre las ramas", ExhibicionAerea.hacerVolar(ave));
    }

    @Test
    @DisplayName("VIOLACION: un Pinguino NO puede sustituir a un Ave (lanza una excepcion nueva)")
    void pinguinoRompeElContrato() {
        Ave ave = new Pinguino();
        assertThrows(UnsupportedOperationException.class, () -> ExhibicionAerea.hacerVolar(ave));
    }

    @Test
    @DisplayName("SENAL DE ALERTA: hace falta instanceof para parchar el problema")
    void elParcheUsaInstanceof() {
        assertEquals("(se omite al pinguino)", ExhibicionAerea.hacerVolarConParche(new Pinguino()));
    }
}
