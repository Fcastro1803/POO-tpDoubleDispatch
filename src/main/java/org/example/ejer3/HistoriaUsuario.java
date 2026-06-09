package org.example.ejer3;

public class HistoriaUsuario implements TipoTarea {
    public static final String VALIDA_HISTORIA = "Solo tareas de desarrollo se permiten en una historia de usuario";

    @Override
    public void admitirItem(TipoTarea tipoItem) {
        // Delegamos en el ítem hijo pasándole el contexto de Historia de Usuario
        tipoItem.serAdmitidoPorHistoriaUsuario();
    }

    @Override
    public void serAdmitidoPorHistoriaUsuario() {
        throw new RuntimeException(VALIDA_HISTORIA);
    }

    @Override
    public void serAdmitidoPorEpica() {
        throw new RuntimeException(Epica.VALIDA_EPICA);
    }
}