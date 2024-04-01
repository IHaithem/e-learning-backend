package elearning.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import elearning.elearning.model.Course;
import elearning.elearning.model.CourseService;
import elearning.elearning.model.StudentService;
import elearning.elearning.model.Teacher;
import elearning.elearning.model.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin("http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Course>> getCoursesByTeacherId(@PathVariable Long teacherId) {
        List<Course> courses = courseService.getCoursesByTeacherId(teacherId);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Course>> getCoursesByStudentSp(@PathVariable Long studentId) {
        List<Course> courses = studentService.getCoursesByStudentSp(studentService.findSpById(studentId));
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/search/{courseName}")
    public ResponseEntity<List<Course>> getCourseByName(@PathVariable String courseName) {
        List<Course> courses = courseService.findBycourseName(courseName);
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/teacher/{teacherId}")
    public ResponseEntity<Course> addCourse(@PathVariable Long teacherId, @RequestBody Course course) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        course.setTeacher(teacher);
        Course savedCourse = courseService.addCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long courseId) {
        course.setId(courseId);
        Course updatedCourse = courseService.updateCourse(course);
        return ResponseEntity.ok(updatedCourse);
    }
}
