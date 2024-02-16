package week3.day2.exercise6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import week3.HibernateConfig;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        EntityManager em = emf.createEntityManager();

        StudentDAO studentDAO = new JPAStudentDAO(em);

        Student1 newStudent1 = new Student1("Hanni", "Salman", "hannihas98@gmail.com", 25);
        newStudent1.onCreate();
        newStudent1.onUpdate();
        System.out.println(newStudent1.getCreatedAt());
        System.out.println(newStudent1.getUpdatedAt());

        studentDAO.createStudent(newStudent1);

        Student1 retrievedStudent1 = studentDAO.getStudentById(newStudent1.getId());
        System.out.println("Retrieved Student: " + retrievedStudent1);

        retrievedStudent1.setAge(26);
        studentDAO.updateStudent(retrievedStudent1);

        System.out.println("All Students:");
        studentDAO.getAllStudents().forEach(System.out::println);

        studentDAO.deleteStudent(retrievedStudent1.getId());

        em.close();
        emf.close();
    }
}
