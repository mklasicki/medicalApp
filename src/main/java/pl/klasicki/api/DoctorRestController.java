package pl.klasicki.api;


import org.springframework.web.bind.annotation.*;
import pl.klasicki.domain.Doctor;
import pl.klasicki.exceptions.DataNotFoundException;
import pl.klasicki.exceptions.DoctorNotFoundException;
import pl.klasicki.services.DoctorService;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorRestController {

    private DoctorService doctorService;

    public DoctorRestController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/api/doctors/")
    public List<Doctor> getAll() {
        List<Doctor> doctors = doctorService.getAll();

        if (doctors.isEmpty()) {
            throw new DataNotFoundException("There is no data in database.");
        }

        return doctors;
    }

    @GetMapping("/api/doctors/{id}")
    public Optional<Doctor> findById(@PathVariable Long id) {

        if (id < 0 || id > doctorService.getAll().size()) {
            throw new DoctorNotFoundException("Doctor id not found " + id);
        }

        return doctorService.findById(id);
    }

    @PostMapping("/api/doctors/")
    public Doctor add(@RequestBody Doctor doctor) {
        return doctorService.add(doctor);
    }

    @PutMapping("/api/doctors/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.add(doctor);
    }

    @DeleteMapping("/api/doctors/{id}")
    public void delete(@PathVariable Long id) {
        doctorService.delete(id);
    }

}



