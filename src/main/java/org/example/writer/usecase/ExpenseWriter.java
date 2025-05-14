package org.example.writer.usecase;

import org.example.model.Expense;

public interface ExpenseWriter {
    void write(Expense expenseToWrite);
}

