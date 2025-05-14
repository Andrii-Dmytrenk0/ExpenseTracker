package org.example.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

public class Expense {
    private int id;
    private Date date;
    private String description;
    private int amount;

    public Expense(int id, Date date, String description, int amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public Expense() {
    }

    public int getId() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return id == expense.id && amount == expense.amount && Objects.equals(date, expense.date) && Objects.equals(description, expense.description);
    }

    @Override
    public String toString() {
        return "ExpenseFile.txt{" +
                "ID:" + id +
                " Date: " + date +
                " Description: " + description +
                " Amount: " + amount + "}";
    }
}
