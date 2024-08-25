package com.eduDev.listaDeCompras.Dao;

import com.eduDev.listaDeCompras.Model.CategoriaProducto;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class CategoriaProductoDAOH2 implements iDao<CategoriaProducto>{
    private static final Logger logger = Logger.getLogger(CategoriaProductoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO CATEGORIA_PRODUCTO (NOMBRE) VALUES (?);";

    @Override
    public CategoriaProducto guardar(CategoriaProducto categoriaProducto) {
        logger.info("Iniciando el guardado de categoria de producto");
        Connection connection = null;

        try {
            connection = BD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoriaProducto.getNombre());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                categoriaProducto.setId(rs.getInt("id"));
            }

            logger.info("producto creado correctamente");
        }catch (Exception e){
            logger.error("Se han encontrado los siguientes problemas: "+e.getMessage());
        }

        return categoriaProducto;
    }

    @Override
    public void actualizar(CategoriaProducto categoriaProducto) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<CategoriaProducto> listarTodos() {
        return List.of();
    }

    @Override
    public CategoriaProducto buscarPorId(Integer id) {
        return null;
    }

    @Override
    public CategoriaProducto buscarPorString(String string) {
        return null;
    }
}
