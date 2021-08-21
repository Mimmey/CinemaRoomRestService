package cinema.entities;

public class ReturnedTicket {
    final Ticket returned_ticket;

    public ReturnedTicket(Ticket returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public Ticket getReturned_ticket() {
        return returned_ticket;
    }
}
