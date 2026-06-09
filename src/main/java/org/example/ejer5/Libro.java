package org.example.ejer5;

public class Libro implements Articulo {
    private String titulo;
    private int paginas;
    private Condicion condicion;

    public Libro(String titulo, int paginas, Condicion condicion) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.condicion = condicion;
    }

    @Override
    public int calcularDiasPrestamo() {
        // Iniciamos el Double Dispatch pasando 'this'
        return this.condicion.calcularDiasLibro(this);
    }

    public int calcularDiasBasePorPaginas() {
        // 1 día cada 100 páginas, redondeando hacia arriba
        return (int) Math.ceil((double) this.paginas / 100);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}