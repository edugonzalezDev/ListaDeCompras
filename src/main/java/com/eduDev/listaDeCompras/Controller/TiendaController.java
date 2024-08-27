package com.eduDev.listaDeCompras.Controller;

import com.eduDev.listaDeCompras.Model.Tienda;
import com.eduDev.listaDeCompras.Service.TiendaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class TiendaController {
    private TiendaService tiendaService;

    public TiendaController() {
        tiendaService = new TiendaService();
    }

    @PostMapping
    public Tienda guardarTienda(@RequestBody Tienda tienda){
        return tiendaService.guardarTienda(tienda);
    }
}
