package com.eduDev.listaDeCompras.Dao;

import com.eduDev.listaDeCompras.Model.ListaDeCompras;
import com.eduDev.listaDeCompras.Model.ListaDeComprasProducto;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ListaDeComprasDAOH2 implements iDao<ListaDeCompras>{
    private static final Logger logger = Logger.getLogger(ProductoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO LISTA_DE_COMPRAS (NOMBRE, FECHA_CREACION, TIENDA_ID) VALUES (?, ?, ?);";
    private static final String SQL_SELECT_BY_ID ="SELECT * FROM LISTA_DE_COMPRAS WHERE ID=?";

    @Override
    public ListaDeCompras guardar(ListaDeCompras listaDeCompras) {
        logger.info("Iniciando el guardado de la lista de compras");
        Connection connection = null;

        try {
            connection = BD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, listaDeCompras.getNombre());
            statement.setDate(2, listaDeCompras.getFechaCreacion());
            statement.setInt(3, listaDeCompras.getTiendaId());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                listaDeCompras.setId(rs.getInt("id"));
            }
        }catch (Exception e){
            logger.error("Se han encontrado los siguientes problemas: "+e.getMessage());
        }

        return listaDeCompras;
    }

    @Override
    public void actualizar(ListaDeCompras listaDeCompras) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<ListaDeCompras> listarTodos() {
        return List.of();
    }

    @Override
    public ListaDeCompras buscarPorId(Integer id) {
        logger.info("Iniciando la busqueda de lista de compras por ID:" +id);
        Connection connection=null;
        ListaDeCompras listaDeCompras=null;
        ListaDeComprasProducto listaDeComprasProducto=null;


        try {
            connection = BD.getConnection();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_BY_ID);
            psSelectOne.setInt(1,id);

            ResultSet rs = psSelectOne.executeQuery();


            while (rs.next()) {
                listaDeCompras = new ListaDeCompras(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getDate("FECHA_CREACION"),
                        rs.getInt("TIENDA_ID")
                );
            }

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }

        return listaDeCompras;
    }

    @Override
    public ListaDeCompras buscarPorString(String string) {
        return null;
    }
}
