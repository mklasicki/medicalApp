package pl.klasicki.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ApiOperation(value = "Get list of all the patients")
    @GetMapping("/api/patients/")
    public ResponseEntity<List<Patient>> getAll() {
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get patient by id")
    @GetMapping("/api/patients/{id}")
    public ResponseEntity<Optional<Patient>> findById(@PathVariable Long id) {
        requestCheck(id);
        return new ResponseEntity<>(patientService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new patient")
    @PostMapping("/api/patients/")
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.add(patient),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update patient's details")
    @PutMapping("/api/patients/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        requestCheck(id);
        return new ResponseEntity<>(patientService.add(patient), HttpStatus.OK);
    }

    @ApiOperation("Delete patient")
    @DeleteMapping("/api/patients/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id) {
        requestCheck(id);
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void requestCheck(Long id) {
        if (id < 0 || id > patientService.getAll().size()) {
            throw new PatientNotFoundException("Patient with id " + id + " not found.");
        }
    }

}

