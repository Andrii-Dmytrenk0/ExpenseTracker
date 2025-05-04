package model.expensejsonconverter;

import org.assertj.core.api.Assertions;
import org.example.model.Expense;
import org.example.expensejsonconverter.ExpenseJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class ExpenseJsonConverterTest {
    private ExpenseJsonConverter converter = new ExpenseJsonConverter();

    @Test
    @DisplayName("Should parse to object, when valid json is given")
    void test1() throws ParseException {
        //given
        var validJson = """
                           {
                              "id": 1,
                              "date": "2020-01-01",
                              "description": "Lunch",
                              "amount": 20
                           }
                        """;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = sdf.parse("2020-01-01");

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date = calendar.getTime();

        var expectedObject = new Expense(1, date, "Lunch", 20);

        //when
        var result = converter.convert(validJson);

        //then
        Assertions.assertThat(result).isEqualTo(expectedObject);
    }


    @Test
    @DisplayName("Should parse to json, when valid object is given")
    void test2() throws ParseException {
        //given
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = sdf.parse("2020-01-01");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date = calendar.getTime();
        var validObject = new Expense(1, date, "Lunch", 20);

        var expectedJson = """
                           {
                              "id": 1,
                              "date": "2020-01-01",
                              "description": "Lunch",
                              "amount": 20
                           }
                        """;

        //when
        var result = converter.convert(validObject);
        //then
        Assertions.assertThat(result).isEqualToIgnoringWhitespace(expectedJson);
    }
}
