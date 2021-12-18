package pl.klasicki.doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorQueryService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(DoctorQueryService.class);

    public DoctorQueryService(DoctorRepository doctorRepository, DoctorMapper mapper) {
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

    List<DoctorDto> findBySpec(String spec) {
        return doctorRepository.findAll()
                .stream()
                .filter(doctor -> doctor.getSpecialization()
                        .equals(spec)).map(d -> mapper.toDto(d)).collect(Collectors.toList());
    }


}
