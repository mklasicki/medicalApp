package pl.klasicki.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import pl.klasicki.doctor.DoctorNotFoundException;
import pl.klasicki.patient.PatientNotFoundException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest request, DoctorNotFoundException exc) {

        ExceptionResponse error = new ExceptionResponse();
        error.setId(12);
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        logger.error("Request " + request.getRequestURL() + " threw a exception " + exc);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest request, PatientNotFoundException exc) {
        ExceptionResponse error = new ExceptionResponse();
        error.setId(15);
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        logger.error("Request " + request.getRequestURL() + " threw a exception " + exc);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception exc) {

        ExceptionResponse error = new ExceptionResponse();
        error.setId(23);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad data, use only integer values.");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest request, DataNotFoundException exc) {

        ExceptionResponse error = new ExceptionResponse();
        error.setId(22);
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        logger.error("Request " + request.getRequestURL() + " threw a exception " + exc);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


}
