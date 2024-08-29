package com.eduDev.listaDeCompras.controller;

import com.eduDev.listaDeCompras.entity.Tienda;
import com.eduDev.listaDeCompras.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class TiendaController {
    @Autowired
    private TiendaService tiendaService;


    @PostMapping
    public Tienda guardarTienda(@RequestBody Tienda tienda){
        return tiendaService.guardarTienda(tienda);
    }
}
