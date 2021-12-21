package pl.klasicki.doctor;

import org.springframework.data.annotation.PersistenceConstructor;
import pl.klasicki.commons.Person;
import pl.klasicki.visits.Visit;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "doctor")
public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialization;
    @OneToMany(mappedBy = "doctor")
    private Set<Visit> visitList;

    @PersistenceConstructor
    public Doctor() {

    }

    Doctor(String firstName, String lastName, Long id, String specialization) {
        super(firstName, lastName);
        this.id = id;
        this.specialization = specialization;
    }

    Long getId() {
        return id;
    }

    String getSpecialization() {
        return specialization;
    }

    void setId(Long id) {
        this.id = id;
    }

    void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
