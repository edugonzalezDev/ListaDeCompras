package com.eduDev.listaDeCompras.Controller;

import com.eduDev.listaDeCompras.Model.CategoriaProducto;
import com.eduDev.listaDeCompras.Service.CategoriaProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria-producto")
public class CategoriaProductoController {
    private CategoriaProductoService categoriaProductoService;

    public CategoriaProductoController() {
        categoriaProductoService = new CategoriaProductoService();
    }
    @PostMapping
    public CategoriaProducto guardarCategoriaProducto (@RequestBody CategoriaProducto categoriaProducto){
        return categoriaProductoService.guardarCategoriaProducto(categoriaProducto);
    }
}
