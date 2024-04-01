package elearning.elearning.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    List<Administrator> findByFirstNameOrLastName(String fname,String lname);

}
