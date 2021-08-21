package cinema.exceptions;

import cinema.RequestStatus;

public class WrongTokenException extends AbstractCinemaException {

    public WrongTokenException() {
        super(RequestStatus.WRONG_TOKEN.getError());
    }
}
