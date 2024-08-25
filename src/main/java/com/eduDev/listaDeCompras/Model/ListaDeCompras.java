package com.eduDev.listaDeCompras.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@Data
public class ListaDeCompras {
    private int id;
    private String nombre;
    private Date fechaCreacion;
    private int tiendaId;
}
