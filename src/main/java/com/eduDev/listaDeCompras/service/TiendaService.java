package com.eduDev.listaDeCompras.service;

import com.eduDev.listaDeCompras.entity.Tienda;
import com.eduDev.listaDeCompras.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;

    public Tienda guardarTienda(Tienda tienda){
        return tiendaRepository.save(tienda);
    }
    public List<Tienda> listarTiendas() {
        return tiendaRepository.findAll();
    }
    public void eliminarTienda (Integer id){
        tiendaRepository.deleteById(id);
    }
}
