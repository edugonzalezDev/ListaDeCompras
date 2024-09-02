package com.eduDev.listaDeCompras.controller;

import com.eduDev.listaDeCompras.entity.ListaDeCompras;
import com.eduDev.listaDeCompras.entity.Tienda;
import com.eduDev.listaDeCompras.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tienda")
public class TiendaController {
    @Autowired
    private TiendaService tiendaService;


    @PostMapping
    public Tienda guardarTienda(@RequestBody Tienda tienda){
        return tiendaService.guardarTienda(tienda);
    }
    @GetMapping("/todas")
    public ResponseEntity<List<Tienda>> listarTiendas(){
        return ResponseEntity.ok(tiendaService.listarTiendas());
    };
    @DeleteMapping("/eliminar/{id}")
    public void eliminarTienda (@PathVariable Integer id) {
        tiendaService.eliminarTienda(id);
    }
}
