package pl.klasicki.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.klasicki.patient.dto.PatientDto;

import java.util.List;
import java.util.Optional;


public interface PatientQueryRepository extends JpaRepository<Patient, Long> {

   List<PatientDto> findAllBy();

   Optional<PatientDto> findPatientByIdNumber(Long id);

   long count();

}
