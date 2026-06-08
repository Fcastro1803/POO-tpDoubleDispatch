package org.example.ejer1;

public class Tijera extends Elemento {

    @Override
    public String competirCon(Elemento otro) {
        return otro.evaluarContraTijera(this);
    }

    @Override
    public String evaluarContraPiedra(Piedra piedra) {
        return "Perdiste";
    }

    @Override
    public String evaluarContraPapel(Papel papel) {
        return "Ganaste";
    }

    @Override
    public String evaluarContraTijera(Tijera tijera) {
        return "Empate";
    }
}
