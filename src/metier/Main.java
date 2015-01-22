package metier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.dao.AgenceDao;
import metier.dao.BanqueDao;
import metier.dao.ClientDao;
import metier.dao.CompteDao;


public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unite");
        EntityManager em = emf.createEntityManager();
        
//        Banque b=new Banque();
//        b.setNom("abc");
//        b.setCode("abc");
//        Agence a=new Agence();
//        a.setBanque(b);
//        Client c=new Client();
//        c.setNom("taoufiq");
//        c.setAgence(a); 
//        Compte cp=new Compte();
//        cp.setClient(c);

        
                
        em.getTransaction().begin();
//        BanqueDao.inserer(b);
//        AgenceDao.inserer(a);
//        ClientDao.inserer(c);
//        CompteDao.inserer(cp);
        Banque b=(Banque) BanqueDao.findByCode("abc");
        System.out.println(b.getNom());
        for(Agence a:b.getAgences()){
        	System.out.println(a.getNom());
        }
        em.getTransaction().commit();
        
        
        }

    }
