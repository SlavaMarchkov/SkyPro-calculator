package skypro.homeworks.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calc(String num1, String num2, String operator) {
        String result = checkParams(num1, num2);
        if (result != null) return result;

        float calcResult = 0F;

        switch (operator) {
            case "+" -> calcResult = Integer.parseInt(num1) + Integer.parseInt(num2);
            case "-" -> calcResult = Integer.parseInt(num1) - Integer.parseInt(num2);
            case "*" -> calcResult = Integer.parseInt(num1) * Integer.parseInt(num2);
            case "/" -> calcResult = (float) Integer.parseInt(num1) / Integer.parseInt(num2);
            default -> {
            }
        }

        return num1 + " " + operator + " " + num2 + " = " + calcResult;
    }

    private static String checkParams(String num1, String num2) {
        String result = null;

        if (num1.isEmpty() || num2.isEmpty()) {
            result = "Ошибка! Все параметры должны быть переданы!";
        } else if (num2.equals("0")) {
            result = "На ноль делить нельзя!";
        }

        return result;
    }
}
