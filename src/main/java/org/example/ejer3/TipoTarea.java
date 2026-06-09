package org.example.ejer3;

public interface TipoTarea {
    // Primer paso del Double Dispatch
    void admitirItem(TipoTarea tipoItem);

    // Segundo paso del Double Dispatch
    void serAdmitidoPorHistoriaUsuario();
    void serAdmitidoPorEpica();
}