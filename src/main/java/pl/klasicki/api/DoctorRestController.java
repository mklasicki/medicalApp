package pl.klasicki.api;

import org.springframework.web.bind.annotation.*;
import pl.klasicki.domain.Doctor;
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
        return doctorService.getAll();
    }

    @GetMapping("/api/doctors/{id}")
    public Optional<Doctor> findById(@PathVariable Long id) {
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
