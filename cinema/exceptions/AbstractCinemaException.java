package cinema.exceptions;

abstract class AbstractCinemaException extends RuntimeException {
    protected String message;

    protected AbstractCinemaException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
