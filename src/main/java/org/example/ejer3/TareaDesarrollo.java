package org.example.ejer3;

public class TareaDesarrollo implements TipoTarea {
    @Override
    public void admitirItem(TipoTarea tipoItem) {
        throw new RuntimeException("No puede crear TS o Spike como Tarea Compleja");
    }

    @Override
    public void serAdmitidoPorHistoriaUsuario() {
        // Es válido. No arroja excepción.
    }

    @Override
    public void serAdmitidoPorEpica() {
        throw new RuntimeException(Epica.VALIDA_EPICA);
    }
}