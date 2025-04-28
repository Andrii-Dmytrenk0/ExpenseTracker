package writer.core;

import org.assertj.core.api.Assertions;
import org.example.writer.core.ExpenseWriter;
import org.example.writer.usecase.Writer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpenseWriterTest {
    private Writer userWrite;

    @Test
    @DisplayName("Validate user description and amount")
    void test1() {
        //given
        userWrite = new ExpenseWriter();
        var correctDescriptionAndAmount = "lunch20";
        //when
        var writeToJson = userWrite.write(correctDescriptionAndAmount);
        //then
        Assertions.assertThat(writeToJson).isEqualTo("description: lunch, amount: 20");
    }

}
