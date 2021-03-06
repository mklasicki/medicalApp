package pl.klasicki.services;

import org.springframework.stereotype.Service;
import pl.klasicki.dao.VisitRepository;
import pl.klasicki.domain.Visit;

import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Iterable<Visit> getAll() {
        return visitRepository.findAll();
    }

    public Optional<Visit> findObeById(Long id) {
        return visitRepository.findById(id);
    }

    public Visit addVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    public Visit updateVisit(Long id, Visit visit) {
        return visitRepository.save(visit);
    }

    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }

}
