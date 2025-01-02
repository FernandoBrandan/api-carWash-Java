package com.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarwashServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarwashServiceApplication.class, args);
	}

}


/**
 * 
 * Docker mysql container and spring boot application
 * https://www.youtube.com/watch?v=ux1uzPAMRzk
 * 
 * 
 * Incio de la aplicacion
 * Controller recibe la peticion
 * Service realiza la logica de negocio
 * Repository realiza la consulta a la base de datos, utilizando el modelo
 * 
 * 
 * 
 */



