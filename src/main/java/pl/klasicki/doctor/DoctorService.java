package pl.klasicki.doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper mapper;
    private Logger logger = LoggerFactory.getLogger(DoctorService.class);

    DoctorService(DoctorRepository doctorRepository, DoctorMapper mapper)
    {
        this.doctorRepository = doctorRepository;
        this.mapper = mapper;
    }

    Doctor add(DoctorDto doctor) {
        logger.info("Added new doctor to the doctor list with name {}", doctor.getFirstName());
        return doctorRepository.save(mapper.toDomain(doctor));
    }

    void delete(Long id) {
        logger.info("Deleting from list doctor with id {}", id);
        doctorRepository.deleteById(id);
    }

}
