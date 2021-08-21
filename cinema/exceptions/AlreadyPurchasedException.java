package cinema.exceptions;

import cinema.RequestStatus;

public class AlreadyPurchasedException extends AbstractCinemaException {

    public AlreadyPurchasedException() {
        super(RequestStatus.ALREADY_PURCHASED.getError());
    }
}
