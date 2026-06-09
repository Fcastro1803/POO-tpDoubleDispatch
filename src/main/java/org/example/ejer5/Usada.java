package org.example.ejer5;

public class Usada implements Condicion {
    @Override
    public int calcularDiasLibro(Libro libro) {
        return libro.calcularDiasBasePorPaginas();
    }

    @Override
    public int calcularDiasDisco(Disco disco) {
        return disco.getAnioBanda() < 1980 ? 3 : 5;
    }

    @Override
    public int calcularDiasRevista(Revista revista) {
        return revista.calcularDiasBasePorPaginas();
    }
}