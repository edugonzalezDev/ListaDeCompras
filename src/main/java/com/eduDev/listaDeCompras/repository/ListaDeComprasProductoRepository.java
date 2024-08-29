package com.eduDev.listaDeCompras.repository;

import com.eduDev.listaDeCompras.entity.ListaDeComprasProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaDeComprasProductoRepository extends JpaRepository<ListaDeComprasProducto, Integer> {
}
