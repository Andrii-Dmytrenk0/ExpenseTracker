package org.example.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Expense {
    private int id;
    private Date date;
    private String description;
    private int amount;

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

    public void setDate(Date date){
        this.date = date;
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


//    public boolean DataVerification(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Expense expense = (Expense) o;
//
//
//    }

    public String toExpense() {
        return "Expense{" +
                "ID:" + id +
                "Date:" + date +
                "Description" + description +
                "Amount" + amount + "}";
    }
}
