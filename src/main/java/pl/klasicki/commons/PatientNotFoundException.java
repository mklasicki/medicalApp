package pl.klasicki.commons;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}
