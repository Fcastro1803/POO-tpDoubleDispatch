package org.example.ejer2;

public class Director implements Cargo {
    public static final String VALIDA_DIRECTOR = "Como director solo mandos medios pueden estar a mi cargo";

    @Override
    public void admitirSubordinado(Cargo cargoSubordinado) {
        // Double dispatch: delegamos en el subordinado pasándole "this" (un Director)
        cargoSubordinado.serAdmitidoPorDirector();
    }

    @Override
    public void serAdmitidoPorDirector() {
        // Un Director no puede estar a cargo de otro Director
        throw new RuntimeException(VALIDA_DIRECTOR);
    }

    @Override
    public void serAdmitidoPorMandoMedio() {
        // Un Director no puede estar a cargo de un Mando Medio
        throw new RuntimeException(MandoMedio.VALIDA_MANDOMEDIO);
    }
}