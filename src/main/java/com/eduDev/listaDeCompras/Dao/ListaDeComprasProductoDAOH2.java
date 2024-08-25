package com.eduDev.listaDeCompras.Dao;

import com.eduDev.listaDeCompras.Model.ListaDeComprasProducto;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ListaDeComprasProductoDAOH2 implements iDao<ListaDeComprasProducto>{
    private static final Logger logger = Logger.getLogger(ListaDeComprasProductoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO LISTA_DE_COMPRAS_PRODUCTO (LISTA_DE_COMPRAS_ID, PRODUCTO_ID, CANTIDAD) VALUES (?, ?, ?);";

    @Override
    public ListaDeComprasProducto guardar(ListaDeComprasProducto listaDeComprasProducto) {
        logger.info("Iniciando el guardado de la lista de compras");
        Connection connection = null;

        try {
            connection = BD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, listaDeComprasProducto.getListaDeComprasId());
            statement.setInt(2, listaDeComprasProducto.getProductoId());
            statement.setDouble(3, listaDeComprasProducto.getCantidad());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                listaDeComprasProducto.setId(rs.getInt(1)); // Obtén el ID generado automáticamente
            }


        }catch (Exception e){
            logger.error("Se han encontrado los siguientes problemas: "+e.getMessage());
        }

        return listaDeComprasProducto;
    }

    @Override
    public void actualizar(ListaDeComprasProducto listaDeComprasProducto) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<ListaDeComprasProducto> listarTodos() {
        return List.of();
    }

    @Override
    public ListaDeComprasProducto buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ListaDeComprasProducto buscarPorString(String string) {
        return null;
    }
}
