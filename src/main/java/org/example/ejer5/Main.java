package org.example.ejer5;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Persona usuario = new Persona("Pepe");
        LocalDate hoy = LocalDate.now();

        // 1. Préstamo de un Libro Nuevo (350 páginas -> 4 días)
        Articulo libro = new Libro("Clean Code", 350, new Nueva());
        Prestamo prestamoLibro = new Prestamo(libro, usuario, hoy);
        System.out.println("Libro '" + prestamoLibro.getArticulo().getTitulo() + 
                           "' devuelto el: " + prestamoLibro.getFechaDevolucion());

        // 2. Préstamo de una Revista Deteriorada vieja (150 páginas -> base 3 días, >10 años -> resta 3 = mínimo 1 día)
        Articulo revistaVieja = new Revista("National Geographic 2005", 150, 2005, new Deteriorada());
        Prestamo prestamoRevista = new Prestamo(revistaVieja, usuario, hoy);
        System.out.println("Revista '" + prestamoRevista.getArticulo().getTitulo() + 
                           "' devuelta el: " + prestamoRevista.getFechaDevolucion());

        // 3. Intento de Préstamo de un Disco Deteriorado de banda antigua (< 1980)
        Articulo discoViejo = new Disco("Pink Floyd - The Wall", 1979, new Deteriorada());
        try {
            Prestamo prestamoImposible = new Prestamo(discoViejo, usuario, hoy);
        } catch (RuntimeException e) {
            System.out.println("Validación de negocio correcta: " + e.getMessage());
        }
    }
}