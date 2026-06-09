package ejer3test;

import org.example.ejer3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProyectoTest {

    @Test
    public void hitoriaNoPuedeContenerAHistoria() {
        var tareaCompleja = new TareaCompleja(10, new HistoriaUsuario());
        var tareaCompleja2 = new TareaCompleja(20, new HistoriaUsuario());
        var e = assertThrows(RuntimeException.class, () -> {
            tareaCompleja.agregarItem(tareaCompleja2);
        });

        assertEquals(HistoriaUsuario.VALIDA_HISTORIA, e.getMessage());
    }

    @Test
    public void hitoriaNoPuedeContenerASpike() {
        var tareaCompleja = new TareaCompleja(10, new HistoriaUsuario());
        var spike = new Tarea(20, new Spike());
        var e = assertThrows(RuntimeException.class, () -> {
            tareaCompleja.agregarItem(spike);
        });
        assertEquals(HistoriaUsuario.VALIDA_HISTORIA, e.getMessage());
    }

    @Test
    public void epicaNoPuedeContenerTareaDesarrollo() {
        var tareaCompleja = new TareaCompleja(10, new Epica());
        var td = new Tarea(20, new TareaDesarrollo());
        var e = assertThrows(RuntimeException.class, () -> {
            tareaCompleja.agregarItem(td);
        });
        assertEquals(Epica.VALIDA_EPICA, e.getMessage());
    }

    @Test
    public void noPuedoCrearUnaEpicaComoTareaSimple() {
        var e = assertThrows(RuntimeException.class, () -> {
            new Tarea(20, new Epica());
        });
        assertEquals(Tarea.VALIDA_TAREA_SIMPLE, e.getMessage());
    }

    @Test
    public void noPuedoCrearUnaHSComoTareaSimple() {
        var e = assertThrows(RuntimeException.class, () -> {
            new Tarea(20, new HistoriaUsuario());
        });
        assertEquals(Tarea.VALIDA_TAREA_SIMPLE, e.getMessage());
    }

    @Test
    public void noPuedoCrearUnSpikeComoTareaCompleja() {
        var e = assertThrows(RuntimeException.class, () -> {
            new TareaCompleja(20, new Spike());
        });
        assertEquals(TareaCompleja.VALIDA_TAREA_COMPLEJA, e.getMessage());
    }

    // --- TESTS AGREGADOS PARA COMPLETAR COBERTURA ---

    @Test
    public void historiaDeUsuarioPuedeContenerTareaDesarrolloYCalcularHoras() {
        var hs = new TareaCompleja(15, new HistoriaUsuario());
        var td1 = new Tarea(10, new TareaDesarrollo());
        var td2 = new Tarea(5, new TareaDesarrollo());

        hs.agregarItem(td1);
        hs.agregarItem(td2);

        assertTrue(hs.contieneItem(td1));
        assertEquals(30, hs.horasTotales()); // 15 + 10 + 5
    }

    @Test
    public void epicaPuedeContenerSpikesYCalcularHoras() {
        var epica = new TareaCompleja(40, new Epica());
        var spike = new Tarea(20, new Spike());

        epica.agregarItem(spike);

        assertTrue(epica.contieneItem(spike));
        assertEquals(60, epica.horasTotales()); // 40 + 20
    }
}