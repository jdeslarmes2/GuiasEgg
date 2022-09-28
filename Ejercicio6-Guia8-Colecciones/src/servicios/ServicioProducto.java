/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Producto;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ServicioProducto {
    
Scanner leer = new Scanner(System.in);
Producto p = new Producto();
HashMap <String, Integer> productos = new HashMap<>();


    
public Producto crearYCargarProducto(){
    
    System.out.println("Ingrese el nombre del producto: ");
    p.setNombre(leer.next());
    System.out.println("Ingrese el precio del producto: ");
    p.setPrecio(leer.nextInt());
    
    // Carga o añadir de objeto en Mapa
    productos.put(p.getNombre(), p.getPrecio());
    // Devolver objeto
    Producto p1 = new Producto(p.getNombre(), p.getPrecio());
    return p1;
    
}    

public void modificarPrecio(){
    
    String respuesta = null; 
    System.out.println("Cual es el producto al que desea cambiarle el precio: ");
    respuesta = leer.next();

    for (Map.Entry<String, Integer> aux : productos.entrySet()) {
        String key = aux.getKey();
        Integer value = aux.getValue();
        
        if(respuesta.equalsIgnoreCase(key)){
            System.out.println("Ingrese el nuevo precio del producto seleccionado: ");
            p.setPrecio(leer.nextInt());
            productos.put(key, p.getPrecio());
        }
    }
}

public void eliminarProducto(){
    
    String respuesta = null; 
    int cantidadProductos = productos.size();
    int cantidadInicial = productos.size();
    System.out.println("Cual es el producto que desea eliminar: ");
    respuesta = leer.next();
    
    for (Map.Entry<String, Integer> aux : productos.entrySet()) {
        String key = aux.getKey();
        Integer value = aux.getValue();
        
        if(respuesta.equalsIgnoreCase(key)){
            productos.remove(key, value);
            cantidadProductos --;
        }
        
    }
    if (cantidadProductos == cantidadInicial){
        System.out.println("No ha ingresado un producto de la lista");
    }
 
}

public void mostrarMap(){
    
    
    for (Map.Entry<String, Integer> aux : productos.entrySet()) {
        String key = aux.getKey();
        Integer value = aux.getValue();
        
        System.out.println("Producto: "+key+ " Precio: "+value+"$");
    }
 
}

public void menuProductos(){
    
    int respuesta=0;
    
    do{
    System.out.println("Seleccione la operación que desea realizar: ");
    System.out.println("1. Para introducir un nuevo producto");
    System.out.println("2. Modificar el precio de un producto");
    System.out.println("3. Eliminar un producto");
    System.out.println("4. Mostrar la lista productos de la tienda");
    System.out.println("5. Salir del menu");
    respuesta = leer.nextInt();
      switch (respuesta){

          case 1:
              crearYCargarProducto();
              break;
          case 2:
              modificarPrecio();
              break;
          case 3:
              eliminarProducto();
              break;
          case 4:
              mostrarMap();
              break;
          case 5:
              System.out.println("Saliendo de menu");
              break;        
       }
    } while(respuesta != 5);

}

}


