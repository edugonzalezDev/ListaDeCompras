package com.eduDev.listaDeCompras.service;

import com.eduDev.listaDeCompras.entity.CategoriaProducto;
import com.eduDev.listaDeCompras.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProductoService {
    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    public CategoriaProducto guardarCategoriaProducto(CategoriaProducto categoriaProducto){
        return categoriaProductoRepository.save(categoriaProducto);
    }
}
