package elearning.elearning.controller;

import elearning.elearning.model.Course;
import elearning.elearning.model.TeachingWeek;
import elearning.elearning.model.TeachingWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachingWeek")
@CrossOrigin("http://localhost:3000")
public class TeachingWeekController {

    @Autowired
    private TeachingWeekService teachingWeekService;

    @GetMapping
    public ResponseEntity<List<TeachingWeek>> getAllTeachingWeeks() {
        List<TeachingWeek> teachingWeeks = teachingWeekService.getAllTeachingWeeks();
        return ResponseEntity.ok(teachingWeeks);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<TeachingWeek>> getTeachingWeeksByCourseId(@PathVariable Long courseId) {
        List<TeachingWeek> teachingWeeks = teachingWeekService.getTeachingWeeksByCourseId(courseId);
        return ResponseEntity.ok(teachingWeeks);
    }

    @GetMapping("/{teachingWeekId}")
    public ResponseEntity<TeachingWeek> getTeachingWeekById(@PathVariable Long teachingWeekId) {
        TeachingWeek teachingWeek = teachingWeekService.getTeachingWeekById(teachingWeekId);
        return ResponseEntity.ok(teachingWeek);
    }

    @PostMapping("/course/{courseId}")
    public ResponseEntity<TeachingWeek> addTeachingWeekForCourse(@PathVariable Long courseId, @RequestBody TeachingWeek teachingWeek) {
        // Retrieve the corresponding Course from the database
        Course course = new Course();
        course.setId(courseId);

        // Set the Course for the TeachingWeek
        teachingWeek.setCourse(course);

        // Save the TeachingWeek with the associated Course
        TeachingWeek savedTeachingWeek = teachingWeekService.addTeachingWeek(teachingWeek);
        return ResponseEntity.ok(savedTeachingWeek);
    }

    @DeleteMapping("/{teachingWeekId}")
    public ResponseEntity<Void> deleteTeachingWeek(@PathVariable Long teachingWeekId) {
        teachingWeekService.deleteTeachingWeek(teachingWeekId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{courseId}/{teachingWeekId}")
    public ResponseEntity<TeachingWeek> updateTeachingWeek(@RequestBody TeachingWeek teachingWeek,
            @PathVariable Long courseId,
            @PathVariable Long teachingWeekId) {
        teachingWeek.setId(teachingWeekId);

        // Set the Course for the TeachingWeek
        Course course = new Course();
        course.setId(courseId);
        teachingWeek.setCourse(course);

        TeachingWeek updatedTeachingWeek = teachingWeekService.updateTeachingWeek(teachingWeek);
        return ResponseEntity.ok(updatedTeachingWeek);
    }
}
