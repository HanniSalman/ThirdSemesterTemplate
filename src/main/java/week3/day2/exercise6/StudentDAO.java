package week3.day2.exercise6;

import java.util.List;
public interface StudentDAO {
    void createStudent(Student1 student1);
    Student1 getStudentById(int id);
    List<Student1> getAllStudents();
    void updateStudent(Student1 student1);
    void deleteStudent(int id);
}

