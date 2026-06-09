package org.example.ejer5;

public class Disco implements Articulo {
    private String titulo;
    private int anioBanda;
    private Condicion condicion;

    public Disco(String titulo, int anioBanda, Condicion condicion) {
        this.titulo = titulo;
        this.anioBanda = anioBanda;
        this.condicion = condicion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return this.condicion.calcularDiasDisco(this);
    }

    public int getAnioBanda() {
        return anioBanda;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}