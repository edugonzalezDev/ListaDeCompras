package com.eduDev.listaDeCompras.Dao;

import com.eduDev.listaDeCompras.Model.Tienda;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class TiendaDAOH2 implements iDao<Tienda>{
    private static final Logger logger = Logger.getLogger(TiendaDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO TIENDA (NOMBRE, DIRECCION) VALUES (?, ?);";

    @Override
    public Tienda guardar(Tienda tienda) {
        logger.info("Inigiando el guardado de la tienda");
        Connection connection=null;

        try {
            connection = BD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,tienda.getNombre());
            statement.setString(2, tienda.getDireccion());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                tienda.setId(rs.getInt("id"));
            }
            logger.info("Se ha guardado la tienda");
        }catch (Exception e){
            logger.info("Ha ocurrido un error: "+e.getMessage());
        }

        return tienda;
    }

    @Override
    public void actualizar(Tienda tienda) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Tienda> listarTodos() {
        return List.of();
    }

    @Override
    public Tienda buscarPorId(Integer id) {
        return null;
    }

    @Override
    public Tienda buscarPorString(String string) {
        return null;
    }
}
