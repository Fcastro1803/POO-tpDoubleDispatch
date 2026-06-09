package org.example.ejer2;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos el director pasándole su comportamiento de Cargo
        var director1 = new EmpleadoJerarquico("unDirector", 100, new Director());

        // 2. Creamos el mando medio con su comportamiento de Cargo
        var mandoMedio = new EmpleadoJerarquico("mandoMedio", 50, new MandoMedio());

        // 3. El director admite al mando medio (Validación exitosa)
        director1.agregarEmpleado(mandoMedio);

        // 4. El empleado regular nace internamente como un Junior
        var empleadoRegular = new EmpleadoRegular("empleadoRegular", 100);

        // 5. El mando medio admite al junior (Validación exitosa)
        mandoMedio.agregarEmpleado(empleadoRegular);

        // 6. INTENTO INVÁLIDO: Un director no puede tener de subordinado a un junior.
        try {
            director1.agregarEmpleado(empleadoRegular);
        } catch (RuntimeException e) {
            System.out.println("Validación capturada exitosamente: " + e.getMessage());
        }

        // 7. Imprimimos el costo salarial total (100 + 50 + 100 = 250)
        new LaserX(director1).imprimirCostoSalarial();
    }
}