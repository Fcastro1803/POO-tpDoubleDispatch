package org.example.ejer4;

public class ClienteRegular implements TipoCliente {
    @Override
    public float calcularEnvioFisico(ProductoFisico producto) {
        // Cliente regular paga el costo de envío completo: precio * peso
        return producto.precio() * producto.getPeso();
    }

    @Override
    public float calcularEnvioDigital(ServicioDigital producto) {
        return 0;
    }

    @Override
    public float calcularImpuestoFisico(ProductoFisico producto) {
        return producto.precio() * producto.getIva();
    }

    @Override
    public float calcularImpuestoDigital(ServicioDigital producto) {
        // Cliente regular paga el 10% de impuesto en servicios digitales
        return producto.precio() * 0.10f;
    }
}