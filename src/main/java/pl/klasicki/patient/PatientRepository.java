package pl.klasicki.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
interface PatientRepository extends JpaRepository<Patient, Long> {

    <S extends Patient> S save(S entity);

    Optional<Patient> findById(Long id);

    void deleteById(Long id);
}
