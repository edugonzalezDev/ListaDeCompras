package com.eduDev.listaDeCompras.controller;

import com.eduDev.listaDeCompras.entity.ListaDeCompras;
import com.eduDev.listaDeCompras.service.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lista-de-compras")
public class ListaDeComprasController {
    @Autowired
    private ListaDeComprasService listaDeComprasService;

    @PostMapping
    public ListaDeCompras guardarListaDeCompras(@RequestBody ListaDeCompras listaDeCompras){
        return listaDeComprasService.guardarListaDeCompras(listaDeCompras);
    }
    @GetMapping("/buscar/{id}")
    public Optional<ListaDeCompras> buscarPorId(@PathVariable Integer id){
        return listaDeComprasService.buscarPorId(id);
    }
}
