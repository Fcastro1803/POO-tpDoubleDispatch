package org.example.ejer2;

public class Junior implements Cargo {
    @Override
    public void admitirSubordinado(Cargo cargoSubordinado) {
        // Un Junior no es un empleado jerárquico, por ende no puede tener subordinados.
        throw new RuntimeException("Solo directores o mandos medios son empleados jerarquicos");
    }

    @Override
    public void serAdmitidoPorDirector() {
        // Según las reglas y los tests, un Junior no va directo al Director
        throw new RuntimeException(Director.VALIDA_DIRECTOR);
    }

    @Override
    public void serAdmitidoPorMandoMedio() {
        // Un Junior SÍ puede estar a cargo de un Mando Medio. Validación exitosa.
    }
}