package com.eduDev.listaDeCompras.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    @OneToMany(mappedBy = "tienda",fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private List<Producto> productos = new ArrayList<>();
}
