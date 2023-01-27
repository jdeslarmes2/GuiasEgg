
package principal.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import principal.dominio.empleado.Empleado;


public final class EmpleadoDAO extends DAO{
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personal_PU");
    private EntityManager em = emf.createEntityManager();
    
    
    public void guardarEmpleado(Empleado empleado) throws Exception {
        try {
            if (empleado == null) {
                throw new Exception("Debe indicar el empleado");  //Si el usuario es nulo da este mensaje
            }
          
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
            
 //           String sql = "INSERT INTO Empleado (id_empleado, nombre, sexo_empleado, fecha_nacimiento, fecha_incorporacion, salario, comision, cargo, cod_jefe, id_depto)"
//                    + "VALUES ( '" + empleado.getId_empleado()+ "' , '" +empleado.getNombre() + "', '" +empleado.getSexo_empleado() + "', '" +empleado.getFecha_nacimiento() + "', '" +empleado.getFecha_incorporacion() + "', '" +empleado.getSalario()+ "', '" +empleado.getComision() + "', '" +empleado.getCargo()+ "', '" +empleado.getCod_jefe()+ "', '" +empleado.getId_depto() + "' );";

//            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
        
         public void modificarIDEmpleado(Empleado empleado) throws Exception {   //Modifico solo el ID de empleado por nombre
        try {
            if (empleado == null) {
                throw new Exception("Debe indicar el empleado que desea modificar");
            }

            String sql = "UPDATE Empleado SET "
                    + "id_empleado = '" + empleado.getId_empleado() + "' WHERE nombre= '" + empleado.getNombre() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

        public void eliminarEmpleado(String nombre) throws Exception {                      //Elimino empleado por nombre
        try {

            String sql = "DELETE FROM Empleado WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
        public Empleado buscarEmpleadoPorIDEmpleado (int id_empleado) throws Exception {
        try {

            String sql = "SELECT * FROM Empleado "
                    + " WHERE id_empleado = '" + id_empleado + "'";

            consultarBase(sql);        //Consulto a la base de datos por método que cree en DAO padre

            Empleado empleado = null;   //Lo hago nacer al empleado y luego lo relleno
            while (resultado.next()) {   // Si en resultado hay un valor próximo
                empleado = new Empleado();  //lo hago nacer
                empleado.setId_empleado(resultado.getInt(1));
                empleado.setNombre(resultado.getString(2));
                empleado.setSexo_empleado(resultado.getString(3));
                empleado.setFecha_nacimiento(resultado.getDate(4));
                empleado.setFecha_incorporacion(resultado.getDate(5));
                empleado.setSalario(id_empleado);
                empleado.setComision(id_empleado);
                empleado.setCargo(sql);
                empleado.setCod_jefe(sql);
                empleado.setId_depto(id_empleado);
                
            }
            desconectarBase();
            return empleado;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    } 
         public Collection<Empleado> listarEmpleados() throws Exception {
        try {
            String sql = "SELECT nombre, id_empleado FROM Empleado ";

            consultarBase(sql);

            Empleado empleado = null;
            Collection<Empleado> empleados = new ArrayList();
            while (resultado.next()) {
                empleado = new Empleado();
                empleado.setNombre(resultado.getString(1));    //Las posiciones son según el select de la búsqueda
                empleado.setId_empleado(resultado.getInt(2));
                empleados.add(empleado);
            }
            desconectarBase();
            return empleados;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
}
    

