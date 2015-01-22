package metier.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.internal.libraries.asm.CodeAdapter;

import metier.Client;
import metier.Compte;

public class CompteDao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unite");
	static EntityManager em = emf.createEntityManager();
	
	public static void begin() {
        em.getTransaction().begin();
    }

    public static void commit() {
        em.getTransaction().commit();
    }

    public static void inserer(Compte cp) {
        begin();
        em.persist(cp);
        commit();

    }

    public static Compte findByCode(String code) {
        begin();
        Query query = em.createQuery("select cp from Compte as cp WHERE cp.code='" + code + "'");
        List<Compte> res = query.getResultList();
        commit();
        return res.get(0);
    }
    
    public static List<Compte> findByClient(String codeClient) {
        begin();
        Query query = em.createQuery("select cp from Compte as cp join cp.client as c WHERE c.code='" + codeClient + "'");
        List<Compte> res = query.getResultList();
        commit();
        return res;
    }
    
    public static List<Compte> findAll() {
        begin();
        Query query = em.createQuery("select cp from Compte cp ");
        List<Compte> res = query.getResultList();
        commit();
        return res;
    }
    public static void remove(Compte cp) {
        begin();
        em.remove(cp);
        commit();
    }

}
