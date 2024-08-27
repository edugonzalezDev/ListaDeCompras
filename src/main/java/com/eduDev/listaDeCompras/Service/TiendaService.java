package com.eduDev.listaDeCompras.Service;

import com.eduDev.listaDeCompras.Dao.ProductoDAOH2;
import com.eduDev.listaDeCompras.Dao.TiendaDAOH2;
import com.eduDev.listaDeCompras.Dao.iDao;
import com.eduDev.listaDeCompras.Model.Tienda;
import org.springframework.stereotype.Service;

@Service
public class TiendaService {
    private iDao<Tienda> tiendaiDao;
    public TiendaService() {
        tiendaiDao = new TiendaDAOH2();
    }
    public Tienda guardarTienda(Tienda tienda){
        return tiendaiDao.guardar(tienda);
    }
}
