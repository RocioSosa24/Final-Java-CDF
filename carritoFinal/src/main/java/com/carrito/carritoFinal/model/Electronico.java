package com.carrito.carritoFinal.model;

public class Electronico extends Producto{

    String modelo;

    public Electronico(String nombre, double precioBase, String modelo) {
        super(nombre, precioBase);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}
