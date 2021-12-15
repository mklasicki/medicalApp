package pl.klasicki.doctor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.klasicki.commons.DoctorNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    private final long USER_ID = 1L;

    @Mock
    DoctorRepository doctorRepository;

    @InjectMocks
    DoctorService doctorService;

    @BeforeEach
    void setUp() {
     //   MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Getting all doctors")
    void should_return_list_of_all_the_doctors() {

        //given
        List<Doctor> doctorList = generateTestData();
        when(doctorRepository.findAll()).thenReturn(doctorList);

        //when
        List<Doctor> testDoctorList = doctorService.getAll();

        //then
        assertThat(testDoctorList, hasSize(3));
        assertNotNull(testDoctorList);
    }

    @Test
    @DisplayName("Get Doctor by id")
    void should_return_one_doctor_when_given_id() {

        //given
        Optional<Doctor> doctor = Optional.of(new Doctor("Marcin", "Klasicki", USER_ID, "dentysta"));
        when(doctorRepository.findById(USER_ID)).thenReturn(doctor);

        //when
        Optional<Doctor> testDoctorResult = doctorService.findById(USER_ID);

        //then
        assertThat(testDoctorResult, equalTo(doctor));
        verify(doctorRepository, times(1)).findById(USER_ID);
    }


    @Test
    @DisplayName("Throw DoctorNotFoundException")
    void should_throw_DoctorNotFoundException_when_doctor_not_found() {

        //given
        //when
        when(doctorRepository.findById(any())).thenReturn(null);

        //then
        assertThrows(DoctorNotFoundException.class, () -> doctorService.findById(USER_ID));
    }

    @Test
    @DisplayName("Save new doctor")
    void should_add_new_doctor() {

        //given
        Doctor doctor = new Doctor("Marcin", "Klasicki", 1L, "dentysta");
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        //when
        Doctor test = doctorService.add(doctor);

        //then
        verify(doctorRepository, times(1)).save(doctor);
        assertThat(test, is(doctor));
        assertThat(test.getFirstName(), is("Marcin"));
    }

    @Test
    @DisplayName("Delete doctor")
    void should_delete_doctor_when_given_id() {

        //given
        //when
        doctorService.delete(USER_ID);

        //then
        verify(doctorRepository, times(1)).deleteById(anyLong());

    }

    private List<Doctor> generateTestData() {

        Doctor doctor1 = new Doctor("Marcin", "Klasicki", 1L, "dentysta");
        Doctor doctor2 = new Doctor("Stefan", "Stefański", 2L, "ortopeda");
        Doctor doctor3 = new Doctor("Typowy", "Seba", 3L, "dentysta");

        return Arrays.asList(doctor1, doctor2, doctor3);
    }

}