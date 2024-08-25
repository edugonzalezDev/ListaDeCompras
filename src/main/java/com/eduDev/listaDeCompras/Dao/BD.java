package com.eduDev.listaDeCompras.Dao;


import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final Logger logger = Logger.getLogger(BD.class);
    private static final String SQL_DROP_TABLES = "DROP TABLE IF EXISTS LISTA_DE_COMPRAS_PRODUCTO; " + "DROP TABLE IF EXISTS PRODUCTO; " + "DROP TABLE IF EXISTS CATEGORIA_PRODUCTO; " + "DROP TABLE IF EXISTS LISTA_DE_COMPRAS; " + "DROP TABLE IF EXISTS TIENDA; ";
    private static final String SQL_CREATE_TIENDA =
                    "CREATE TABLE TIENDA(" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(50) NOT NULL, " +
                    "DIRECCION VARCHAR(100) NOT NULL" +
                    ");";
    private static final String SQL_CREATE_CATEGORIA_PRODUCTO =
                    "CREATE TABLE CATEGORIA_PRODUCTO(" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(50) NOT NULL" +
                    ");";
    private static final String SQL_CREATE_PRODUCTO =
                    "CREATE TABLE PRODUCTO(" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(20) NOT NULL, " +
                    "CATEGORIA_ID INT, " +
                    "UNIDAD_MEDIDA VARCHAR(20), " +
                    "CANT_BASE DECIMAL(10, 2), " +
                    "TIENDA_PREDETERMINADA_ID INT, " +
                    "FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA_PRODUCTO(ID), " +
                    "FOREIGN KEY (TIENDA_PREDETERMINADA_ID) REFERENCES TIENDA(ID)" +
                    ");";
    private static final String SQL_CREATE_LISTA_DE_COMPRAS =
                    "CREATE TABLE LISTA_DE_COMPRAS(" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(50) NOT NULL, " +
                    "FECHA_CREACION DATE NOT NULL, " +
                    "TIENDA_ID INT, " +
                    "FOREIGN KEY (TIENDA_ID) REFERENCES TIENDA(ID)" +
                    ");";
    private static final String SQL_CREATE_LISTA_DE_COMPRAS_PRODUCTO =
                    "CREATE TABLE LISTA_DE_COMPRAS_PRODUCTO (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "LISTA_DE_COMPRAS_ID INT NOT NULL, " +
                    "PRODUCTO_ID INT NOT NULL, " +
                    "CANTIDAD DOUBLE NOT NULL, " +
                    "FOREIGN KEY (LISTA_DE_COMPRAS_ID) REFERENCES LISTA_DE_COMPRAS(ID), " +
                    "FOREIGN KEY (PRODUCTO_ID) REFERENCES PRODUCTO(ID)" +
                    ");";
    private static final String SQL_INSERT_TIENDA =
            "INSERT INTO TIENDA (NOMBRE, DIRECCION) VALUES " +
                    "('Tienda Central', '123 Avenida Principal'), " +
                    "('Tienda Norte', '456 Calle Norte'), " +
                    "('Tienda Sur', '789 Calle Sur');";
    private static final String SQL_INSERT_CATEGORIA_PRODUCTO =
            "INSERT INTO CATEGORIA_PRODUCTO (NOMBRE) VALUES " +
                    "('Electrónica'), " +
                    "('Alimentos'), " +
                    "('Ropa');";
    private static final String SQL_INSERT_PRODUCTO =
            "INSERT INTO PRODUCTO (NOMBRE, CATEGORIA_ID, UNIDAD_MEDIDA, CANT_BASE, TIENDA_PREDETERMINADA_ID) VALUES " +
                    "('Laptop', 1, 'Unidad', 1, 1), " +
                    "('Manzana', 2, 'Kilogramo', 0.5, 2), " +
                    "('Camiseta', 3, 'Unidad', 1, 3);";
    private static final String SQL_INSERT_LISTA_DE_COMPRAS =
            "INSERT INTO LISTA_DE_COMPRAS (NOMBRE, FECHA_CREACION, TIENDA_ID) VALUES " +
                    "('Compra de Tecnología', '2024-08-01', 1), " +
                    "('Compra de Comestibles', '2024-08-02', 2), " +
                    "('Compra de Ropa', '2024-08-03', 3);";
    private static final String SQL_INSERT_LISTA_DE_COMPRAS_PRODUCTO =
            "INSERT INTO LISTA_DE_COMPRAS_PRODUCTO (LISTA_DE_COMPRAS_ID, PRODUCTO_ID, CANTIDAD) VALUES " +
                    "(1, 1, 5.0), " +
                    "(1, 2, 3.0), " +
                    "(2, 3, 2.0), " +
                    "(2, 1, 10.0), " +
                    "(3, 2, 1.0);";
    public static void crearTablas(){
        Connection connection=null;
        try{
            connection= getConnection();
            String SQL_CREAR_TABLAS = SQL_DROP_TABLES + SQL_CREATE_TIENDA + SQL_CREATE_CATEGORIA_PRODUCTO + SQL_CREATE_LISTA_DE_COMPRAS + SQL_CREATE_PRODUCTO + SQL_CREATE_LISTA_DE_COMPRAS_PRODUCTO;
            String SQL_INSERTAR_DATOS = SQL_INSERT_TIENDA + SQL_INSERT_CATEGORIA_PRODUCTO + SQL_INSERT_PRODUCTO + SQL_INSERT_LISTA_DE_COMPRAS + SQL_INSERT_LISTA_DE_COMPRAS_PRODUCTO;
            Statement statement= connection.createStatement();
            statement.execute(SQL_CREAR_TABLAS);
            statement.execute(SQL_INSERTAR_DATOS);
            logger.info("Datos creados correctamente");
        }catch (Exception e){
            logger.error("error inesperado: "+e.getMessage());
        }
    }


    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/ListaDeCompras","sa","sa");
    }
}
