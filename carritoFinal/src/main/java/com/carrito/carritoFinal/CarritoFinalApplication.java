package com.carrito.carritoFinal;

import com.carrito.carritoFinal.controller.TiendaController;
import com.carrito.carritoFinal.model.CarritoCompra;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class CarritoFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarritoFinalApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        CarritoCompra accionesCarrito = new CarritoCompra();
        TiendaController tiendaController = new TiendaController();

        boolean salir;

        tiendaController.inicializarListas();
        System.out.println("Bienvenido!");

        do {
            salir = false;
            System.out.println("Seleccione una opcion");
            System.out.println("1.Agregar productos al carrito");
            System.out.println("2.Ver productos en carrito");
            System.out.println("3.Eliminar producto del carrito");
            System.out.println("4.Pagar carrito");
            System.out.println("5.Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    boolean volver;
                    do {
                        System.out.println("1.Agregar ropa");
                        System.out.println("2.Agregar frutas y verduras");
                        System.out.println("3.Agregar electronicos");
                        System.out.println("4.Volver");
                        int opcionAgregar = scanner.nextInt();
                        volver = false;
                        switch (opcionAgregar) {
                            case 1:
                                accionesCarrito.agregarRopa();
                                break;
                            case 2:
                                accionesCarrito.agregarComestible();
                                break;
                            case 3:
                                accionesCarrito.agregarElectronico();
                                break;
                            case 4:
                                volver = true;
                                break;
                            default:
                                System.out.println("Elija una opción válida.");
                                break;
                        }
                    } while (!volver);
                    break;
                case 2:
                    accionesCarrito.verCarrito();
                    break;

                case 3:
                    accionesCarrito.eliminarProducto();
                    break;
                case 4:
                    accionesCarrito.pagarCarrito();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Elija una opción válida.");
                    break;
            }

        } while (!salir);
        System.out.println("¡Gracias, vuelva pronto!");
        System.exit(0);

    }
}
