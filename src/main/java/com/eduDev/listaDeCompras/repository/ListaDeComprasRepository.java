package com.eduDev.listaDeCompras.repository;

import com.eduDev.listaDeCompras.entity.ListaDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaDeComprasRepository extends JpaRepository<ListaDeCompras, Integer> {
}
