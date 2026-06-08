package org.example.ejer1;

public abstract class Elemento {
    // 1. PRIMER DESPACHO
    public abstract String competirCon(Elemento otro);

    // 2. SEGUNDO DESPACHO
    public abstract String evaluarContraPiedra(Piedra piedra);
    public abstract String evaluarContraPapel(Papel papel);
    public abstract String evaluarContraTijera(Tijera tijera);
}
