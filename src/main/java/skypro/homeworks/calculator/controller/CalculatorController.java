package skypro.homeworks.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.homeworks.calculator.service.CalculatorService;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showGreeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String calcSum(@RequestParam() String num1, @RequestParam() String num2) {
        return calculatorService.calc(num1, num2, "+");
    }

    @GetMapping("/minus")
    public String calcDiff(@RequestParam() String num1, @RequestParam() String num2) {
        return calculatorService.calc(num1, num2, "-");
    }

    @GetMapping("/multiply")
    public String calcMult(@RequestParam() String num1, @RequestParam() String num2) {
        return calculatorService.calc(num1, num2, "*");
    }

    @GetMapping("/divide")
    public String calcDiv(@RequestParam() String num1, @RequestParam() String num2) {
        return calculatorService.calc(num1, num2, "/");
    }
}
