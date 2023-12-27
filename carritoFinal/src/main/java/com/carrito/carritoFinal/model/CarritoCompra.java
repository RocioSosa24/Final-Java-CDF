package com.carrito.carritoFinal.model;

import com.carrito.carritoFinal.controller.TiendaController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CarritoCompra {
     public static List<Vendible> listaProductos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void agregarProducto(Vendible producto){
        listaProductos.add(producto);
    }

    public void agregarRopa() {
        System.out.println("Ingrese id del producto para agregar al carrito");
        int idRopa = scanner.nextInt();
        if (idRopa >= 0 && idRopa < TiendaController.listaRopa.size()) {
            Vendible productoRopa = TiendaController.listaRopa.get(idRopa);
            CarritoCompra.agregarProducto(productoRopa);
            Producto productoR = (Producto) productoRopa;
            System.out.println("Se agregó " + productoR.getNombre() + " al carrito.");
        } else {
            System.out.println("Producto no encontrado. No se agregó ningún producto al carrito.");
        }
    }

    public void agregarComestible() {
        System.out.println("Ingrese id del producto para agregar al carrito");
        int idComestible = scanner.nextInt();
        if (idComestible >= 0 && idComestible < TiendaController.listaComestibles.size()) {
            Vendible productoComestible = TiendaController.listaComestibles.get(idComestible);
            CarritoCompra.agregarProducto(productoComestible);
            Producto productoC = (Producto) productoComestible;
            System.out.println("Se agregó " + productoC.getNombre() + " al carrito.");
        } else {
            System.out.println("Producto no encontrado. No se agregó ningún producto al carrito.");
        }
    }

    public void agregarElectronico() {
        System.out.println("Ingrese id del producto para agregar al carrito");
        int idElectronico = scanner.nextInt();
        if (idElectronico >= 0 && idElectronico < TiendaController.listaElectronicos.size()) {
            Vendible productoElectronico = TiendaController.listaElectronicos.get(idElectronico);
            CarritoCompra.agregarProducto(productoElectronico);
            Producto productoE = (Producto) productoElectronico;
            System.out.println("Se agregó " + productoE.getNombre() + " al carrito.");
        } else {
            System.out.println("Producto no encontrado. No se agregó ningún producto al carrito.");
        }
    }

    public void contenidoCarrito() {
        System.out.println("Contenido del carrito:");
        for (int indice = 0; indice < CarritoCompra.listaProductos.size(); indice++) {
            Producto producto = (Producto) CarritoCompra.listaProductos.get(indice);
            System.out.println("Id: " + indice);
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecioBase());
            System.out.println("-----------");
        }
    }

    public void verCarrito() {
        if (CarritoCompra.listaProductos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            contenidoCarrito();
        }
    }

    public void eliminarProducto() {
        if (CarritoCompra.listaProductos.isEmpty()) {
            System.out.println("El carrito está vacío.");

        } else {
            contenidoCarrito();

            System.out.println("Ingrese id del producto a eliminar del carrito");
            int idEliminar = scanner.nextInt();
            if (idEliminar >= 0 && idEliminar < CarritoCompra.listaProductos.size()) {
                Producto producto = (Producto) CarritoCompra.listaProductos.remove(idEliminar);
                System.out.println("Se quitó " + producto.getNombre() + " del carrito.");
            } else {
                System.out.println("Id no encontrado. No se eliminó ningún producto.");
            }
        }
    }

    public static void pagar(Double total){
        System.out.println("Ingrese dinero");
        Scanner scanner = new Scanner(System.in);
        double dinero = scanner.nextDouble();
        if (dinero<total){
            System.out.println("Dinero insuficiente, deje un producto o ingrese mas dinero.");
        }else {
            double vuelto = dinero - total;
            System.out.println("Su vuelto es de $" + vuelto + ". Gracias vuelva pronto!");
            System.exit(0);
        }
    }

    public static void aplicarDescuentos(int tipoCliente){
        double total = 0;
        for (Vendible producto:listaProductos){
            total+= producto.calcularPrecio();
        }
        if (tipoCliente==1){
            double descuentoRegular = total * 0.1;
           double totalRegular = total - descuentoRegular;
           System.out.println("Total de su compra: $" + totalRegular);
           pagar(totalRegular);
        }
        else {double descuentoPremium = total * 0.3;
            double totalPremium = total - descuentoPremium;
            System.out.println("Total de su compra: $" + totalPremium) ;
            pagar(totalPremium);
        }
    }
    public void pagarCarrito(){
        boolean valido;
        if (CarritoCompra.listaProductos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Indique tipo de cliente");
            do {
                valido = true;
                System.out.println("1. Cliente regular (10% de descuento)");
                System.out.println("2. Cliente premium (30% de descuento)");
                int tipoCliente = scanner.nextInt();
                switch (tipoCliente) {
                    case 1:
                        CarritoCompra.aplicarDescuentos(1);
                        break;
                    case 2:
                        CarritoCompra.aplicarDescuentos(2);
                        break;
                    default:
                        System.out.println("Ingrese un tipo de cliente válido");
                        valido = false;
                        break;
                }
            } while (!valido);
        }
    }
}
