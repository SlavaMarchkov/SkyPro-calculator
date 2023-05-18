package skypro.homeworks.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Number plus(final Integer a, final Integer b) {
        return a + b;
    }

    @Override
    public Number minus(final Integer a, final Integer b) {
        return a - b;
    }

    @Override
    public Number multiply(final Integer a, final Integer b) {
        return a * b;
    }

    @Override
    public Number divide(final Integer a, final Integer b) {
        if (b == 0) {
            throw new IllegalArgumentException("На ноль делить нельзя!");
        }
        return a / (double) b;
    }

    @Override
    public String checkInputsForNull(final Integer a, final Integer b) {
        if (a == null || b == null) {
            return "Ошибка! Все параметры должны быть переданы!";
        }
        return null;
    }

}
