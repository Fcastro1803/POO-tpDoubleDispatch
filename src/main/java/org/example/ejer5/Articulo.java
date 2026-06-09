package org.example.ejer5;

public interface Articulo {
    // Primer despacho del Double Dispatch
    int calcularDiasPrestamo();
    String getTitulo();
}