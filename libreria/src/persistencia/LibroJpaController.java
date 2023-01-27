/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import libreria.entidades.Libro;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author jdeslarmes
 */
public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public LibroJpaController(){
        emf = Persistence.createEntityManagerFactory("libreriaPU");
    }

    public void create(Libro libro) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLibro(libro.getIsbn()) != null) {
                throw new PreexistingEntityException("Libro " + libro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            libro = em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = libro.getIsbn();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Libro findLibro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }


    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    // ---------------- ACA EMPIEZO CON BUSQUEDAS O QUERYS ESPECIFICAS EN BASE DE DATOS ---------------------------
      
      public Libro mostrarLibroPorNombre(String nom){
      EntityManager em = getEntityManager();
      

      //Ejercicio 1 punto 10
      //Busco Libro por nombre
      Libro libro1 = (Libro) em.createQuery("SELECT l"
                                             + " FROM Libro l"
                                             + " WHERE l.titulo LIKE :titulo").
                                             setParameter("titulo", nom).getSingleResult();
      
      //Ejercicio 1 punto 9 buscar libro por ISBN
      // Otro método que funciona es con el find 
      Libro libro2 = em.find(Libro.class, libro1.getIsbn());
      
      //List<Libro> libros = em.createQuery("SELECT * FROM Libro WHERE Libro.titulo LIKE :titulo").setParameter("titulo", nom).getResultList();
        return libro2;
        

      }

      
      //Parecido a Ejercicio 1 punto 11 traigo lista de libros pero con orta condición
      public void mostrarLibrosPorCantidadEjemplares(int ejemplares){
      EntityManager em = getEntityManager();
      
      
      Collection<Libro> librosPorEjemplares = em.createQuery("SELECT l"
                                             + " FROM Libro l"
                                             + " WHERE l.ejemplares = :ejemplares").
                                             setParameter("ejemplares", ejemplares).getResultList();
      
      //Recorremos for para imprimir
          for (Libro aux : librosPorEjemplares) {
              System.out.println(aux.toString());
          }
      }
      
     public void editarParametroLibro(int isbn){
      Scanner leer = new Scanner(System.in);
      EntityManager em = getEntityManager();
      
      try{


      Libro libro = (Libro) em.createQuery("SELECT l"
                                           + " FROM Libro l"
                                           + " WHERE l.isbn = :isbn").
                                           setParameter("isbn", isbn).getSingleResult();
      
      String nuevoTitulo =null;
      int nuevoAnio = 0;
          System.out.println("Indique el parámetro a modificar: (t)Título, ((a)anio");
          String respuesta = leer.next();
          if (respuesta.equalsIgnoreCase("t")){
              System.out.println("Ingrese el nuevo título: ");
              nuevoTitulo = leer.next();
          }else if (respuesta.equalsIgnoreCase("a")){
              System.out.println("Ingrese el nuevo año: ");
              nuevoAnio = leer.nextInt();
          } else if (!(respuesta.equalsIgnoreCase("t") || respuesta.equalsIgnoreCase("a"))){
              System.out.println("Su parámetro es incorrecto");
          } 
          
          if (nuevoTitulo !=null){
              libro.setTitulo(nuevoTitulo);
          }
          if (nuevoAnio !=0) {
              libro.setAnio(nuevoAnio);
          }
          
          em.getTransaction().begin();
          em.merge(libro);
          em.getTransaction().commit();
          
          System.out.println("Su parámetro se ha modificado en la base de datos");          
   
         }catch(NoResultException e) {                                           // Excepción por si no encuentar nombre
             System.out.println("No se encontró el libro indicado");   
         }
        
      }
     
     public void eliminarLibroPotNombre(String nombre){
      Scanner leer = new Scanner(System.in);
      EntityManager em = getEntityManager();
      
      try{


      Libro libro = (Libro) em.createQuery("SELECT l"
                                           + " FROM Libro l"
                                           + " WHERE l.titulo = :titulo").
                                           setParameter("titulo", nombre).getSingleResult();
     
      em.getTransaction().begin();
      em.remove(libro);
      em.getTransaction().commit();
      
                 System.out.println("El libro "+ nombre + " se ha borrado");
                 
      }catch(NoResultException e) {                                           // Excepción por si no encuentar nombre
             System.out.println("No se encontró el libro indicado");   
      }
    }
     
     public void mostrarLibrosPorAutor(String nombreAutor){
      EntityManager em = getEntityManager();
      
      
      Collection<Libro> libros = em.createQuery("SELECT l"
                                           + " FROM Libro l"
                                           + " WHERE l.autor.nombre LIKE :nombre").
                                              setParameter("nombre", "%" +nombreAutor+ "%").getResultList();
      
   //   Ejemplo del select del JUANMA
   //   "SELECT l FROM Libro l, Editorial e WHERE e.nombre LIKE :busqueda")
   //             .setParameter("busqueda", "%" + nombre + "%").getResultList();

      
      
      
      
      //Recorremos for para imprimir solo los libros con autor definido

      
          for (Libro aux : libros) {

                  System.out.println(aux.toString());

              }
          }
      
     }
     
     
     
