package pl.klasicki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klasicki.domain.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}
