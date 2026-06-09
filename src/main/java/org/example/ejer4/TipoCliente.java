package org.example.ejer4;

public interface TipoCliente {
    // Métodos para resolver el costo de envío según el tipo de producto
    float calcularEnvioFisico(ProductoFisico producto);
    float calcularEnvioDigital(ServicioDigital producto);

    // Métodos para resolver el impuesto según el tipo de producto
    float calcularImpuestoFisico(ProductoFisico producto);
    float calcularImpuestoDigital(ServicioDigital producto);
}