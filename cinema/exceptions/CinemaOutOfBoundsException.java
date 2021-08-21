package cinema.exceptions;

import cinema.RequestStatus;

public class CinemaOutOfBoundsException extends AbstractCinemaException {

    public CinemaOutOfBoundsException() {
        super(RequestStatus.OUT_OF_BOUNDS.getError());
    }
}