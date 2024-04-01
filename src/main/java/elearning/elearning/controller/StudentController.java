package elearning.elearning.controller;

import elearning.elearning.model.Student;
import elearning.elearning.model.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/search/{searchwith}")
    public ResponseEntity<List<Student>> getStudentByName(@PathVariable String searchwith) {
        List<Student> students = studentService.findByfirstNameOrlastName(searchwith);
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        String w = student.getPassword();
        student.setPassword(passwordEncoder.encode(w));
        Student addedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(addedStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long studentId) {
        student.setId(studentId);
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }
}
