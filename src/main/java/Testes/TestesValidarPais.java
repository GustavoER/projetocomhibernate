package Testes;

import modelo.Pais;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class TestesValidarPais {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = new Pais();
        em.getTransaction().begin();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validator.validate(p);
        if(erros.size() > 0){
            erros.forEach(s -> System.out.println(s.getMessage()));
        }else {
            em.persist(p);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
    }

}
