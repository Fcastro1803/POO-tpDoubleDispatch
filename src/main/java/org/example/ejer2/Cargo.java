package org.example.ejer2;

public interface Cargo {
    // Primer paso del Double Dispatch
    void admitirSubordinado(Cargo cargoSubordinado);

    // Segundo paso del Double Dispatch
    void serAdmitidoPorDirector();
    void serAdmitidoPorMandoMedio();
}