package pl.klasicki.visits;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(tags = "Visit")
@RestController
@RequestMapping("api/visits")
class VisitRestController {

    //TODO use ResponseEntity
    //TODO create and use DTO object  as a response from database instead of domain object

    private final VisitService visitService;
    private final Logger log = LoggerFactory.getLogger(Visit.class);

    VisitRestController(VisitService visitService) {
        this.visitService = visitService;
    }

    @ApiOperation(value = "Get list of all visits")
    @GetMapping
    Iterable<Visit> getAll() {
        log.info("Getting all visits form database");
        return visitService.getAll();
    }

    @ApiOperation(value = "Get visit by id")
    @GetMapping("{id}")
    Optional<Visit> findById(@PathVariable Long id) {
        log.info("Getting one visit by id {}", id);
        return visitService.findObeById(id);
    }

    @ApiOperation(value = "Create a new visit")
    @PostMapping
    Visit addVisit(@RequestBody Visit visit) {
        log.info("added new visit to the list with id {}", visit.getId());
        return visitService.addVisit(visit);

    }

    @ApiOperation(value = "Update visit details")
    @PutMapping("{id}")
    Visit updateVisit(@PathVariable Long id, @RequestBody Visit visit) {
       log.info("Updated visit with id {}", id);
       return visitService.updateVisit(id,visit);
    }

    @ApiOperation(value = "Delete visit")
    @DeleteMapping("{id}")
    void deleteVisit(@PathVariable long id) {
        log.info("Deleted visit with id {}", id);
        visitService.deleteVisit(id);
    }

    }


