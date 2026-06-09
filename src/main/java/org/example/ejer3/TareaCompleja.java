package org.example.ejer3;

import java.util.ArrayList;
import java.util.List;

public class TareaCompleja implements ItemDeProyecto {
    public static final String VALIDA_TAREA_COMPLEJA = "No puede crear TS o Spike como Tarea Compleja";
    private List<ItemDeProyecto> items;
    private int horasEstimadas;
    private TipoTarea tipoTarea;

    public TareaCompleja(int horasEstimadas, TipoTarea tipoTarea) {
        if (tipoTarea instanceof TareaDesarrollo || tipoTarea instanceof Spike) {
            throw new RuntimeException(VALIDA_TAREA_COMPLEJA);
        }
        this.horasEstimadas = horasEstimadas;
        this.tipoTarea = tipoTarea;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemDeProyecto item) {
        // Iniciamos el Doble Despacho polimórfico
        this.tipoTarea.admitirItem(item.tipoTarea());
        this.items.add(item);
    }

    public boolean contieneItem(ItemDeProyecto item) {
        return this.items.contains(item);
    }

    @Override
    public int horasTotales() {
        int totales = this.horasEstimadas;
        for (ItemDeProyecto item : items) {
            totales += item.horasTotales();
        }
        return totales;
    }

    @Override
    public TipoTarea tipoTarea() {
        return this.tipoTarea;
    }
}