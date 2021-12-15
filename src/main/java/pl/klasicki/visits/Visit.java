package pl.klasicki.visits;

import pl.klasicki.doctor.Doctor;
import pl.klasicki.commons.Prescription;
import pl.klasicki.patient.Patient;

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
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "idNumber")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id", referencedColumnName = "id")
    private Prescription prescription;

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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
