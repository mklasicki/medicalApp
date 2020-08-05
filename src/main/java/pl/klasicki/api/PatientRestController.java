package pl.klasicki.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pl.klasicki.domain.Patient;
import pl.klasicki.exceptions.PatientNotFoundException;
import pl.klasicki.services.PatientService;

import java.util.List;
import java.util.Optional;

@Api(tags = "Patient")
@RestController
public class PatientRestController {

    private PatientService patientService;

    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation(value = "List of all patients")
    @GetMapping("/api/patients/")
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @ApiOperation(value = "Search patient by id")
    @GetMapping("/api/patients/{id}")
    public Optional<Patient> findById(@PathVariable Long id) {

        if (id < 0 || id > patientService.getAll().size()) {
            throw new PatientNotFoundException("Patient with id " + id + " not found.");
        }

        return patientService.findById(id);
    }

    @ApiOperation(value = "Add new patient to the database")
    @PostMapping("/api/patients/")
    public Patient add(@RequestBody Patient patient) {
        return patientService.add(patient);
    }

    @ApiOperation(value = "Update patient's details")
    @PutMapping("/api/patients/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.add(patient);
    }

    @ApiOperation("Delete patient by id")
    @DeleteMapping("/api/patients/{id}")
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }

}
