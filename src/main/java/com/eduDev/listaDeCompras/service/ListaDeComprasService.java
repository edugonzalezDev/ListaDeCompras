package com.eduDev.listaDeCompras.service;

import com.eduDev.listaDeCompras.entity.ListaDeCompras;
import com.eduDev.listaDeCompras.repository.ListaDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListaDeComprasService {
    @Autowired
    private ListaDeComprasRepository listaDeComprasRepository;

    public ListaDeCompras guardarListaDeCompras(ListaDeCompras listaDeCompras){
        return listaDeComprasRepository.save(listaDeCompras);
    }
    public Optional<ListaDeCompras> buscarPorId(Integer id){
        return listaDeComprasRepository.findById(id);
    }
}