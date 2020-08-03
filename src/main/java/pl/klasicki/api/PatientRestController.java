package pl.klasicki.api;

import org.springframework.web.bind.annotation.*;
import pl.klasicki.domain.Patient;
import pl.klasicki.exceptions.PatientNotFoundException;
import pl.klasicki.services.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientRestController {

    private PatientService patientService;

    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/api/patients/")
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/api/patients/{id}")
    public Optional<Patient> findById(@PathVariable Long id) {

        if (id < 0 || id > patientService.getAll().size()) {
            throw new PatientNotFoundException("Patient with id " + id + " not found.");
        }

        return patientService.findById(id);
    }

    @PostMapping("/api/patients/")
    public Patient add(@RequestBody Patient patient) {
        return patientService.add(patient);
    }

    @PutMapping("/api/patients/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.add(patient);
    }

    @DeleteMapping("/api/patients/{id}")
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }

}
