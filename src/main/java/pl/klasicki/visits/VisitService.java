package pl.klasicki.visits;

import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
class VisitService {

    private final VisitRepository visitRepository;

    VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    Iterable<Visit> getAll() {
        return visitRepository.findAll();
    }

    Optional<Visit> findObeById(Long id) {
        return visitRepository.findById(id);
    }

    Visit addVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    Visit updateVisit(Long id, Visit visit) {
        return visitRepository.save(visit);
    }

    void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }

}
