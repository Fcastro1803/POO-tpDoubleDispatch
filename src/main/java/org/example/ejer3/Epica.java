package org.example.ejer3;

public class Epica implements TipoTarea {
    public static final String VALIDA_EPICA = "Solo spikes se permiten en una epica";

    @Override
    public void admitirItem(TipoTarea tipoItem) {
        // Delegamos en el ítem hijo pasándole el contexto de Épica
        tipoItem.serAdmitidoPorEpica();
    }

    @Override
    public void serAdmitidoPorHistoriaUsuario() {
        throw new RuntimeException(HistoriaUsuario.VALIDA_HISTORIA);
    }

    @Override
    public void serAdmitidoPorEpica() {
        throw new RuntimeException(VALIDA_EPICA);
    }
}