package com.eduDev.listaDeCompras.service;

import com.eduDev.listaDeCompras.entity.Tienda;
import com.eduDev.listaDeCompras.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;

    public Tienda guardarTienda(Tienda tienda){
        return tiendaRepository.save(tienda);
    }
}
