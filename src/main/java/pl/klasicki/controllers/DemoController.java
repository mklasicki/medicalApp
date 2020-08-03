package pl.klasicki.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.klasicki.domain.Doctor;


import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/demo")
public class DemoController {

    private RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/doctors/";
    private final String URL_WITH_ID_PARAM = "http://localhost:8080/api/doctors/{id}";

    public DemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/doctors")
    public String getDoctors(Model model) {

        model.addAttribute("doctors", restTemplate.getForObject(BASE_URL, Object[].class));
        return "demo";

    }


    @GetMapping("/doctors/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Map<String, Long> param = new HashMap<>();
        param.put("id", id);
        ResponseEntity<Doctor> response = restTemplate.exchange(URL_WITH_ID_PARAM,
                                                                HttpMethod.GET,
                                                                HttpEntity.EMPTY,
                                                                Doctor.class, param);
        model.addAttribute("doctor", response);

        return "demo";
    }

    @DeleteMapping("/doctors/{id}")
    public void delete(@PathVariable Long id) {
        String url = "http://localhost:8080/api/doctors/" + id;
        restTemplate.delete(url);
        System.out.println("Skasowano encję o id " + id);
    }


}
