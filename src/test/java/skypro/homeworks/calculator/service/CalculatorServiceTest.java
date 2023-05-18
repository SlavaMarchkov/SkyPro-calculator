package skypro.homeworks.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static skypro.homeworks.calculator.constants.CalculatorServiceTestConstants.*;

public class CalculatorServiceTest {

    private final CalculatorService out = new CalculatorServiceImpl();

    /**
     * Проверяет на отсутствие одного или обоих параметров
     */
    @Test
    public void shouldReturnNullParamsMessageWhenNumbersAreNull() {
        String result = out.checkInputsForNull(NULL_NUM1, NULL_NUM2);
        assertEquals(NULL_PARAMS_MESSAGE, result);
    }

    /**
     * Проверяет метод суммирования
     */
    @Test
    public void shouldReturnCorrectSumWhenNumbersAreCorrect() {
        Number result = out.plus(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_SUM, result, "Сумма не равна " + CORRECT_SUM);
    }


    /**
     * Проверяет метод вычитания
     */
    @Test
    public void shouldReturnCorrectDifferenceWhenNumbersAreCorrect() {
        Number result = out.minus(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_DIFF, result, "Разность не равна " + CORRECT_DIFF);
    }

    /**
     * Проверяет метод произведения
     */
    @Test
    public void shouldReturnCorrectMultWhenNumbersAreCorrect() {
        Number result = out.multiply(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_MULT, result, "Произведение не равно " + CORRECT_MULT);
    }

    /**
     * Проверяет метод деления
     */
    @Test
    public void shouldReturnCorrectDivisionWhenNumbersAreCorrect() {
        Number result = out.divide(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_DIV, result, "Частное не равно " + CORRECT_DIV);
    }

    /**
     * Проверят выброс исключения IllegalArgumentException, если делитель равен нулю
     */
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenDenominatorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> out.divide(CORRECT_NUM1, ILLEGAL_NUM2));
    }

}
