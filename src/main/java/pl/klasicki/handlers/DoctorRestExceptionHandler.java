package pl.klasicki.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import pl.klasicki.dto.DoctorErrorResponse;
import pl.klasicki.exceptions.DoctorNotFoundException;

@ControllerAdvice
public class DoctorRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DoctorErrorResponse> handleException(DoctorNotFoundException exc) {

        DoctorErrorResponse error = new DoctorErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DoctorErrorResponse> handleException(Exception exc) {

        DoctorErrorResponse error = new DoctorErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad data!! You can only use integer values!");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
