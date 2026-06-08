package org.example.ejer1;

public class Piedra extends Elemento {

    @Override
    public String competirCon(Elemento otro) {
        return otro.evaluarContraPiedra(this);
    }

    @Override
    public String evaluarContraPiedra(Piedra piedra) {
        return "Empate";
    }

    @Override
    public String evaluarContraPapel(Papel papel) {
        return "Perdiste";
    }

    @Override
    public String evaluarContraTijera(Tijera tijera) {
        return "Ganaste";
    }
}
