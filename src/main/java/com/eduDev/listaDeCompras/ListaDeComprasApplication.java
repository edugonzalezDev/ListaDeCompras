package com.eduDev.listaDeCompras;

import com.eduDev.listaDeCompras.Dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListaDeComprasApplication {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(ListaDeComprasApplication.class, args);
	}

}
