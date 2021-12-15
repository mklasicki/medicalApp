package pl.klasicki.patient;

import pl.klasicki.commons.Person;
import pl.klasicki.visits.Visit;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumber;
    private String email;
    @OneToMany(mappedBy = "patient")
    private List<Visit> visitList;

    public Patient() {
    }

    public Patient(String firstName, String lastName, Long idNumber, String email) {
        super(firstName, lastName);
        this.idNumber = idNumber;
        this.email = email;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idNumber=" + idNumber +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }
}
