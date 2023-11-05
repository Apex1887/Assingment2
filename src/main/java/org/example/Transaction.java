package org.example;
import java.util.Date;

public class Transaction {

    private double amount;

    private Date date;

    public Transaction(double amount, String id, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }
    public Date getDate() {
        return date;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }
    public void setAmount() {
        this.amount = amount;
    }
}
