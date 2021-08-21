package cinema.entities;

import java.util.UUID;

public class Ticket {

    private int row;
    private int column;
    private int price;

    public Ticket() {
        this.row = 0;
        this.column = 0;
        this.price = 0;
    }

    public Ticket(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
