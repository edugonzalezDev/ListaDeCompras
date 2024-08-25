package com.eduDev.listaDeCompras.Service;

import com.eduDev.listaDeCompras.Dao.CategoriaProductoDAOH2;
import com.eduDev.listaDeCompras.Dao.iDao;
import com.eduDev.listaDeCompras.Model.CategoriaProducto;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProductoService {
    private iDao<CategoriaProducto> categoriaProductoiDao;

    public CategoriaProductoService() {
        categoriaProductoiDao = new CategoriaProductoDAOH2();
    }
    public CategoriaProducto guardarCategoriaProducto(CategoriaProducto categoriaProducto){
        return categoriaProductoiDao.guardar(categoriaProducto);
    }
}
