package com.example.demo.controller;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloViewController {

    @GetMapping("/hello")
    public String hello(Model model){
        // model 은 힙 영역에 저장되어있고, 이 데이터는 View 에서 표현할 때 공유됨.
        model.addAttribute("data" , "원재호");
        return "hello";
    }

    @GetMapping("/helloString")
    @ResponseBody
    public String helloString( ){
        return "String";
    }

    @GetMapping("/helloJson")
    @ResponseBody
    public Member helloJson(Model model ){
        model.addAttribute("data" , "원재호");
        return new Member("호야");
    }

}
