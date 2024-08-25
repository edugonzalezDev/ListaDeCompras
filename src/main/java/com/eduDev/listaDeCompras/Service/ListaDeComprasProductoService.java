package com.eduDev.listaDeCompras.Service;

import com.eduDev.listaDeCompras.Dao.ListaDeComprasDAOH2;
import com.eduDev.listaDeCompras.Dao.ListaDeComprasProductoDAOH2;
import com.eduDev.listaDeCompras.Dao.iDao;
import com.eduDev.listaDeCompras.Model.ListaDeCompras;
import com.eduDev.listaDeCompras.Model.ListaDeComprasProducto;
import org.springframework.stereotype.Service;

@Service
public class ListaDeComprasProductoService {
    private iDao<ListaDeComprasProducto> listaDeComprasProductoiDao;

    public ListaDeComprasProductoService() {
        listaDeComprasProductoiDao = new ListaDeComprasProductoDAOH2();
    }

}
