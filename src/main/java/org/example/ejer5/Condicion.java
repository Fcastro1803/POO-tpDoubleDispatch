package org.example.ejer5;

import java.time.LocalDate;

public interface Condicion {
    // Segundo despacho: la condición decide los días basándose en el artículo concreto
    int calcularDiasLibro(Libro libro);
    int calcularDiasDisco(Disco disco);
    int calcularDiasRevista(Revista revista);
}