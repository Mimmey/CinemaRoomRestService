package cinema.exceptions;

import cinema.RequestStatus;

public class WrongPasswordException extends AbstractCinemaException{

    public WrongPasswordException() {
        super(RequestStatus.WRONG_PASSWORD.getError());
    }
}
