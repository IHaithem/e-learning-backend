package elearning.elearning.model;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long courseId);
    Course addCourse(Course course);
    Course updateCourse(Course updatedCourse);
    void deleteCourse(Long courseId);
     List<Course> getCoursesByTeacherId(Long teacherId);
     List<Course> findBycourseName(String courseName);
}
