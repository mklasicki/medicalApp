package pl.klasicki.visits;

import org.springframework.data.annotation.PersistenceConstructor;
import pl.klasicki.Prescription.Prescription;
import pl.klasicki.doctor.dto.SimpleDoctorDto;
import pl.klasicki.patient.dto.SimplePatientDto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private SimpleDoctorDto doctor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "idNumber")
    private SimplePatientDto patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id", referencedColumnName = "id")
    private Prescription prescription;

    @PersistenceConstructor
    public Visit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SimpleDoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(SimpleDoctorDto doctor) {
        this.doctor = doctor;
    }

    public SimplePatientDto getPatient() {
        return patient;
    }

    public void setPatient(SimplePatientDto patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
