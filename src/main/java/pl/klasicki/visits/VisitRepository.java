package pl.klasicki.visits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VisitRepository extends JpaRepository<Visit, Long> {
}
