package cinema.entities;

public class Statistics {

    private static final String PASSWORD = "super_secret";

    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;

    public Statistics() {
        current_income = 0;
        number_of_available_seats = 0;
        number_of_purchased_tickets = 0;
    }

    public Statistics(int number_of_available_seats) {
        this.current_income = 0;
        this.number_of_available_seats = number_of_available_seats;
        this.number_of_purchased_tickets = 0;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public void improveCurrent_income(int difference) {
        this.current_income += difference;
    }

    public void reduceCurrent_income(int difference) {
        this.current_income -= difference;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void improveNumber_of_available_seats() {
        this.number_of_available_seats++;
    }

    public void reduceNumber_of_available_seats() {
        this.number_of_available_seats--;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void improveNumber_of_purchased_tickets() {
        this.number_of_purchased_tickets++;
    }

    public void reduceNumber_of_purchased_tickets() {
        this.number_of_purchased_tickets--;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
