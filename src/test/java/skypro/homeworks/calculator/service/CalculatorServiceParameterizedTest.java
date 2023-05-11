package skypro.homeworks.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static skypro.homeworks.calculator.constants.CalculatorServiceTestConstants.*;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService out = new CalculatorServiceImpl();

    @DisplayName("Должен посчитать корректную сумму")
    @ParameterizedTest()
    @MethodSource("numbersProvider")
    public void shouldReturnSum(Integer num1, Integer num2, Number expectedResult) {
        assertEquals(expectedResult, out.plus(num1, num2));
    }

    @DisplayName("Должен посчитать корректную разность")
    @ParameterizedTest()
    @MethodSource("numbersProvider")
    public void shouldReturnDiff(Integer num1, Integer num2, Number expectedResult) {
        assertEquals(expectedResult, out.minus(num1, num2));
    }

    @DisplayName("Должен посчитать корректное произведение")
    @ParameterizedTest()
    @MethodSource("numbersProvider")
    public void shouldReturnMult(Integer num1, Integer num2, Number expectedResult) {
        assertEquals(expectedResult, out.multiply(num1, num2));
    }

    @DisplayName("Должен посчитать корректное частное")
    @ParameterizedTest()
    @MethodSource("numbersProvider")
    public void shouldReturnDiv(Integer num1, Integer num2, Number expectedResult) {
        assertEquals(expectedResult, out.divide(num1, num2));
    }

    private static Stream<Arguments> numbersProvider() {
        return Stream.of(
                Arguments.of(CORRECT_NUM1, CORRECT_NUM2, CORRECT_SUM),
                Arguments.of(CORRECT_NUM1, CORRECT_NUM2, CORRECT_DIFF),
                Arguments.of(CORRECT_NUM1, CORRECT_NUM2, CORRECT_MULT),
                Arguments.of(CORRECT_NUM1, CORRECT_NUM2, CORRECT_DIV),
                Arguments.of(null, CORRECT_NUM2, CORRECT_SUM),
                Arguments.of(2, 3, 5),
                Arguments.of(2, 3, -1),
                Arguments.of(2, 3, 6),
                Arguments.of(2, 3, 0.6666666666666666),
                Arguments.of(2, 0, 0.6666666666666666)
        );
    }

}
