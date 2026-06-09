package ejer2test;

import org.example.ejer2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void calculoSalarial() {
        var director = new EmpleadoJerarquico("director", 1500, new Director());
        var mandoMedio = new EmpleadoJerarquico("mandoMedio", 500, new MandoMedio());
        var empleadoRegular = new EmpleadoRegular("empleadoRegular", 100);

        director.agregarEmpleado(mandoMedio);
        mandoMedio.agregarEmpleado(empleadoRegular);

        var laserX = new LaserX(director);
        assertEquals(2100, laserX.masaSalarial());
    }

    @Test
    public void directorNoPuedeSerJefeDeJunior() {
        var director = new EmpleadoJerarquico("director1", 1000, new Director());
        var empleadoRegular = new EmpleadoRegular("empleadoRegular", 100);

        var e = assertThrows(RuntimeException.class, () -> {
            director.agregarEmpleado(empleadoRegular);
        });

        assertEquals(Director.VALIDA_DIRECTOR, e.getMessage());
    }

    @Test
    public void mandoMedioNoPuedeSerJefeDeDirector() {
        var director = new EmpleadoJerarquico("director1", 1000, new Director());
        var mandoMedio = new EmpleadoJerarquico("mandoMedio", 500, new MandoMedio());

        var e = assertThrows(RuntimeException.class, () -> {
            mandoMedio.agregarEmpleado(director);
        });

        assertEquals(MandoMedio.VALIDA_MANDOMEDIO, e.getMessage());
    }

    @Test
    public void directorPuedeSerJefeDeMandoMedio() {
        var director = new EmpleadoJerarquico("director1", 1000, new Director());
        var mandoMedio = new EmpleadoJerarquico("mandoMedio", 500, new MandoMedio());

        director.agregarEmpleado(mandoMedio);
        assertTrue(director.tieneDeEmpleadoA(mandoMedio));
    }

    @Test
    public void mandoMedioPuedeSerJefeDeJunior() {
        var mandoMedio = new EmpleadoJerarquico("mandoMedio", 500, new MandoMedio());
        var empleadoRegular = new EmpleadoRegular("empleadoRegular", 100);

        mandoMedio.agregarEmpleado(empleadoRegular);
        assertTrue(mandoMedio.tieneDeEmpleadoA(empleadoRegular));
    }
}