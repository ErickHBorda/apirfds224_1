package com.iis.app.bussiness.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //decoradores - anotacion de datos
@RequestMapping("")//define la URL base para las solicitudes manejadas por este controlador. En este caso, la URL base es la raíz ("").
public class IndexController {
    @GetMapping("")//mapea solicitudes HTTP GET a este método específico. La URL de la solicitud es la raíz ("")
    public ResponseEntity<SoIndexGet> actionIndexGet(){//Define el método actionIndexGet que maneja la solicitud GET
        SoIndexGet soIndexGet = new SoIndexGet();

        soIndexGet.setMessage("Bienvenido(a) a tu primera aplicación con Spring Boot.");
        soIndexGet.setType("success");

        return new ResponseEntity<>(soIndexGet, HttpStatus.OK); //Devuelve una nueva instancia de ResponseEntity que contiene soIndexGet como el cuerpo de la respuesta
    }
}
