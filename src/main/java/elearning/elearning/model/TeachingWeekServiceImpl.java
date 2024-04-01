package elearning.elearning.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeachingWeekServiceImpl implements TeachingWeekService {
     @Autowired
    private TeachingWeekRepository teachingWeekRepository;

    @Override
    public List<TeachingWeek> getAllTeachingWeeks() {
        return teachingWeekRepository.findAll();
    }

    @Override
    public TeachingWeek getTeachingWeekById(Long teachingWeekId) {
        return teachingWeekRepository.findById(teachingWeekId).orElse(null);
    }

    @Override
    public TeachingWeek addTeachingWeek(TeachingWeek teachingWeek) {
        return teachingWeekRepository.save(teachingWeek);
    }

    @Override
    public TeachingWeek updateTeachingWeek(TeachingWeek TeachingWeek) {
        return teachingWeekRepository.save(TeachingWeek);
    }

    @Override
    public void deleteTeachingWeek(Long teachingWeekId) {
        teachingWeekRepository.deleteById(teachingWeekId);
    }

    @Override
    public List<TeachingWeek> getTeachingWeeksByCourseId(Long courseId) {  
        return teachingWeekRepository.findByCourseId(courseId);
    }


}
