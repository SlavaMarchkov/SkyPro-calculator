package skypro.homeworks.calculator.service;

public interface CalculatorService {

    Number plus(int a, int b);

    Number minus(int a, int b);

    Number multiply(int a, int b);

    Number divide(int a, int b);

    String checkInputsForNull(int a, int b);

}
