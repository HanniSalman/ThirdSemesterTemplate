package week1.day1.exercise3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import week1.HibernateConfig;

import java.util.List;

public class Main {

    static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    public static void main(String[] args) {
        Student student = new Student("Hanni", "Salman","hannihas98@gmail.com", 25);

        createStudent(student);

        readStudent(1);

        deleteStudent(1);

        readAllStudents();


    }
    public static void createStudent(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.persist(student);
            em.getTransaction().commit();
        }

    }

    public static Student readStudent(int id) {
        try (EntityManager em = emf.createEntityManager()){
            Student foundStudent = em.find(Student.class, id);
            return foundStudent;

        }

    }

    public static Student updateStudent(Student updStd) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Student updatedStudent = em.merge(updStd);
            em.getTransaction().commit();
            return updatedStudent;
        }

    }

    public static void deleteStudent(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Student deleteStudent = readStudent(id);
            em.remove(deleteStudent);
            em.getTransaction().commit();
        }

    }

    public static List<Student> readAllStudents() {
        try (EntityManager em = emf.createEntityManager()) {
            var query = em.createQuery("select s from Student s", Student.class);
            return query.getResultList();
        }

    }
}
