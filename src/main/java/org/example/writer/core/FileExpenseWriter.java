package org.example.writer.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileExpenseWriter {
    // Записываем введеные данные в файл
    public void writeExpenseToFile (String expense) {
        try {
            Path path = Path.of("src/File/ExpenseFile.txt");
            Files.writeString(path, expense + System.lineSeparator(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error writing to file" + e.getMessage());
        }
    }
}




// Integer.parseInt - в отдельной папке валидатор

// Почитать что такое сервислеер