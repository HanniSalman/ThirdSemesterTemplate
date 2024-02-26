package week4.day1.exercise0;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import week3.HibernateConfig;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        try (EntityManager em = emf.createEntityManager()) {

            Person p1 = new Person("Hanzi");
            PersonDetail pd1 = new PersonDetail("Thyrasvej 48A", 4684, "Toksværd", 25);
            p1.addPersonDetail(pd1);
            Fee f1 = new Fee(125, LocalDate.of(2024,02,19));
            Fee f2 = new Fee(150, LocalDate.of(2024, 01,25));
            p1.addFee(f1);
            p1.addFee(f2);

            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();
        }
    }
}
