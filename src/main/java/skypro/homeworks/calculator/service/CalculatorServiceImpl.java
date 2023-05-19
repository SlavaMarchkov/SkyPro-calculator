package skypro.homeworks.calculator.service;

import org.springframework.stereotype.Service;
import skypro.homeworks.calculator.exception.DivByZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Number plus(final int a, final int b) {
        return a + b;
    }

    @Override
    public Number minus(final int a, final int b) {
        return a - b;
    }

    @Override
    public Number multiply(final int a, final int b) {
        return a * b;
    }

    @Override
    public Number divide(final int a, final int b) {
        if (b == 0) {
            throw new DivByZeroException();
        }
        return (double) a / b;
    }

    @Override
    public String checkInputsForNull(final int a, final int b) {
        if (a == 0 || b == 0) {
            return "Ошибка! Все параметры должны быть переданы!";
        }
        return null;
    }

}
