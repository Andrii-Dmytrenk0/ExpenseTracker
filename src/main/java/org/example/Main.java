package org.example;

import org.example.model.Expense;
import org.example.model.json.JsonReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonReader reader = new JsonReader();

        String json = "[\n" +
                "   {\n" +
                "   \"ID\":\"01\",\n" +
                "   \"Date\":\"01.01.2020\",\n" +
                "   \"Description\":\"Lunch\",\n" +
                "   \"Amount\":\"20$\",\n" +
                " },\n";

        List<Expense> expenseList = reader.getExpense(json);

        for (Expense expense : expenseList) {
            System.out.println(expense);
        }
    }
}