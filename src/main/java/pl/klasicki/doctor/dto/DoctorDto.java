package pl.klasicki.doctor.dto;

public class DoctorDto {

    public static Builder builder() {
        return new Builder();
    }

    //TODO add validation for data passed from front end
    //TODO add method to map DoctorDto to Doctor object
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String specialization;

    private DoctorDto(final Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        specialization = builder.specialization;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String specialization;

        private Builder() {}

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public DoctorDto build() {
            return new DoctorDto(this);
        }
    }
}
