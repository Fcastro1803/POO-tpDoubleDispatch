package org.example.ejer2;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoJerarquico implements Empleado {
    private final String nombre;
    private List<Empleado> empleados;
    private float salario;
    private Cargo cargo;

    public EmpleadoJerarquico(String nombre, float salario, Cargo cargo) {
        // Evitamos que se cree un EmpleadoJerarquico con el rol de Junior
        if (cargo instanceof Junior) {
            throw new RuntimeException("Solo directores o mandos medios son empleados jerarquicos");
        }
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = cargo;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        // Doble Despacho
        // Mi cargo evalúa si admite el cargo del empleado entrante
        this.cargo.admitirSubordinado(empleado.cargo());

        this.empleados.add(empleado);
    }

    public boolean tieneDeEmpleadoA(Empleado empleado) {
        return this.empleados.contains(empleado);
    }

    @Override
    public float calcularSalario() {
        float total = this.salario;
        for (Empleado m : empleados) {
            total += m.calcularSalario();
        }
        return total;
    }

    @Override
    public Cargo cargo() {
        return this.cargo;
    }
}