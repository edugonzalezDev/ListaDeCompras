package com.eduDev.listaDeCompras.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class CategoriaProducto {
    private int id;
    private String nombre;
}
