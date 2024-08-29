package com.eduDev.listaDeCompras.repository;

import com.eduDev.listaDeCompras.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
