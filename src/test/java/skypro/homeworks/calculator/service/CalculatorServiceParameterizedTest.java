package skypro.homeworks.calculator.service;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import skypro.homeworks.calculator.exception.DivByZeroException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static skypro.homeworks.calculator.constants.CalculatorServiceTestConstants.*;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService out = new CalculatorServiceImpl();

    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 2, 1),
                Arguments.of(5, 10, 15)
        );
    }

    public static Stream<Arguments> divideNegativeTestParams() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(-1, 0)
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(5, 5, 1.0),
                Arguments.of(5, -5, -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void test(int a, int b, int expected) {
        assertEquals(expected, out.plus(a, b));
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(int a, int b, Number expected) {
        Assertions.assertThat(out.divide(a, b).doubleValue())
                .isCloseTo(expected.doubleValue(), Offset.offset(0.0));
    }

    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideNegativeTest(int a, int b) {
        Assertions.assertThatExceptionOfType(DivByZeroException.class)
                .isThrownBy(() -> out.divide(a, b));
    }

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
