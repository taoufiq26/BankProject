package metier.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Agence;
import metier.Client;

public class ClientDao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unite");
	static EntityManager em = emf.createEntityManager();
	
	public static void begin() {
        em.getTransaction().begin();
    }

    public static void commit() {
        em.getTransaction().commit();
    }

    public static void inserer(Client c) {
        begin();
        em.persist(c);
        commit();

    }

    public static Client findByCode(String code) {
        begin();
        Query query = em.createQuery("select c from Client as c WHERE c.code='" + code + "'");
        List<Client> res = query.getResultList();
        commit();
        return res.get(0);
    }
    
    public static List<Client> findByAgence(String codeAgence) {
        begin();
        Query query = em.createQuery("select c from Client as c join c.agence as a WHERE a.code='" + codeAgence + "'");
        List<Client> res = query.getResultList();
        commit();
        return res;
    }
    
    public static List<Client> findAll() {
        begin();
        Query query = em.createQuery("select c from Client c ");
        List<Client> res = query.getResultList();
        commit();
        return res;
    }
    public static void remove(Client c) {
        begin();
        em.remove(c);
        commit();
    }

}
