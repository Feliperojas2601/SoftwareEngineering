
package DAO;

import entidad.RegistroDato;
import entidad.Sensor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RegistroDatoDAO {
    private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SensorAPP_JPAPU");
    public void crear (RegistroDato registro){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(registro);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    public List<RegistroDato> leer5 (){
        EntityManager em = emf.createEntityManager(); 
        List <RegistroDato> registroDato = null; 
        Query q = em.createQuery("SELECT r FROM RegistroDato r ORDER BY r.id DESC");
        q.setMaxResults(5);
        try {
            registroDato = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
            return registroDato;
        }
    }

}
