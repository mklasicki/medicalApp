package pl.klasicki.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.klasicki.domain.Doctor;
import pl.klasicki.exceptions.DoctorNotFoundException;
import pl.klasicki.services.DoctorService;

import java.util.List;
import java.util.Optional;

@Api(tags = "Doctor")
@RestController
public class DoctorRestController {

    private DoctorService doctorService;

    public DoctorRestController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @ApiOperation(value = "Get list of all doctors")
    @GetMapping("/api/doctors/")
    public ResponseEntity<List<Doctor>> getAll() {
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK) ;
    }

    @ApiOperation(value = "Get doctor by specialization")
    @GetMapping("/api/doctors/spec/{spec}")
    public ResponseEntity<List<Doctor>> findBySpec(@PathVariable String spec) {
        return new ResponseEntity<>(doctorService.findBySpec(spec), HttpStatus.OK);
    }

    @ApiOperation(value = "Get doctor by id")
    @GetMapping("/api/doctors/id/{id}")
    public ResponseEntity<Optional<Doctor>> findById(@PathVariable Long id) {
        responseCheck(id);
        return new ResponseEntity<>(doctorService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new doctor")
    @PostMapping("/api/doctors/")
    public ResponseEntity<Doctor> add(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.add(doctor), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a doctor's details")
    @PutMapping("/api/doctors/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        responseCheck(id);
        return new ResponseEntity<>(doctorService.add(doctor), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a doctor")
    @DeleteMapping("/api/doctors/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        responseCheck(id);
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void responseCheck(Long id) {
        if (id < 0 || id > doctorService.getAll().size()) {
            throw new DoctorNotFoundException("Doctor id not found " + id);
        }
    }

}



