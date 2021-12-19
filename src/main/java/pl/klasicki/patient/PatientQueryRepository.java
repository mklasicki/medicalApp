package pl.klasicki.patient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientQueryRepository extends JpaRepository<Patient, Long> {


   List<PatientDto> findAllBy();


}
