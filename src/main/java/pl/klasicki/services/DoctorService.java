package pl.klasicki.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.klasicki.dao.DoctorRepository;
import pl.klasicki.domain.Doctor;
import pl.klasicki.exceptions.DoctorNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DoctorService {

    private DoctorRepository doctorRepository;
    private Logger logger = LoggerFactory.getLogger(DoctorService.class);

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAll() {
        logger.info("Getting all of the doctors from the list");
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(Long id) {

        Optional<Doctor> result = doctorRepository.findById(id);

        if(result == null) {
            logger.info("Doctor with id {} not found", id);
            throw new DoctorNotFoundException("Doctor with id {} not found");
        }

        logger.info("Looking for doctor with id {}", id);
        return result;
    }

    public Doctor add(Doctor doctor) {
        logger.info("Added new doctor to the doctor list with name {}", doctor.getFirstName());
        return doctorRepository.save(doctor);
    }

    public void delete(Long id) {
        logger.info("Deleting from list doctor with id {}", id);
        doctorRepository.deleteById(id);
    }

    public List<Doctor> findBySpec(String spec) {
        return doctorRepository.findAll().stream().filter(doctor -> doctor.getSpecialization()
                .equals(spec)).collect(Collectors.toList());
    }

}
