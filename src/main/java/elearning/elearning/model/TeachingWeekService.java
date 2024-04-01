package elearning.elearning.model;

import java.util.List;

public interface TeachingWeekService {
    List<TeachingWeek> getAllTeachingWeeks();
    TeachingWeek getTeachingWeekById(Long teachingWeekId);
    TeachingWeek addTeachingWeek(TeachingWeek teachingWeek);
    TeachingWeek updateTeachingWeek(TeachingWeek updatedTeachingWeek);
    void deleteTeachingWeek(Long teachingWeekId);
    List<TeachingWeek> getTeachingWeeksByCourseId(Long courseId);

}
