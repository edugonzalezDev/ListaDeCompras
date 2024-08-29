package com.eduDev.listaDeCompras.controller;

import com.eduDev.listaDeCompras.entity.CategoriaProducto;
import com.eduDev.listaDeCompras.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria-producto")
public class CategoriaProductoController {
    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @PostMapping
    public CategoriaProducto guardarCategoriaProducto (@RequestBody CategoriaProducto categoriaProducto){
        return categoriaProductoService.guardarCategoriaProducto(categoriaProducto);
    }
}
