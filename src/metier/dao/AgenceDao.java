package metier.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Agence;
import metier.Banque;

public class AgenceDao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unite");
	static EntityManager em = emf.createEntityManager();
	
	public static void begin() {
        em.getTransaction().begin();
    }

    public static void commit() {
        em.getTransaction().commit();
    }

    public static void inserer(Agence a) {
        begin();
        em.persist(a);
        commit();

    }

    public static Agence findByCode(String code) {
        begin();
        Query query = em.createQuery("select a from Agence as a WHERE a.code='" + code + "'");
        List<Agence> res = query.getResultList();
        commit();
        return res.get(0);
    }
    
    public static List<Agence> findByBanque(String codeBanque) {
        begin();
        Query query = em.createQuery("select a from Agence as a join a.banque as b WHERE b.code='" + codeBanque + "'");
        List<Agence> res = query.getResultList();
        commit();
        return res;
    }
    
    public static List<Agence> findAll() {
        begin();
        Query query = em.createQuery("select a from Agence a ");
        List<Agence> res = query.getResultList();
        commit();
        return res;
    }
    public static void remove(Agence a) {
        begin();
        em.remove(a);
        commit();
    }

}
