package org.example.ejer4;

public class ProductoFisico implements Producto {
    private float precio;
    private float iva;
    private String nombre;
    private int peso;

    public ProductoFisico(String nombre, float precio, int peso) {
        this.precio = precio;
        this.nombre = nombre;
        this.peso = peso;
        this.iva = 0.21f;
    }

    @Override
    public float precio() {
        return precio;
    }

    @Override
    public float costoEnvio(TipoCliente tipo) {
        // Primer despacho: delegamos la resolución en el tipo de cliente
        return tipo.calcularEnvioFisico(this);
    }

    @Override
    public float impuesto(TipoCliente tipo) {
        // Primer despacho: delegamos la resolución en el tipo de cliente
        return tipo.calcularImpuestoFisico(this);
    }

    // Getters auxiliares para el Doble Despacho
    public int getPeso() {
        return peso;
    }

    public float getIva() {
        return iva;
    }
}