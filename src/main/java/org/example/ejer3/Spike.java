package org.example.ejer3;

public class Spike implements TipoTarea {
    @Override
    public void admitirItem(TipoTarea tipoItem) {
        throw new RuntimeException("No puede crear TS o Spike como Tarea Compleja");
    }

    @Override
    public void serAdmitidoPorHistoriaUsuario() {
        throw new RuntimeException(HistoriaUsuario.VALIDA_HISTORIA);
    }

    @Override
    public void serAdmitidoPorEpica() {
        // Es válido. No arroja excepción.
    }
}