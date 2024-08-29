package com.eduDev.listaDeCompras.service;

import com.eduDev.listaDeCompras.entity.Producto;
import com.eduDev.listaDeCompras.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    public Producto guardarProducto(Producto producto){
            return productoRepository.save(producto);
        }
}
