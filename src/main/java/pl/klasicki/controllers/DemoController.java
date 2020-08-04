package pl.klasicki.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.klasicki.services.DemoControllerService;


@Controller
@RequestMapping("/demo")
public class DemoController {

    private final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private DemoControllerService demoControllerService;

   // private final String URL_WITH_ID_PARAM = "http://localhost:8080/api/doctors/id/{id}";

    public DemoController(DemoControllerService demoControllerService) {
        this.demoControllerService = demoControllerService;
    }

    @GetMapping("/doctors")
    public String getDoctors(Model model) {

        model.addAttribute("doctors", demoControllerService.getAll());

        logger.info("Calling method from DemoController class");

        return "demo";

    }



}
