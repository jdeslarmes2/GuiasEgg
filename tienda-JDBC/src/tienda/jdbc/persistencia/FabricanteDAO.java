
package tienda.jdbc.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.jdbc.entidades.Fabricante;




public final class FabricanteDAO extends DAO{
    
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");  //Si el usuario es nulo da este mensaje
            }

            String sql = "INSERT INTO Fabricante(codigo, nombre)"
                    + "VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre()+  "' );";
      
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
        
         public void modificarIDFabricante(Fabricante fabricante) throws Exception {   //Modifico solo el ID de empleado por nombre
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante que desea modificar");
            }

            String sql = "UPDATE Fabricante SET "
                    + "codigo = '" + fabricante.getCodigo() + "' WHERE nombre= '" + fabricante.getNombre() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

        public void eliminarFabricante(String nombre) throws Exception {                      //Elimino empleado por nombre
        try {

            String sql = "DELETE FROM Fabricante WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
        public Fabricante buscarFabricantePorID (int codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Fabricante "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);        //Consulto a la base de datos por método que cree en DAO padre

            Fabricante fabricante = null;   //Lo hago nacer al empleado y luego lo relleno
            while (resultado.next()) {   // Si en resultado hay un valor próximo
                fabricante = new Fabricante();  //lo hago nacer
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
               

                
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    } 
         public Collection<Fabricante> listarFabricante() throws Exception {
        try {
            String sql = "SELECT nombre, codigo FROM Fabricante ";

            consultarBase(sql);

            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setNombre(resultado.getString(1));    //Las posiciones son según el select de la búsqueda
                fabricante.setCodigo(resultado.getInt(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
}
    

