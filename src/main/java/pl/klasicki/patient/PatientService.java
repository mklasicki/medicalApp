package pl.klasicki.patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class PatientService {

    private final Logger logger = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository patientRepository;

    PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    List<Patient> getAll() {
        logger.info("Getting all of the patients from the list");
        return patientRepository.findAll();
    }

    Optional<Patient> findById(Long id) {
        logger.info("Looking for patient with id {}", id);
        return patientRepository.findById(id);
    }

    Patient add(Patient patient) {
        logger.info("Added new patient to the patients list with name {}", patient.getFirstName());
        return patientRepository.save(patient);
    }

    void delete(Long id) {
        logger.info("Deleting from list patient with id {}", id);
        patientRepository.deleteById(id);
    }

}
