package elearning.elearning.model;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingWeekRepository extends JpaRepository <TeachingWeek, Long> {
    List<TeachingWeek> findByCourseId(Long courseId);
}
