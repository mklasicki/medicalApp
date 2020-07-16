package pl.klasicki.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.klasicki.domain.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
