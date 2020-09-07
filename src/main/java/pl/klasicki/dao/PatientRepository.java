package pl.klasicki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klasicki.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


}
