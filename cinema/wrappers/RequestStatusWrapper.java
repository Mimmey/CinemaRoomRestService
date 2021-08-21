package cinema.wrappers;

import cinema.RequestStatus;

public class RequestStatusWrapper {
    private String error;

    public RequestStatusWrapper() {
        this.error = "";
    }

    public RequestStatusWrapper(RequestStatus status) {
        this.error = status.getError();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
