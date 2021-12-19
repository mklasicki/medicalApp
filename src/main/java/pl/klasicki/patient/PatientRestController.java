package pl.klasicki.patient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = "Patient")
@RestController
@RequestMapping("api/patients")
class PatientRestController {

    private final PatientService patientService;
    private final PatientQueryRepository patientQueryRepository;

    PatientRestController(PatientService patientService, PatientQueryRepository patientQueryRepository) {
        this.patientService = patientService;
        this.patientQueryRepository = patientQueryRepository;
    }

    @ApiOperation(value = "Get list of all the patients")
    @GetMapping
    List<PatientDto> getAll() {
        return patientQueryRepository.findAllBy();
    }

    @ApiOperation(value = "Get patient by id")
    @GetMapping("{id}")
    Optional<Patient> findById(@PathVariable Long id) {

        if (id < 0 || id > patientService.getAll().size()) {
            throw new PatientNotFoundException("Patient with id " + id + " not found.");
        }

        return patientService.findById(id);
    }

    @ApiOperation(value = "Create a new patient")
    @PostMapping
    Patient add(@RequestBody Patient patient) {
        return patientService.add(patient);
    }

    @ApiOperation(value = "Update patient's details")
    @PutMapping("{id}")
    Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.add(patient);
    }

    @ApiOperation("Delete patient")
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        patientService.delete(id);
    }

}
