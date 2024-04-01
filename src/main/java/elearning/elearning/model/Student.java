package elearning.elearning.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Student")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor 
public class Student extends Account {
       @Column(name = "sp")
    private String sp;
     @ManyToMany
     private List<Course> enrolledCourses;

    

}
