package pl.klasicki.dto;

import java.time.LocalDate;

public class ExceptionResponse {

    private int id;
    private int status;
    private String message;
    private LocalDate timeStamp;


    public ExceptionResponse() {
    }

    public ExceptionResponse(int id, int status, String message, LocalDate timeStamp) {
        this.id = id;
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
}
