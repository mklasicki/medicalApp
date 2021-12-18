package pl.klasicki.doctor;

import pl.klasicki.commons.Mapper;

class DoctorMapper implements Mapper<DoctorDto,Doctor> {

    @Override
    public DoctorDto toDto(Doctor doctor) {
        return DoctorDto.builder()
                .withId(doctor.getId())
                .withFirstName(doctor.getFirstName())
                .withLastName(doctor.getLastName())
                .withSpecialization(doctor.getSpecialization())
                .build();
    }

    @Override
    public Doctor toDomain(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getFirstName(), doctorDto.getLastName(), doctorDto.getId(), doctorDto.getSpecialization());
    }
}
