package com.carrito.carritoFinal.model;

public class ClienteRegular implements Cliente{
    @Override
    public void realizarCompra(Vendible producto) {

        CarritoCompra.agregarProducto(producto);
    }
}
