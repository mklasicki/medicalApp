package pl.klasicki.services.impl;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.klasicki.domain.Doctor;
import pl.klasicki.services.DemoControllerService;

import java.util.Arrays;
import java.util.List;

@Service
public class DemoControllerServiceImpl implements DemoControllerService {

    private RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/doctors/";

    public DemoControllerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Doctor> getAll() {

        ResponseEntity<Doctor[]> response = restTemplate.getForEntity(BASE_URL, Doctor[].class);
        Doctor[] doctors = response.getBody();
        List<Doctor> doctorList = Arrays.asList(doctors);

        return doctorList;
    }
}
