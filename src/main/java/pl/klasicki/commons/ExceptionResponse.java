package pl.klasicki.commons;

class ExceptionResponse {

    private int id;
    private int status;
    private String message;
    private long timeStamp;


    ExceptionResponse() {
    }

    ExceptionResponse(int id, int status, String message, long timeStamp) {
        this.id = id;
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getStatus() {
        return status;
    }

    void setStatus(int status) {
        this.status = status;
    }

    String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    long getTimeStamp() {
        return timeStamp;
    }

    void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
