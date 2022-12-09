
 
package DAO;

import entidad.RegistroDato;
import entidad.Sensor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SensorDAO {
    private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SensorAPP_JPAPU");
    public void crear (Sensor s){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(s);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    public Sensor leer (Sensor s){
        EntityManager em = emf.createEntityManager(); 
        Sensor sensor = null; 
        Query q = em.createQuery("SELECT s FROM Sensor s "+
                                 "WHERE s.id =:id")
                                 .setParameter("id",s.getId());
        try {
            sensor = (Sensor) q.getSingleResult();
        }catch(NonUniqueResultException e){
            sensor = (Sensor) q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
            return sensor;
        }
    }
    
}
