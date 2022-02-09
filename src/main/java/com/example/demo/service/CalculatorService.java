package com.example.demo.service;

import com.example.demo.model.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(int x, int y) {
        // 클래스와 객체의 차이!!
        // 클래스는 정의, 객체는 뭐랏?
        // ctrl + alt + v => 클래스 자동완성
        // ctrl + shift + enter => 세미콜론 완성
        Calculator calculator = new Calculator();
        return calculator.add(x, y);
    }

    public int minus(int x, int y) {
        Calculator calculator = new Calculator();
        return calculator.minus(x, y);
    }
}
