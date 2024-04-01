package elearning.elearning.model;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long studentId);
    List<Course> getCoursesByStudentSp(String studentSp);
    String findSpById(Long studentId);
    List<Student> findByfirstNameOrlastName(String searchwith);

}
