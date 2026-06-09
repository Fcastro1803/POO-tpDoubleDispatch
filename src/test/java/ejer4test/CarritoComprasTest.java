package ejer4test;

import org.example.ejer4.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoComprasTest {

    @Test
    public void testClienteRegular() {
        // Reemplazo del enum por el objeto de comportamiento ClienteRegular
        var cliente = new Cliente("Jose", new ClienteRegular());
        var producto1 = new ServicioDigital("Hosting", 100, 0.10f);
        var producto2 = new ProductoFisico("Libro", 100, 15);

        var carrito = new CarritoCompras(cliente);
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);

        // Sigue dando 1731.0F
        assertEquals(1731.0F, carrito.calcularPrecio());
    }

    @Test
    public void testClienteCorporativo() {
        // Reemplazo del enum por el objeto de comportamiento ClienteCorporativo
        var cliente = new Cliente("Jose", new ClienteCorporativo());
        var producto1 = new ServicioDigital("Hosting", 100, 0.10f);
        var producto2 = new ProductoFisico("Libro", 100, 15);

        var carrito = new CarritoCompras(cliente);
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);

        // Sigue dando 971.0F
        assertEquals(971.0F, carrito.calcularPrecio());
    }
}