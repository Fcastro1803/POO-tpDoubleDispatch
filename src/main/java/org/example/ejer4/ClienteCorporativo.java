package org.example.ejer4;

public class ClienteCorporativo implements TipoCliente {
    @Override
    public float calcularEnvioFisico(ProductoFisico producto) {
        // Cliente corporativo obtiene un 50% de descuento en el envío físico
        float costoBase = producto.precio() * producto.getPeso();
        return costoBase - (costoBase * 0.5f);
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
        // Cliente corporativo está exento de impuestos digitales
        return 0;
    }
}