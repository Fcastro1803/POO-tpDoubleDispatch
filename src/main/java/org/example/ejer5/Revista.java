package org.example.ejer5;

public class Revista implements Articulo {
    private String titulo;
    private int paginas;
    private int anioPublicacion;
    private Condicion condicion;

    public Revista(String titulo, int paginas, int anioPublicacion, Condicion condicion) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.anioPublicacion = anioPublicacion;
        this.condicion = condicion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return this.condicion.calcularDiasRevista(this);
    }

    public int calcularDiasBasePorPaginas() {
        if (this.paginas < 100) {
            return 2;
        } else if (this.paginas < 2000) {
            return 3;
        } else {
            return 5;
        }
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}