package cinema.entities;

import java.util.ArrayList;

public class GlobalCinema extends Cinema{
    private ArrayList<BoughtTicket> purchased_seats;
    private Statistics statistics;

    public GlobalCinema() {
        super();
        purchased_seats = new ArrayList<>();
        statistics = new Statistics(super.available_seats.size());
    }

    public ArrayList<BoughtTicket> getPurchased_seats() {
        return this.purchased_seats;
    }

    public void setPurchased_seats(ArrayList<BoughtTicket> purchased_seats) {
        this.purchased_seats = purchased_seats;
    }

    public Statistics getStatistics() {
        return this.statistics;
    }

    public void setStatistics(boolean isPurchase, int price) {
        if (isPurchase) {
            this.statistics.improveCurrent_income(price);
            this.statistics.reduceNumber_of_available_seats();
            this.statistics.improveNumber_of_purchased_tickets();
        } else {
            this.statistics.reduceCurrent_income(price);
            this.statistics.improveNumber_of_available_seats();
            this.statistics.reduceNumber_of_purchased_tickets();
        }
    }

    public void buySeat(BoughtTicket boughtTicket) {
        this.purchased_seats.add(boughtTicket);
        this.available_seats.remove(boughtTicket.getTicket());
        this.setStatistics(true, boughtTicket.getTicket().getPrice());
    }

    public Ticket returnTicket(String token) {
        for (int i = 0; i < this.purchased_seats.size(); i++) {
            BoughtTicket boughtTicket = this.purchased_seats.get(i);

            if (boughtTicket.getToken().equals(token)) {
                this.available_seats.add(boughtTicket.getTicket());
                this.purchased_seats.remove(boughtTicket);
                this.setStatistics(false, boughtTicket.getTicket().getPrice());
                return boughtTicket.getTicket();
            }
        }

        return null;
    }

    public Cinema toCinema() {
        return new Cinema(this.total_rows, this.total_columns, this.available_seats);
    }

}
