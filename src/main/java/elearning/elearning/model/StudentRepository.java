package elearning.elearning.model;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findSpById(Long id);
    List<Student> findByFirstNameOrLastName(String fname,String lname);

}
