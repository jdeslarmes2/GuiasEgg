/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.jdbc.persistencia;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jdeslarmes
 */
public abstract class DAO {
    
    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
     protected void conectarBase() throws Exception {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:8080/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
      //metodo de desconexion de base de datos y le doy protected para compartir.
        protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) { // Hay que tratar de cerrar las conexiones una vez que obtengo el dato de la base de datos, si es null cierro.
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {  //con el throw , si luego de tratar (try) de cerrar encontras un error, lo atrapas pero no dejas de correr el programa, luego muestro el error
            throw ex;
        }
    }
     
      protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();                             //Conecto a base de datos con método anterior
            sentencia = conexion.createStatement();     // Preparo la variable sentencia, aca van a ir las query que hacia en SQL
            sentencia.executeUpdate(sql);               // ejecuto la sentencia que me llega, ejemplo para modificar db.
        } catch (SQLException ex) {
            // conexion.rollback();
            /*  Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda */
            
            //El rollback es para que si se encuentra un error después de haber ej insertado muchos datos, te permite ir volver a tras y que no se ejecute esas inserciones o modificaciones
             
            throw ex;
        } finally {                // Siempre se desconecta de la base de datos
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql); //en variable resultado traigo la busqueda o consulta y cuando me desconecto de la base de dato cierro esta variable resultado.
        } catch (Exception ex) {
            throw ex;
        }
    }
     
     
     
}
