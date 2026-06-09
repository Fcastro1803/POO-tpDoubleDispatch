package org.example.ejer5;

import java.time.LocalDate;

public class Deteriorada implements Condicion {
    @Override
    public int calcularDiasLibro(Libro libro) {
        return libro.calcularDiasBasePorPaginas();
    }

    @Override
    public int calcularDiasDisco(Disco disco) {
        if (disco.getAnioBanda() < 1980) {
            throw new RuntimeException("El disco está deteriorado y la banda es anterior a 1980. No se puede prestar.");
        }
        // Mayor o igual a 1980: se calcula el caso base (5 días) y se resta 1
        return Math.max(1, 5 - 1);
    }

    @Override
    public int calcularDiasRevista(Revista revista) {
        int aniosAntiguedad = LocalDate.now().getYear() - revista.getAnioPublicacion();
        int reduccion = (aniosAntiguedad > 10) ? 3 : 1;
        
        // Calculamos los días base que le corresponderían por páginas en otra condición
        int diasBase = revista.calcularDiasBasePorPaginas();
        return Math.max(1, diasBase - reduccion);
    }
}