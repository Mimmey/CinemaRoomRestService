package cinema;

import cinema.entities.*;
import cinema.exceptions.*;
import cinema.wrappers.RequestStatusWrapper;
import cinema.wrappers.TokenWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeatsController {
    private static final GlobalCinema cinema = new GlobalCinema();

    @GetMapping("/seats")
    public Cinema getCinema() {
        return cinema.toCinema();
    }

    @PostMapping("/purchase")
    public BoughtTicket purchase(@RequestBody Ticket ticket) {
        RequestStatus status = cinema.getStatusOfAvailability(ticket);

        switch (status) {
            case SUCCESS:
                int index = cinema.getIndexOfTicket(ticket);
                BoughtTicket boughtTicket = new BoughtTicket(cinema.getAvailable_seats().get(index));
                cinema.buySeat(boughtTicket);
                return boughtTicket;
            case ALREADY_PURCHASED:
                throw new AlreadyPurchasedException();
            case OUT_OF_BOUNDS:
                throw new CinemaOutOfBoundsException();
        }
        return null;
    }

    @PostMapping("/return")
    ReturnedTicket returnTicket(@RequestBody TokenWrapper token) {
        Ticket ticket = cinema.returnTicket(token.getToken());

        if (ticket == null) {
            throw new WrongTokenException();
        } else {
            return new ReturnedTicket(ticket);
        }
    }

    @PostMapping("/stats")
    Statistics getStatistics(@RequestParam(required = false) String password) {
        if (password == null) {
            throw new WrongPasswordException();
        }

        if (password.equals(Statistics.getPassword())) {
            return cinema.getStatistics();
        } else {
            throw new WrongPasswordException();
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyPurchasedException.class)
    @ResponseBody RequestStatusWrapper alreadyPurchasedError() {
        return new RequestStatusWrapper(RequestStatus.ALREADY_PURCHASED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CinemaOutOfBoundsException.class)
    @ResponseBody RequestStatusWrapper cinemaOutOfBoundsError() {
        return new RequestStatusWrapper(RequestStatus.OUT_OF_BOUNDS);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongTokenException.class)
    @ResponseBody
    RequestStatusWrapper wrongTokenError() {
        return new RequestStatusWrapper(RequestStatus.WRONG_TOKEN);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(WrongPasswordException.class)
    @ResponseBody
    RequestStatusWrapper wrongPasswordError() {
        return new RequestStatusWrapper(RequestStatus.WRONG_PASSWORD);
    }
}
