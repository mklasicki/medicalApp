package pl.klasicki.doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    List<DoctorDto> getAll() {
        logger.info("Getting all of the doctors from the list");
        return doctorRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    Optional<DoctorDto> findById(Long id) {

        logger.info("Looking for doctor with id {}", id);
        return Optional.of(mapper.toDto(doctorRepository.findById(id).get()));
    }

    Doctor add(DoctorDto doctor) {
        logger.info("Added new doctor to the doctor list with name {}", doctor.getFirstName());
        return doctorRepository.save(mapper.toDomain(doctor));
    }

    void delete(Long id) {
        logger.info("Deleting from list doctor with id {}", id);
        doctorRepository.deleteById(id);
    }

    List<DoctorDto> findBySpec(String spec) {
        return doctorRepository.findAll()
                .stream()
                .filter(doctor -> doctor.getSpecialization()
                .equals(spec)).map(d -> mapper.toDto(d)).collect(Collectors.toList());
    }

}
