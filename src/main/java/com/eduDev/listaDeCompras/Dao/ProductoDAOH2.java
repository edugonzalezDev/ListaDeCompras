package com.eduDev.listaDeCompras.Dao;

import com.eduDev.listaDeCompras.Model.Producto;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ProductoDAOH2 implements iDao<Producto>{
    private static final Logger logger = Logger.getLogger(ProductoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO PRODUCTO (NOMBRE, CATEGORIA_ID, UNIDAD_MEDIDA, CANT_BASE, TIENDA_PREDETERMINADA_ID) VALUES (?,?,?,?,?);";


    @Override
    public Producto guardar(Producto producto) {
        logger.info("Iniciando el guardado del producto con ID: "+producto.getId());
        Connection connection = null;

        try {
            connection= BD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getCategoriaId());
            statement.setString(3,producto.getUnidadMedida());
            statement.setDouble(4, producto.getCantBase());
            statement.setInt(5, producto.getTiendaPredeterminadaId());
            statement.execute();
            ResultSet rs= statement.getGeneratedKeys();
            while (rs.next()){
                producto.setId(rs.getInt("id"));
            }
            logger.info("producto creado correctamente");
        }catch (Exception e){
            logger.error("Se han encontrado los siguientes problemas: "+e.getMessage());
        }

        return producto;
    }

    @Override
    public void actualizar(Producto producto) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Producto> listarTodos() {
        return List.of();
    }

    @Override
    public Producto buscarPorId(Integer id) {
        return null;
    }

    @Override
    public Producto buscarPorString(String string) {
        return null;
    }
}
