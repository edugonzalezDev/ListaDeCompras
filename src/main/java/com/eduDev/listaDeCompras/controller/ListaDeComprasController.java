package com.eduDev.listaDeCompras.controller;

import com.eduDev.listaDeCompras.entity.ListaDeCompras;
import com.eduDev.listaDeCompras.entity.Tienda;
import com.eduDev.listaDeCompras.service.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/todas")
    public ResponseEntity<List<ListaDeCompras>> listarListaDeCOmpras(){
        return ResponseEntity.ok(listaDeComprasService.listarListaDeCompras());
    };
    @GetMapping("/buscar/{id}")
    public Optional<ListaDeCompras> buscarPorId(@PathVariable Integer id){
        return listaDeComprasService.buscarPorId(id);
    }
}
