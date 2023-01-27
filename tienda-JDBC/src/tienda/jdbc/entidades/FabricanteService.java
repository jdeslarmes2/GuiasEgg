
package tienda.jdbc.entidades;

import tienda.jdbc.persistencia.FabricanteDAO;

public class FabricanteService {
    
        private FabricanteDAO dao;

    public FabricanteService() {
        this.dao = new FabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {

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

            //Creamos el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
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
    public Fabricante buscarFabricantePorId(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null) {
                throw new Exception("Debe indicar el id");
            }

            Fabricante fabricante = dao.buscarFabricantePorID(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
/**
    public Collection<Usuario> listarUsuario() throws Exception {

        try {

            Collection<Usuario> usuarios = dao.listarUsuarios();

            return usuarios;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirUsuarios() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Usuario> usuarios = listarUsuario();

            //Imprimimos los usuarios
            if (usuarios.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Usuario u : usuarios) {
                    System.out.println(u);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
**/
}