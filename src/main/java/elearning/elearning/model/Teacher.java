package elearning.elearning.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Teacher")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Teacher extends Account {
    @OneToMany
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @JsonIgnoreProperties("teacher")
    private List<Course> courses;
}
