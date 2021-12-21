package pl.klasicki.patient.dto;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimplePatientDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumber;
    private String email;

    @PersistenceConstructor
    public SimplePatientDto() {
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public String getEmail() {
        return email;
    }
}
