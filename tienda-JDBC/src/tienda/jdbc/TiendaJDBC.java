/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.jdbc;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.jdbc.entidades.ProductoService;

/**
 *
 * @author jdeslarmes
 */
public class TiendaJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        ProductoService productoService = new ProductoService();
        
       /** 
        * // EJERCICIO 1 F
        try{
            productoService.crearProducto(13, "Impresora nueva", 400, 3);
            
        }catch (Exception ex) {
            Logger.getLogger(TiendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // PRUEBA DE LISTAR TODOS LOS PRODUCTOS
        * 
        try{
            productoService.imprimirProductos();
            
        }catch (Exception ex) {
            Logger.getLogger(TiendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               // EJECICIO 1 A
        
        try{
            productoService.imprimirNombreProductos();
            
        }catch (Exception ex) {
            Logger.getLogger(TiendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        // EJECICIO 1 B
        
        try{
            productoService.imprimirNombrePrecioProductos();
            
        }catch (Exception ex) {
            Logger.getLogger(TiendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
         **/
       
       // EJERCICIO 1C
         try{
            productoService.imprimirPrecioProductosEntre();
            
        }catch (Exception ex) {
            Logger.getLogger(TiendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


