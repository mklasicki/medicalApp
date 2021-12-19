package pl.klasicki.doctor;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    private final DoctorQueryService doctorQueryService;

    DoctorRestController(DoctorService doctorService, DoctorQueryService doctorQueryService) {
        this.doctorService = doctorService;
        this.doctorQueryService = doctorQueryService;
    }

    @ApiOperation(value = "Get list of all doctors")
    @GetMapping
    ResponseEntity<List<DoctorDto>> getAll() {
        return ResponseEntity.ok(doctorQueryService.getAll());
    }

    @ApiOperation(value = "Get doctor by specialization")
    @GetMapping("spec/{spec}")
    ResponseEntity<List<DoctorDto>> findBySpec(@PathVariable String spec) {
        return ResponseEntity.ok(doctorQueryService.findBySpec(spec));

    }

    @ApiOperation(value = "Get doctor by id")
    @GetMapping("id/{id}")
    ResponseEntity<Optional<DoctorDto>> findById(@PathVariable Long id) {
        responseCheck(id);
        return ResponseEntity.ok(doctorQueryService.findById(id));
    }

    @ApiOperation(value = "Create a new doctor")
    @PostMapping()
    ResponseEntity<DoctorDto> add(@RequestBody DoctorDto doctor) {
        return ResponseEntity.ok(doctor);
    }

    @ApiOperation(value = "Update a doctor's details")
    @PutMapping("{id}")
    ResponseEntity<DoctorDto> update(@PathVariable Long id, @RequestBody DoctorDto doctor) {
        responseCheck(id);
        return ResponseEntity.ok(doctor);
    }

    @ApiOperation(value = "Delete a doctor")
    @DeleteMapping("{id}")
    ResponseEntity<DoctorDto> delete(@PathVariable Long id) {
        responseCheck(id);
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private void responseCheck(Long id) {
        if (id < 0 || id > doctorQueryService.getAll().size()) {
            throw new DoctorNotFoundException("Doctor id not found " + id);
        }
    }

}



