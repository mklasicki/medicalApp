package pl.klasicki.patient;

import org.springframework.data.annotation.PersistenceConstructor;
import pl.klasicki.commons.Person;
import pl.klasicki.visits.Visit;

import javax.persistence.*;
import java.util.List;

@Entity
class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumber;
    private String email;
    @OneToMany(mappedBy = "patient")
    private List<Visit> visitList;

    @PersistenceConstructor
    protected Patient() {
    }


    Long getIdNumber() {
        return idNumber;
    }

    String getEmail() {
        return email;
    }

}
