package com.eduDev.listaDeCompras.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ListaDeComprasProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "lista_de_compras_id", nullable = false)
    private ListaDeCompras listaDeCompras;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private double cantidad;
}
