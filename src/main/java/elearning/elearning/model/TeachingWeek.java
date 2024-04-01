package elearning.elearning.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TeachingWeek")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor 
public class TeachingWeek {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "week_number")
    private int weekNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "material",length = 500)
    private List<String> materials; // List of links to external resources

    @Column(name = "material_names")
    private List<String> materialNames;

    @ManyToOne
    private Course course;
}
