package Testes;

import modelo.Pais;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestesUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = em.find(Pais.class, 1);
        p.setNome("Brasil");
        p.setIso("BRA");
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
