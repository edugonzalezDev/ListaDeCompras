package com.eduDev.listaDeCompras.Controller;

import com.eduDev.listaDeCompras.Model.Producto;
import com.eduDev.listaDeCompras.Service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private ProductoService productoService;
    public ProductoController() {
        productoService = new ProductoService();
    }
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }



}
