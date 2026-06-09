package org.example.ejer2;

public class MandoMedio implements Cargo {
    public static final String VALIDA_MANDOMEDIO = "Como mando medio solo juniors pueden estar a mi cargo";

    @Override
    public void admitirSubordinado(Cargo cargoSubordinado) {
        cargoSubordinado.serAdmitidoPorMandoMedio();
    }

    @Override
    public void serAdmitidoPorDirector() {
        // Un Mando Medio SÍ puede estar bajo el ala de un Director. Validación exitosa (no hace nada).
    }

    @Override
    public void serAdmitidoPorMandoMedio() {
        // Un Mando Medio no puede estar a cargo de otro Mando Medio
        throw new RuntimeException(VALIDA_MANDOMEDIO);
    }
}