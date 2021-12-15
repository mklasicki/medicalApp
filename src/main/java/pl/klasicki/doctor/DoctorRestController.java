package pl.klasicki.doctor;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.klasicki.commons.DoctorNotFoundException;

import java.util.List;
import java.util.Optional;

@Api(tags = "Doctor")
@RestController
@RequestMapping("api/doctors")
class DoctorRestController {

    private final DoctorService doctorService;

    DoctorRestController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    //TODO: - use DTO object to transfer data from database to response

    @ApiOperation(value = "Get list of all doctors")
    @GetMapping
    ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    @ApiOperation(value = "Get doctor by specialization")
    @GetMapping("spec/{spec}")
    ResponseEntity<List<Doctor>> findBySpec(@PathVariable String spec) {
        return ResponseEntity.ok(doctorService.findBySpec(spec));
    }

    @ApiOperation(value = "Get doctor by id")
    @GetMapping("id/{id}")
    ResponseEntity<Optional<Doctor>> findById(@PathVariable Long id) {
        responseCheck(id);
        return new ResponseEntity<>(doctorService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new doctor")
    @PostMapping()
    ResponseEntity<Doctor> add(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.add(doctor), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a doctor's details")
    @PutMapping("{id}")
    ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        responseCheck(id);
        return new ResponseEntity<>(doctorService.add(doctor), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a doctor")
    @DeleteMapping("{id}")
    ResponseEntity<Doctor> delete(@PathVariable Long id) {
        responseCheck(id);
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private void responseCheck(Long id) {
        if (id < 0 || id > doctorService.getAll().size()) {
            throw new DoctorNotFoundException("Doctor id not found " + id);
        }
    }

}


