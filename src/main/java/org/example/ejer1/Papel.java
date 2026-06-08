package org.example.ejer1;

public class Papel extends Elemento {

    @Override
    public String competirCon(Elemento otro) {
        return otro.evaluarContraPapel(this);
    }

    @Override
    public String evaluarContraPiedra(Piedra piedra) {
        return "Ganaste";
    }

    @Override
    public String evaluarContraPapel(Papel papel) {
        return "Empate";
    }

    @Override
    public String evaluarContraTijera(Tijera tijera) {
        return "Perdiste";
    }
}
