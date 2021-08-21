package cinema;

public enum RequestStatus {
    ALREADY_PURCHASED("The ticket has been already purchased!"),
    OUT_OF_BOUNDS("The number of a row or a column is out of bounds!"),
    WRONG_TOKEN("Wrong token!"),
    WRONG_PASSWORD("The password is wrong!"),
    SUCCESS("");

    private final String error;

    RequestStatus (String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
