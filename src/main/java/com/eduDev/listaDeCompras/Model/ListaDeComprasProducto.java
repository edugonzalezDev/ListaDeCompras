package com.eduDev.listaDeCompras.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListaDeComprasProducto {
    private int id;
    private int listaDeComprasId;
    private int productoId;
    private double cantidad;
}
