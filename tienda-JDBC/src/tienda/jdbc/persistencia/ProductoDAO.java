
package tienda.jdbc.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.jdbc.entidades.Fabricante;
import tienda.jdbc.entidades.FabricanteService;
import tienda.jdbc.entidades.Producto;



public final class ProductoDAO extends DAO{
    
    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");  //Si el usuario es nulo da este mensaje
            }

            String sql = "INSERT INTO Producto(codigo, nombre, precio, codigo_fabricante)"
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre()+ "', '" + producto.getPrecio()+ "', '" + producto.getFabricante().getCodigo()+ "' );";  //En la última parte de esta linea vinculo la relación con el codigo del Fabricante
      
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
        
         public void modificarIDProducto(Producto producto) throws Exception {   //Modifico empleado por medio del ID
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el empleado que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    +"' nombre= '" + producto.getNombre() + "' , precio = '" + producto.getPrecio() + "' , codigo_fabricante = " + producto.getFabricante().getCodigo()+ "WHERE codigo = '" + producto.getCodigo() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

        public void eliminarProducto(int codigo) throws Exception {                      //Elimino empleado por codigo de producto
        try {

            String sql = "DELETE FROM Producto WHERE codigo = '" + codigo + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }
    
        public Producto buscarProductoPorID (int codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Producto WHERE codigo = " + codigo + "";
            consultarBase(sql);        //Consulto a la base de datos por método que cree en DAO padre

            Producto producto = null;   //Lo hago nacer al empleado y luego lo relleno
            while (resultado.next()) {   // Si en resultado hay un valor próximo
                producto = new Producto();  //lo hago nacer
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigo_fabricante(resultado.getInt(4));

                
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    } 
         public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM Producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));      //Las posiciones son según el select de la búsqueda
                producto.setCodigo_fabricante(resultado.getInt(4));  //ACA NO PUEDE HACER VINCULACION ENTRE TABLAS
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    
        
        
        
        
        
    }    
         
         
         

    

