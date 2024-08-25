package com.eduDev.listaDeCompras.Controller;

import com.eduDev.listaDeCompras.Model.ListaDeCompras;
import com.eduDev.listaDeCompras.Service.ListaDeComprasService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lista-de-compras")
public class ListaDeComprasController {
    private ListaDeComprasService listaDeComprasService;

    public ListaDeComprasController() {
        listaDeComprasService = new ListaDeComprasService();
    }
    @PostMapping
    public ListaDeCompras guardarListaDeCompras(@RequestBody ListaDeCompras listaDeCompras){
        return listaDeComprasService.guardarListaDeCompras(listaDeCompras);
    }
    @GetMapping("/buscar/{id}")
    public ListaDeCompras buscarPorId(@PathVariable Integer id){
        return listaDeComprasService.buscarPorId(id);
    }
}
