/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.LibroServicio;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author jdeslarmes
 */
public class EditorialJpaController implements Serializable {

    //LibroJpaController libroJpa = new LibroJpaController();
    
    public EditorialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
        public EditorialJpaController(){
        emf = Persistence.createEntityManagerFactory("libreriaPU");
    }

    public void create(Editorial editorial) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEditorial(editorial.getId()) != null) {
                throw new PreexistingEntityException("Editorial " + editorial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Editorial editorial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            editorial = em.merge(editorial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = editorial.getId();
                if (findEditorial(id) == null) {
                    throw new NonexistentEntityException("The editorial with id " + id + " no longer exists.");
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
            Editorial editorial;
            try {
                editorial = em.getReference(Editorial.class, id);
                editorial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The editorial with id " + id + " no longer exists.", enfe);
            }
            em.remove(editorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Editorial> findEditorialEntities() {
        return findEditorialEntities(true, -1, -1);
    }

    public List<Editorial> findEditorialEntities(int maxResults, int firstResult) {
        return findEditorialEntities(false, maxResults, firstResult);
    }

    private List<Editorial> findEditorialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Editorial.class));
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

    public Editorial findEditorial(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Editorial.class, id);
        } finally {
            em.close();
        }
    }

    public int getEditorialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Editorial> rt = cq.from(Editorial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public boolean validarEditorialPorNombre(String nom){
      EntityManager em = getEntityManager();

       boolean respuesta = false;
       Collection<Editorial> editoriales = em.createQuery("SELECT e"
                                             + " FROM Editorial e").getResultList();
      
      //Recorremos for para imprimir
          for (Editorial aux : editoriales) {
              if (aux.getNombre().equalsIgnoreCase(nom)){
                 respuesta = true; 
              }
          }
       
        return respuesta;

      }
    
    
    public Editorial mostrarEditorialPorNombre(String nom){
      EntityManager em = getEntityManager();

      Editorial editorial = (Editorial) em.createQuery("SELECT e"
                                             + " FROM Editorial e"
                                             + " WHERE e.nombre LIKE :nombre").
                                             setParameter("nombre", nom).getSingleResult();
    
      return editorial;
     
      }
    
    
     public void mostrarLibrosPorNombreEditorial(String nombreEditorial) throws Exception{

           EntityManager em = getEntityManager();

           
           Collection<Editorial> Editoriales = em.createQuery("SELECT e"
                                           + " FROM Editorial e").getResultList();
        
           Long id = 0L;
           for (Editorial ed : Editoriales) {
               
               if (ed.getNombre().equalsIgnoreCase(nombreEditorial)){
                   id = ed.getId();
                   break;
               }
           }
            if (id == 0L){
                System.out.println("Su editorial no se encuentra en nuestra base de datos");
            }
            
               
             
             Collection <Libro> Libros = em.createQuery("SELECT l"
                                           + " FROM Libro l"
                                           + " WHERE l.editorial.id = : idEditorial").
                                             setParameter("idEditorial", id).getResultList();
               
               
               
               for (Libro lib : Libros) {
                    System.out.println(lib.toString());
                } 
               }
                
             
             
           
        
        
    
       }
    
    

