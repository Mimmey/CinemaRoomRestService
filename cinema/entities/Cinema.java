package cinema.entities;

import cinema.RequestStatus;

import java.util.ArrayList;
import java.util.UUID;

public class Cinema {

    protected int total_rows;
    protected int total_columns;
    protected ArrayList<Ticket> available_seats;

    public Cinema() {
        total_columns = 9;
        total_rows = 9;
        available_seats = new ArrayList<>();

        for (int i = 1; i <= total_rows; i++) {
            for (int j = 1; j <= total_columns; j++) {
                available_seats.add(new Ticket(i, j));
            }
        }
    }

    protected Cinema(int total_rows, int total_columns, ArrayList<Ticket> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public ArrayList<Ticket> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(ArrayList<Ticket> available_seats) {
        this.available_seats = available_seats;
    }

    public int getIndexOfTicket(Ticket ticket) {
        for (int i = 0; i < available_seats.size(); i++) {
            if (available_seats.get(i).getRow() == ticket.getRow() && available_seats.get(i).getColumn() == ticket.getColumn()) {
                return i;
            }
        }

        return -1;
    }

    public RequestStatus getStatusOfAvailability(Ticket ticket) {
        if (ticket.getRow() <= 0 || ticket.getColumn() <= 0 || ticket.getRow() > total_rows || ticket.getColumn() > total_columns) {
            return RequestStatus.OUT_OF_BOUNDS;
        }

        for (Ticket available_seat : available_seats) {
            if (available_seat.getRow() == ticket.getRow() && available_seat.getColumn() == ticket.getColumn()) {
                return RequestStatus.SUCCESS;
            }
        }

        return RequestStatus.ALREADY_PURCHASED;
    }
}
