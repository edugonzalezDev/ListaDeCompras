package com.eduDev.listaDeCompras.Service;

import com.eduDev.listaDeCompras.Dao.ProductoDAOH2;
import com.eduDev.listaDeCompras.Dao.iDao;
import com.eduDev.listaDeCompras.Model.Producto;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private iDao<Producto> productoiDao;
    public ProductoService() {
        productoiDao = new ProductoDAOH2();
    }
    public Producto guardarProducto(Producto producto){
            return productoiDao.guardar(producto);
        }
}
