package com.eduDev.listaDeCompras.service;

import com.eduDev.listaDeCompras.entity.ListaDeComprasProducto;
import com.eduDev.listaDeCompras.repository.ListaDeComprasProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaDeComprasProductoService {
    @Autowired
    private ListaDeComprasProductoRepository listaDeComprasProductoRepository;


}
