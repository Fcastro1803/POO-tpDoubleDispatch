package org.example.ejer5;

import java.time.LocalDate;

public class Prestamo {
    private Articulo articulo;
    private Persona persona;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public Prestamo(Articulo articulo, Persona persona, LocalDate fechaInicio) {
        this.articulo = articulo;
        this.persona = persona;
        this.fechaInicio = fechaInicio;
        // El cálculo de días se delega polimórficamente al artículo
        int diasPrestamo = articulo.calcularDiasPrestamo();
        this.fechaDevolucion = fechaInicio.plusDays(diasPrestamo);
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public Persona getPersona() {
        return persona;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}