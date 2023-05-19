package skypro.homeworks.calculator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.homeworks.calculator.service.CalculatorService;

import java.util.Objects;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(value = "", produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2", required = false) Integer b
    ) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return buildView(a, b, "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a,
                        @RequestParam(value = "num2", required = false) Integer b
    ) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return buildView(a, b, "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a,
                           @RequestParam(value = "num2", required = false) Integer b
    ) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return buildView(a, b, "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a,
                         @RequestParam(value = "num2", required = false) Integer b
    ) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return buildView(a, b, "/");
    }

    private String buildView(Integer a, Integer b, String operation) {

        String x = calculatorService.checkInputsForNull(a, b);
        if (x != null) return x;

        Number result;

        switch (operation) {
            case "-" -> result = calculatorService.minus(a, b);
            case "*" -> result = calculatorService.multiply(a, b);
            case "/" -> result = calculatorService.divide(a, b);
            default -> result = calculatorService.plus(a, b);
        }

        return a + " " + operation + " " + b + " = " + result;
    }

}
