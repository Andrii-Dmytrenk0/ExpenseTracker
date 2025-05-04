package org.example.expensejsonconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Expense;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class ExpenseJsonConverter {

    public Expense convert(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Expense parsedExpense;
        try {
            parsedExpense = mapper.readValue(json, Expense.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parsedExpense;
    }

    public String convert(Expense objectToWrite) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("UTC"));
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        String json;
        try {
            json = mapper.writeValueAsString(objectToWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}

