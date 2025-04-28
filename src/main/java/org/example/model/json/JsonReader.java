package org.example.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Expense;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader {

    public List<Expense> getExpense(String json) {
        ObjectMapper mapper = new ObjectMapper();
        List<Expense> methodList = new ArrayList<>();
        try {
            methodList = Arrays.asList(mapper.readValue(json, Expense[].class));
        } catch (IOException e) {
            System.out.println(e);
        }
        return methodList;
    }
}
