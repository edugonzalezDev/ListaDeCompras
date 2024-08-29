package com.eduDev.listaDeCompras.repository;

import com.eduDev.listaDeCompras.entity.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {
}
