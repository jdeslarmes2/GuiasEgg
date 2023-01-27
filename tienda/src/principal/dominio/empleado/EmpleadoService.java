
package principal.dominio.empleado;

import principal.persistencia.EmpleadoDAO;

public class EmpleadoService {
    
        private EmpleadoDAO dao;

    public EmpleadoService() {
        this.dao = new EmpleadoDAO();
    }

    public void crearEmpleado(int id_empleado, String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
      //      if (correoElectronico.contains("@") == false) {
      //          throw new Exception("El correo electrónico es incorrecto");
      //      }
            if (id_empleado == 0 ) {
                throw new Exception("Debe indicar el id diferente a 0");
            }
            //if (clave.length() < 8) {
            //    throw new Exception("La clave no puede tener menos de 8 caracteres");
           // }
            //if (buscarEmpleadoPorIDEmpleado (id_empleado) != 0) {
            //    throw new Exception("Ya existe un empleado con el id indicado " + id_empleado);
            //}

            //Creamos el empleado
            Empleado empleado = new Empleado();
            empleado.setId_empleado(id_empleado);
            empleado.setNombre(nombre);
            dao.guardarEmpleado(empleado);
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

    public Usuario buscarUsuarioPorId(Integer id) throws Exception {

        try {

            //Validamos
            if (id == null) {
                throw new Exception("Debe indicar el id");
            }

            Usuario usuario = dao.buscarUsuarioPorId(id);

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

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