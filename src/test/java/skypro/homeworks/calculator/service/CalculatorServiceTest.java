package skypro.homeworks.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skypro.homeworks.calculator.exception.DivByZeroException;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static skypro.homeworks.calculator.constants.CalculatorServiceTestConstants.*;

public class CalculatorServiceTest {

    private final CalculatorService out = new CalculatorServiceImpl();

    @Test
    public void test() {
        List<Integer> actual = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> expected = new ArrayList<>(List.of(3, 2, 1));

        Collections.sort(actual);
        Collections.sort(expected);

        Assertions.assertEquals(expected, actual);
    }

    /**
     * Проверяет на отсутствие одного или обоих параметров
     */
    @Test
    public void shouldReturnNullParamsMessageWhenNumbersAreNull() {
        String result = out.checkInputsForNull(NULL_NUM1, NULL_NUM2);
        assertEquals(NULL_PARAMS_MESSAGE, result);
    }

    @Test
    public void shouldReturnNullWhenNumbersAreNotNull() {
        String result = out.checkInputsForNull(CORRECT_NUM1, CORRECT_NUM2);
        assertNull(result);
    }

    /**
     * Проверяет метод суммирования
     */
    @Test
    public void plusTest() {
        Number actual = out.plus(2, 3);
        Number expected = 5;

        assertEquals(expected, actual);

        actual = out.plus(-2, 3);
        expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectSumWhenNumbersAreCorrect() {
        Number result = out.plus(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_SUM, result, "Сумма не равна " + CORRECT_SUM);
    }


    /**
     * Проверяет метод вычитания
     */
    @Test
    public void minusTest() {
        Number actual = out.minus(2, 3);
        Number expected = -1;

        assertEquals(expected, actual);

        actual = out.minus(-2, 3);
        expected = -5;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectDifferenceWhenNumbersAreCorrect() {
        Number result = out.minus(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_DIFF, result, "Разность не равна " + CORRECT_DIFF);
    }

    /**
     * Проверяет метод произведения
     */
    @Test
    public void multiplyTest() {
        Number actual = out.multiply(2, 3);
        Number expected = 6;

        assertEquals(expected, actual);

        actual = out.multiply(-2, 3);
        expected = -6;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectMultWhenNumbersAreCorrect() {
        Number result = out.multiply(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_MULT, result, "Произведение не равно " + CORRECT_MULT);
    }

    /**
     * Проверяет метод деления
     */
    @Test
    public void divideTest() {
        Number actual = out.divide(2, 3);
        Number expected = 0.6666666666666666;

        assertEquals(expected, actual);

        actual = out.divide(-2, 3);
        expected = -0.6666666666666666;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectDivisionWhenNumbersAreCorrect() {
        Number result = out.divide(CORRECT_NUM1, CORRECT_NUM2);
        assertEquals(CORRECT_DIV, result, "Частное не равно " + CORRECT_DIV);
    }

    /**
     * Проверят выброс исключения IllegalArgumentException, если делитель равен нулю
     */
    @Test
    public void divideNegativeTest() {
        assertThrows(DivByZeroException.class, () -> out.divide(3, 0));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenDenominatorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> out.divide(CORRECT_NUM1, ILLEGAL_NUM2));
    }

}
