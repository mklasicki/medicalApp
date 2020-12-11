package pl.klasicki.services.impl;


import org.springframework.beans.factory.annotation.Value;
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
    private final String BASE_URL;

    public DemoControllerServiceImpl(RestTemplate restTemplate, @Value("${BASE.URL}") String BASE_URL) {
        this.restTemplate = restTemplate;
        this.BASE_URL = BASE_URL;
    }

    @Override
    public List<Doctor> getAll() {

        ResponseEntity<Doctor[]> response = restTemplate.getForEntity(BASE_URL, Doctor[].class);
        Doctor[] doctors = response.getBody();


        return Arrays.asList(doctors);
    }
}
