package pl.klasicki.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
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
    public List<Doctor> getAll() {
        List<Doctor> doctors = doctorService.getAll();
        return doctors;
    }

    @ApiOperation(value = "Get doctor by specialization")
    @GetMapping("/api/doctors/spec/{spec}")
    public List<Doctor> findBySpec(@PathVariable String spec) {
        return doctorService.findBySpec(spec);
    }

    @ApiOperation(value = "Get doctor by id")
    @GetMapping("/api/doctors/id/{id}")
    public Optional<Doctor> findById(@PathVariable Long id) {

        if (id < 0 || id > doctorService.getAll().size()) {
            throw new DoctorNotFoundException("Doctor id not found " + id);
        }

        return doctorService.findById(id);
    }

    @ApiOperation(value = "Create a new doctor")
    @PostMapping("/api/doctors/")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor add(@RequestBody Doctor doctor) {
        return doctorService.add(doctor);
    }

    @ApiOperation(value = "Update a doctor's details")
    @PutMapping("/api/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor) {
        if (id < 0 || id > doctorService.getAll().size()) {
            throw new DoctorNotFoundException("Doctor id not found " + id);
        }
        return doctorService.add(doctor);
    }

    @ApiOperation(value = "Delete a doctor")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/api/doctors/{id}")
    public void delete(@PathVariable Long id)
    {
        if (id < 0 || id > doctorService.getAll().size()) {
            throw new DoctorNotFoundException("Doctor id not found " + id);
        }
        doctorService.delete(id);
    }

}



