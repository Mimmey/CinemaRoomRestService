package cinema.entities;

import java.util.UUID;

public class BoughtTicket {

    private final String token;
    private final Ticket ticket;

    {
        this.token = UUID.randomUUID().toString();
    }

    public BoughtTicket() {
        this.ticket = new Ticket(0, 0);
    }

    public BoughtTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public BoughtTicket(int row, int column) {
        this.ticket = new Ticket(row, column);
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public String getToken() {
        return this.token;
    }


}