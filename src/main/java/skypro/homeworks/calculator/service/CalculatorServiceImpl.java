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
        return a / (double) b;
    }

}
