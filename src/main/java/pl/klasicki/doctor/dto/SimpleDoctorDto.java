package pl.klasicki.doctor.dto;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;

@Entity
@Table(name= "doctor")
public class SimpleDoctorDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialization;

    @PersistenceConstructor
    public SimpleDoctorDto() {
    }

    public SimpleDoctorDto(Long id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }
}
