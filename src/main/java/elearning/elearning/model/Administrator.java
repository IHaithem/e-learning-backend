package elearning.elearning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Administrator")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor 
public class Administrator extends Account {
    @Column(name = "admin_level")
    private String adminLevel;

}
