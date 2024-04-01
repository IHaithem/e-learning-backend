package elearning.elearning.controller;

import elearning.elearning.model.Teacher;
import elearning.elearning.model.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("http://localhost:3000")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/search/{searchwith}")
    public ResponseEntity<List<Teacher>> getCourseByName(@PathVariable String searchwith) {
        List<Teacher> teachers = teacherService.findByFirstNameOrLastName(searchwith);
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        String w = teacher.getPassword();
        teacher.setPassword(passwordEncoder.encode(w));
        Teacher addedTeacher = teacherService.addTeacher(teacher);
        return ResponseEntity.ok(addedTeacher);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher updatedTeacher, @PathVariable Long teacherId) {
        Teacher existingTeacher = teacherService.getTeacherById(teacherId);
    
        // Ensure that the courses information stays the same
        updatedTeacher.setCourses(existingTeacher.getCourses());
    
        // Set the ID to the existing ID
        updatedTeacher.setId(teacherId);
    
        Teacher updatedTeacherResult = teacherService.updateTeacher(updatedTeacher);
    
        return ResponseEntity.ok(updatedTeacherResult);
    }
}
