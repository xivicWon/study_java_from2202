package com.example.demo.controller;

import com.example.demo.model.Calculator;
import com.example.demo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Component 가 붙은 모든 클래스는 객체를 스프링 부트가 생성함(1개만)(싱글톤)
// IoC 컨테이너 or DI 컨테이너 or 스프링 컨테이너 에 저장되어있음.
// 이름은 앞에 대문자를 소문자로 줄여서 만듦
@RestController
public class HelloController {

    //    CalculatorService calculatorService = new CalculatorService();
    // 스프링 의존성 주입 방법
    /**
     * 1. 필드 인젝션
     * 2. 세터 인젝션
     * 3. 생성자 인젝션
     */
    @Autowired      // @Component 로 생성한 객체를 다 찾아옴.
                    // 컨테이너에 생성된 객체를 런타임에 주입시킴 (Run Time)
    private CalculatorService calculatorService;
    // HelloController 는 CalculatorService에 의존한다.

//    @Autowired
    private Calculator calculator;


    public HelloController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // Setter
    @Autowired
    public void setCalculatorService(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    // Getter
    public CalculatorService getCalculatorService(){
        return this.calculatorService;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world !!!";
    }

    @GetMapping("/api/main")
    public String main() {
        return "hello world !!!";
    }

    @GetMapping("/api/add")
    public int add() {
        Calculator calculator = new Calculator();
        return calculator.add(3, 5);
    }

    @GetMapping("/calc/add")
    public int calc(@RequestParam int x, @RequestParam int y) {
        System.out.println("CalculatorService = " + calculatorService);
        System.out.println("this = " + this);
        return calculatorService.add(x,y);
    }

    @GetMapping("/calc/minus")
    public int minus(@RequestParam int x , @RequestParam int y ){
        System.out.println("CalculatorService = " + calculatorService);
        System.out.println("this = " + this);
        return calculatorService.minus(x,y);
    }
}
