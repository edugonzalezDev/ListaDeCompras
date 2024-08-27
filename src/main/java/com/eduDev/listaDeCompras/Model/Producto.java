package com.eduDev.listaDeCompras.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class Producto {
    private int id;
    private String nombre;
    private CategoriaProducto categoriaProducto;
    private String unidadMedida;
    private double cantBase;
    private Tienda tienda;
}
