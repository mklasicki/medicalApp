package pl.klasicki.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.klasicki.domain.Doctor;
import pl.klasicki.services.DoctorService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DoctorRestController.class)
class DoctorRestControllerTest {

    private final long USER_ID = 1L;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DoctorService doctorService;

    @InjectMocks
    DoctorRestController doctorRestController;

    @BeforeEach
    void  setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() throws Exception {

        //given
        given(doctorService.getAll()).willReturn(generateTestData());

        //when
       // List<Doctor> testData = doctorRestController.getAll();

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/doctors/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

       // assertThat(testData, hasSize(3));
        verify(doctorService, times(2)).getAll();
    }

    @Test
    void findBySpec() {
    }

    @Test
    void findById() throws Exception {

        //given
        given(doctorService.getAll()).willReturn(generateTestData());

        //then
       // Optional<Doctor> testDoctorResult = doctorRestController.findById(USER_ID);

        //then
       mockMvc.perform(MockMvcRequestBuilders.get("/api/doctors/id/" + USER_ID))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void add() throws Exception {

        //given
        given(doctorService.add(any(Doctor.class))).
                willReturn(new Doctor("Marcin", "Klasicki", 1L, "dentysta"));

        //when
        //Doctor doctor = doctorRestController.add(new Doctor());

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/doctors/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
      //  assertThat(doctor.getFirstName(), is("Marcin"));

    }

    @Test
    void update() {
    }

    @Test
    void delete() {

        //given
        //when
        doctorService.delete(USER_ID);

        //then
        verify(doctorService, times(1)).delete(USER_ID);


    }

    private List<Doctor> generateTestData() {

        Doctor doctor1 = new Doctor("Marcin", "Klasicki", 1L, "dentysta");
        Doctor doctor2 = new Doctor("Stefan", "Stefański", 2L, "ortopeda");
        Doctor doctor3 = new Doctor("Typowy", "Seba", 3L, "dentysta");

        return Arrays.asList(doctor1, doctor2, doctor3);
    }
}