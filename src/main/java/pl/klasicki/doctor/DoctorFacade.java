package pl.klasicki.doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.klasicki.doctor.dto.DoctorDto;


@Service
public class DoctorFacade {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(DoctorFacade.class);

    public DoctorFacade(DoctorRepository doctorRepository, DoctorMapper mapper)
    {
        this.doctorRepository = doctorRepository;
        this.mapper = mapper;
    }

    public Doctor add(DoctorDto doctor) {
        logger.info("Added new doctor to the doctor list with name {}", doctor.getFirstName());
        return doctorRepository.save(mapper.toDomain(doctor));
    }

    public void delete(Long id) {
        logger.info("Deleting from list doctor with id {}", id);
        doctorRepository.deleteById(id);
    }

}
