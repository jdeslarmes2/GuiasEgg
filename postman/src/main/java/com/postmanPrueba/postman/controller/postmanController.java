
package com.postmanPrueba.postman.controller;

import com.postmanPrueba.postman.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class postmanController {
    

    // ESTA ES ENDPOINT DE LA API QUE PERMITA LA RECEPCION DE DATOS PARA QUE CON ELLOS CREO CLIENTES
    
    @PostMapping("/cliente")
    // Postmapping es una notation que se usa dentro de springboot para indicar con el endpoint que este método se realiza cuando es una solicitud HTTP POST
    public void crearCliente (@RequestBody Cliente cli){ //Con el requestbody indico que los datos del cliente vienen en la solicitud del cliente que viene en el body
        //Void por que es una acción que solo crea un cliente
        
        System.out.println("Cliente creado");
        System.out.println("Nombre: " + cli.getNombre());
        System.out.println("Apellido " + cli.getApellido());
        
        //Aca no se puede  probar con chrome por que no es un GET, acá es un POST, que en gral viene en un formulario del FRONTEND. POR ESO SE USA EL programa POSTMAN.
        //CUANDO uso el POSTMAN TENGO que completar el Body del mensaje http del post con los datos del CLIENTE en formato JSON, seleccionando en postman ROW y selecciono JSON, completo en postman el JSON describiendo las variables igual que en la CLASE dejinida como CLIENTE (id, nombre, apellido)
    }
    
    // LAS DOS TIPOS DE RESPUESTAS MAS UTILIZADAS
    
    @GetMapping ("/cliente/traer")
    @ResponseBody
    //Con la linea de arriba respondes en el body o cuerpo de la respuesta http en formato JSON
    public List<Cliente> traerClientes () {
        
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1L,"Zlatan", "Ibrahimovich" ));
        listaClientes.add(new Cliente(2L,"Cristiano", "Ronaldo" ));
        listaClientes.add(new Cliente(3L,"Lionel", "Messi" ));
     
        return listaClientes;
    }
    
    @GetMapping ("/pruebaresponse")
    ResponseEntity<String> traerRespuesta() {
        //Con la funcionalidad de ResponseEntity, la linea de arriba (que no es una notetion es un tipo de clase especial), permite manipular como se quiere cada una de las partes del paquete HTTP (en este caso indico el estado en la respuesta)
        return new ResponseEntity<>("Esta es una prueba de response", HttpStatus.NOT_FOUND); //respuesta personalizada
        //Esto lo uso para ej. responder de una manera especial, ej. no encontro el cliente buscado el correspondiente mensaje de código de error deol http
        //El http.status not found es un 404 y status code 200 ok son los más usados.
    }
    
}

