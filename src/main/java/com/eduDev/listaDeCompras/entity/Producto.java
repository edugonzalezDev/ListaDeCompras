package com.eduDev.listaDeCompras.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaProducto categoriaProducto;
    private String unidadMedida;
    private double cantBase;
    @ManyToOne
    @JoinColumn(name = "tienda_predeterminada_id", nullable = false)
    private Tienda tienda;
}
