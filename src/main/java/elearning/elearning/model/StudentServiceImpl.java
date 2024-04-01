package elearning.elearning.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesByStudentSp(String studentSp) {
        return courseRepository.findBySp(studentSp);
    }
    public String findSpById(Long studentId) {
        Student student = studentRepository.findSpById(studentId);
        return (student != null) ? student.getSp() : null;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    @Override
    public List<Student> findByfirstNameOrlastName(String searchwith) {
        return studentRepository.findByFirstNameOrLastName(searchwith,searchwith);
    }
}