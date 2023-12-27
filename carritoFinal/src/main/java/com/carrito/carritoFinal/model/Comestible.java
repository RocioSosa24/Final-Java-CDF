package com.carrito.carritoFinal.model;

public class Comestible extends Producto{
    public Comestible(String nombre, double precioBase) {
        super(nombre, precioBase);
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}
