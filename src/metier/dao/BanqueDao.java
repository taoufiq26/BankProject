package metier.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Banque;

public class BanqueDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unite");
	static EntityManager em = emf.createEntityManager();
	
	public static void begin() {
        em.getTransaction().begin();
    }

    public static void commit() {
        em.getTransaction().commit();
    }

    public static void inserer(Banque b) {
        begin();
        em.persist(b);
        commit();

    }

    public static Banque findByCode(String code) {
        begin();
        Query query = em.createQuery("select b from Banque as b WHERE b.code='" + code + "'");
        List<Banque> res = query.getResultList();
        commit();
        return res.get(0);
    }
    
    public static List<Banque> findAll() {
        begin();
        Query query = em.createQuery("select b from Banque b ");
        List<Banque> res = query.getResultList();
        commit();
        return res;
    }
    public static void remove(Banque b) {
        begin();
        em.remove(b);
        commit();
    }
    

}
