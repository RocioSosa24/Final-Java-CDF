package com.carrito.carritoFinal.controller;

import com.carrito.carritoFinal.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TiendaController {
    public static List<Ropa> listaRopa = null;
    public static List<Comestible> listaComestibles = null;
    public static List<Electronico> listaElectronicos = null;
    public void inicializarListas() {
        if (listaRopa == null) {
            listaRopa = new ArrayList<>();
            Ropa camisa = new Ropa("Camisa", 100, "Zara", "Blanca", "L");
            Ropa pantalon = new Ropa("Pantalón", 500, "Adidas", "Negro", "S");
            Ropa chaqueta = new Ropa("Chaqueta", 500,"Don Barredora", "Negra", "L");
            listaRopa.add(camisa);
            listaRopa.add(pantalon);
            listaRopa.add(chaqueta);
        }

        if (listaComestibles == null) {
            listaComestibles = new ArrayList<>();
            Comestible manzana = new Comestible("Manzana", 50);
            Comestible banana = new Comestible("Banana", 50);
            Comestible pera = new Comestible("Pera", 50);
            Comestible tomaco = new Comestible("Tomacco", 100);
            listaComestibles.add(manzana);
            listaComestibles.add(banana);
            listaComestibles.add(pera);
            listaComestibles.add(tomaco);
        }

        if (listaElectronicos == null) {
            listaElectronicos = new ArrayList<>();
            Electronico celular = new Electronico("Mouse Inalámbrico", 25000, "2022");
            Electronico teclado = new Electronico("Teclado Gamer", 50000, "2022");
            Electronico astrolabio = new Electronico("Astrolabio parlante", 20000, "1994");
            listaElectronicos.add(celular);
            listaElectronicos.add(teclado);
            listaElectronicos.add(astrolabio);
        }
    }
    @GetMapping("/ropa")
    public String ropa(Model model){
        inicializarListas();
        model.addAttribute("prendas", listaRopa);
        return "ropa";
    }
    @GetMapping("/comestible")
    public String comestible(Model model){
        inicializarListas();
        model.addAttribute("comestibles", listaComestibles);
        return "comestible";
    }
    @GetMapping("/electronico")
    public String electronico(Model model){
        inicializarListas();
        model.addAttribute("electronicos", listaElectronicos);
        return "electronico";
    }

}