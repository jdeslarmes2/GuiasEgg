
package tienda.jdbc.entidades;


import java.util.Collection;
import tienda.jdbc.persistencia.ProductoDAO;

public class ProductoService {
    
        private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(int codigo, String nombre, double precio, int codigo_fabricante) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
      //      if (correoElectronico.contains("@") == false) {
      //          throw new Exception("El correo electrónico es incorrecto");
      //      }
            if (codigo == 0 ) {
                throw new Exception("Debe indicar el id diferente a 0");
            }
            //if (clave.length() < 8) {
            //    throw new Exception("La clave no puede tener menos de 8 caracteres");
           // }
            //if (buscarEmpleadoPorIDEmpleado (id_empleado) != 0) {
            //    throw new Exception("Ya existe un empleado con el id indicado " + id_empleado);
            //}

            //Creamos el producto
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigo_fabricante);
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
        }
/**
    public void modificarClaveUsuario(String correoElectronico, String claveActual, String nuevaClave) throws Exception {

        try {

            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el usuario");
            }

            if (claveActual == null || claveActual.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave actual");
            }

            if (nuevaClave == null || nuevaClave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave nueva");
            }

            //Buscamos
            Usuario usuario = buscarUsuarioPorCorreoElectronico(correoElectronico);

            //Validamos
            if (!usuario.getClave().equals(claveActual)) {
                throw new Exception("La clave actual no es la regsitrada en el sistema para el correo electrónico indicado");
            }

            //Modificamos
            usuario.setClave(nuevaClave);

            dao.modificarUsuario(usuario);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarUsuario(String correoElectronico) throws Exception {

        try {

            //Validamos 
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            dao.eliminarUsuario(correoElectronico);
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {

        try {

            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            Usuario usuario = dao.buscarUsuarioPorCorreoElectronico(correoElectronico);

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }
**/
    public Producto buscarProductoPorId(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo <0) {
                throw new Exception("Debe indicar el id");
            }

            Producto producto = dao.buscarProductoPorID(codigo);
            
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró producto");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
        public void imprimirNombreProductos() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos1 = listarProductos();

            //Imprimimos los productos
            if (productos1.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos1) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
          public void imprimirNombrePrecioProductos() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println("Nombre de producto: " + p.getNombre() + " Precio: "+ p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    } 
    
          public void imprimirPrecioProductosEntre() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    if (p.getPrecio() > 120 && p.getPrecio()< 220){
                    System.out.println("Nombre de producto: " + p.getNombre() + " Precio: "+ p.getPrecio());
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    } 
    
}

