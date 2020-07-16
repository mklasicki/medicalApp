package pl.klasicki.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.klasicki.domain.Visit;
import pl.klasicki.services.VisitService;

import java.util.Optional;

@RestController
public class VisitRestController {

    private final VisitService visitService;
    private final Logger log = LoggerFactory.getLogger(Visit.class);

    public VisitRestController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/api/visits/")
    public Iterable<Visit> getAll() {
        log.info("Getting all visits form database");
        return visitService.getAll();
    }

    @GetMapping("/api/visits/{id}")
    public Optional<Visit> findById(@PathVariable Long id) {
        log.info("Getting one visit by id {}", id);
        return visitService.findObeById(id);
    }

    @PostMapping("/api/visits")
    public Visit addVisit(@RequestBody Visit visit) {
        log.info("added new visit to the list with id {}", visit.getId());
        return visitService.addVisit(visit);
    }

    @PutMapping("/api/visits/{id}")
    public Visit updateVisit(@PathVariable Long id, @RequestBody Visit visit) {
       log.info("Updated visit with id {}", id);
       return visitService.updateVisit(id,visit);
    }

    @DeleteMapping("api/visits/{id}")
    public void deleteVisit(@PathVariable long id) {
        log.info("Deleted visit with id {}", id);
        visitService.deleteVisit(id);
    }

    }


