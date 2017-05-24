package Yerchik.entity;

import javax.persistence.*;

/**
 * Created by Yerchik on 23.05.2017.
 */
@Entity
public class Spending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private Account account;

    public Spending() {
    }

    public Spending(double amount, String date, String description, Currency currency, Account account) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.currency = currency;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

      public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Account getAccount() {
        return account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


