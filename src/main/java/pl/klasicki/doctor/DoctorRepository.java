package pl.klasicki.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DoctorRepository extends JpaRepository<Doctor, Long> {

}