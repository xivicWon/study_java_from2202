package com.example.demo.controller;


import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * Simple Logging Facade For Java
 * Facade Pattern 공부하기 : Code Level 로 작성해오기
 * Slf4j : 명세, 스팩, 규격, 인터페이스
 * -> 구현체 = log4j, log4j2, logback(default)
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class MemberController {

    @GetMapping("/path-variable/{name}")
    public String pathVariable2(@PathVariable String name) {
        log.info("name : {}" , name);
        return "Ok";
    }

    @GetMapping("/servlet-param")
    public String servletParam2(HttpServletRequest request) {
        log.info("name : {}" , request.getParameter("name"));
        log.info("email : {}" , request.getParameter("email"));
        return "Ok";
    }

    @GetMapping("/request-param")
    public String requestParam2(@RequestParam(required = true, defaultValue = "10") String name,
                                @RequestParam String email) {
        log.info("name : {}" , name);
        log.info("email : {}" , email);
        return "Ok";
    }

    @GetMapping("/model-attribute")
    public String modelAttribute2(@ModelAttribute MemberDto memberDto){
        log.info("memberDto : {}" , memberDto );
        return "Ok";
    }

    @PostMapping(value = "/request-body/string")
    public String requestBody2(@RequestBody String body){
        log.info("body : {}" , body );
        return "Ok";
    }

    @PostMapping(value = "/request-body/parameter")
    public String requestBody3(@ModelAttribute MemberDto memberDto){
        log.info("memberDto : {}" , memberDto );
        return "Ok";
    }

    @PostMapping(value = "/request-body/object")
    public String requestBody4(@RequestBody MemberDto memberDto ){
        log.info("memberDto : {}" , memberDto );
        return "Ok";
    }

    /**
     * 유입된 모든 Param 을 입력받는 방식
     * TEST URL GET http://localhost:8080/member/requestParam?name=tt&age=12&ho=10
     */
    @GetMapping(value="/member/basic")
//    @RequestMapping(value="/member/basic" , method=RequestMethod.GET ) @GetMapping 과 동일
    // 파라미터 인자가 없는경우는 @RequestParam 이 생략된 것과 동일하다.
    public String basic(String name, Integer age, String ho){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("ho = " + ho);
        return "basic";
    }

    /**
     * <code>@RequestParam</code> 은 URL 경로에서 QueryString 내역중에 RequestParam으로 지정된 파라미터만 받는다.<br>
     * 1:1맵핑된다.<br>
     * TEST URL GET http://localhost:8080/member/requestParam?name=tt&age=12&ho=10
     * 문제 : 
     *  - required 를 true 로 했는데, 인자가 없어도 문제가 발생안됨..>> defaultValue 가 있으면 문제되지않음. 즉 DefaultValue 가 있으면, required 는 무용이됨.
     */
    @GetMapping(value="/member/requestParam")
    public String requestParam(@RequestParam(value="name", required=false) String name,
                               @RequestParam(value="age", required=false, defaultValue="0") Integer age){
        System.out.println("@RequestParam");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "requestParam";
    }

    /**
     * <code>@PathVariable</code> 는 URL 경로에서 특정위치의 데이터를 받아서 사용하는 방식<br>
     * TEST URL GET http://localhost:8080/member/testID
     */
    @RequestMapping(value="/member/{userId}", method=RequestMethod.GET)
    public String pathVariable(@PathVariable String userId) {
        System.out.println("@PathVariable");
        System.out.println("userId = " + userId);
        return "pathVariable";
    }


    /**
     * <code>@RequestBody</code> 는 POST로 전달되는 form data 의 데이터를 문자열로 받는 방식<br>
     * TEST URL POST http://localhost:8080/member/requestBody
     * Form-data {name=tt,age=12,ho=10}
     * >>> req = name=tt&name=tt&age=12&age=12&ho=10&ho=10
     */
    @PostMapping(value="/member/requestBody")
    public String requestBody(@RequestBody String req){
        System.out.println("@RequestBody");
        System.out.println("req = " + req);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MemberDto memberDto = objectMapper.readValue(req, MemberDto.class);
            log.info("memberDto >> {} " + memberDto );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "requestBody";
    }


    /**
     * <code>@ModelAttribute</code> 는 데이터를 특정 클래스의 형식에 맞게 받는 방식 (클래스객체에 포함되지 않는 필드는 제외됨.)<br>
     * 해당 클래스의 필드에 접근 또는 getter, setter 가 가능한 필드에 대해 매칭되어 할당됨.
     * TEST URL GET http://localhost:8080/member/modelAttribute?name=tt&id=12
     */
    @GetMapping(value="/member/modelAttribute")
    public String modelAttribute(@ModelAttribute Member member ) {
        System.out.println("@ModelAttribute");
        System.out.println("member.id = " + member.getId());
        System.out.println("member.name = " + member.getName());
        return "modelAttribute";
    }
}
