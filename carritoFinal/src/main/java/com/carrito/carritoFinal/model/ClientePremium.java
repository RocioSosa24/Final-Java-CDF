package com.carrito.carritoFinal.model;

public class ClientePremium implements Cliente{
    @Override
    public void realizarCompra(Vendible producto) {

        CarritoCompra.agregarProducto(producto);
    }
}
