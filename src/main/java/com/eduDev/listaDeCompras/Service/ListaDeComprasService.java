package com.eduDev.listaDeCompras.Service;

import com.eduDev.listaDeCompras.Dao.ListaDeComprasDAOH2;
import com.eduDev.listaDeCompras.Dao.iDao;
import com.eduDev.listaDeCompras.Model.ListaDeCompras;
import org.springframework.stereotype.Service;

@Service
public class ListaDeComprasService {
    private iDao<ListaDeCompras> listaDeComprasiDao;

    public ListaDeComprasService() {
        listaDeComprasiDao = new ListaDeComprasDAOH2();
    }
    public ListaDeCompras guardarListaDeCompras(ListaDeCompras listaDeCompras){
        return listaDeComprasiDao.guardar(listaDeCompras);
    }
}
