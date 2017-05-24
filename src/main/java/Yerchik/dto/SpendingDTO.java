package Yerchik.dto;

/**
 * Created by Yerchik on 24.05.2017.
 */
public class SpendingDTO {
    private double amount;
    private String year;
    private String month;
    private String day;
    private String description;
    private String currency;

    public SpendingDTO() {
    }

    public SpendingDTO(double amount, String description, String currency) {
        this.amount = amount;
        this.description = description;
        this.currency = currency;
    }

    public SpendingDTO(double amount, String year, String month, String day, String description, String currency) {
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "" + amount + " " + currency + " '" + description + "'";
    }

}
