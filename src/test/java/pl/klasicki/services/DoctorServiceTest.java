package pl.klasicki.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.klasicki.dao.DoctorRepository;
import pl.klasicki.domain.Doctor;
import pl.klasicki.exceptions.DoctorNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


class DoctorServiceTest {

    private final long USER_ID = 1L;

    @Mock
    DoctorRepository doctorRepository;

    @InjectMocks
    DoctorService doctorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Getting all doctors")
    void getAll() {

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
    void findById() {

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
    void findById_ThrowsDoctorNotFoundException() {

        //given
        //when
        when(doctorRepository.findById(any())).thenReturn(null);

        //then
        assertThrows(DoctorNotFoundException.class, () -> doctorService.findById(USER_ID));
    }

    @Test
    @DisplayName("Save new doctor")
    void addNewDoctor() {

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
    void deleteDoctor() {

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