package elearning.elearning.model;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long teacherId);
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher updatedTeacher);
    void deleteTeacher(Long teacherId);
    List<Teacher> findByFirstNameOrLastName(String searchwith);

}
