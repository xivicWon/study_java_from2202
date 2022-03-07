package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



// Fake-double : Mock, Stub
@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def" , "10"})
    void testPathVariable(String name) throws Exception {
        //Given
//        String name = "내이름";

        //When
        ResultActions resultActions = mockMvc.perform(get("/demo/path-variable" + "/" + name));

        //Then
        resultActions.andDo(print())
                .andExpect(status().isOk());
        resultActions.andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void testServletParam() throws Exception{

        //Given
        String name = "내이름";
        String email = "catchu87@gmail.com";
        String url = "/demo/servlet-param";
        String urlTemplate = "/demo/servlet-param?" + "name=" + name + "&email=" + email ;

        //When
//        ResultActions resultActions = mockMvc.perform(get(urlTemplate));
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("name" , name);
        queryParams.add("email" , email);
        ResultActions resultActions = mockMvc.perform(get(url).queryParams(queryParams));

        ResultActions resultActions2 = mockMvc.perform(
                get(url).queryParam("name",name)
                        .queryParam("email" , email));

        //Then
        // Http Status 체크
        MvcResult mvc = resultActions.andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // 결과 테스트 체크
        String contentAsString = mvc.getResponse().getContentAsString();
        Assertions.assertThat(contentAsString).isEqualTo("Ok");
    }


    @Test
    void testRequestParam() throws Exception{

        //Given
        String name = "내이름";
        String email = "catchu87@gmail.com";
        String url = "/demo/request-param";
        String urlTemplate = "/demo/servlet-param?" + "name=" + name + "&email=" + email ;

        //When
//        ResultActions resultActions = mockMvc.perform(get(urlTemplate));

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("name" , name);
        queryParams.add("email" , email);
        ResultActions resultActions = mockMvc.perform(get(url).queryParams(queryParams));

        ResultActions resultActions2 = mockMvc.perform(
                get(url).queryParam("name",name)
                        .queryParam("email" , email));

        //Then
        // Http Status 체크
        MvcResult mvc = resultActions.andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // 결과 테스트 체크
        String contentAsString = mvc.getResponse().getContentAsString();
        Assertions.assertThat(contentAsString).isEqualTo("Ok");
    }

    @Test
    @DisplayName("email 파라미터 없이 호출하는 경우")
    void testRequestParamFail() throws Exception{

        //Given
        String name = "내이름";
        String url = "/demo/request-param";

        //When
//        ResultActions resultActions = mockMvc.perform(get(urlTemplate));

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("name" , name);
        ResultActions resultActions = mockMvc.perform(get(url).queryParams(queryParams));

        ResultActions resultActions2 = mockMvc.perform(
                get(url).queryParam("name",name));

        //Then
        // Http Status 체크
        MvcResult mvc = resultActions.andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();

        // 결과 테스트 체크
        String contentAsString = mvc.getResponse().getContentAsString();
        Assertions.assertThat(contentAsString).isEqualTo("Ok");
    }


    @Test
    @DisplayName("email 파라미터 없이 호출하는 경우")
    void testModelAttribute() throws Exception{

        //Given
        String name = "내이름";
        String email = "catchu87@gmail.com";
        String url = "/demo/model-attribute";

        //When
        ResultActions resultActions2 = mockMvc.perform(
                get(url).queryParam("name",name)
                        .queryParam("email",email));

        //Then
        // Http Status 체크
        MvcResult mvc = resultActions2.andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // 결과 테스트 체크
        String contentAsString = mvc.getResponse().getContentAsString();
        Assertions.assertThat(contentAsString).isEqualTo("Ok");
    }


    @Test
    @DisplayName("requestBody - string")
    void testRequestBodyString() throws Exception{

        //Given
        String string = "내이름";
        String url = "/demo/request-body/string";

        //When
        ResultActions resultActions = mockMvc.perform(
                post(url).content(string));

        //Then
        // Http Status 체크
        MvcResult mvc = resultActions.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("requestBody - parameter")
    void testRequestBodyParameter() throws Exception{

        //Given
        String name = "내이름";
        String email = "catchu87@gmail.com";
        String url = "/demo/request-body/parameter";
        String content = "name="+name + "&email=" + email;

        //When
        ResultActions resultActions = mockMvc.perform(
                post(url).content(content)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED));

        //Then
        // Http Status 체크
        MvcResult mvc = resultActions.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("requestBody - object")
    void testRequestBodyObject() throws Exception{

        //Given
        String name = "내이름";
        String email = "catchu87@gmail.com";
        String url = "/demo/request-body/object";

        MemberDto memberDto = new MemberDto();
        memberDto.setName( name );
        memberDto.setEmail( email );

        //objectMapper.writeValueAsString : Object To String
        String string = objectMapper.writeValueAsString(memberDto);

        //When
        ResultActions resultActions = mockMvc.perform(
                post(url).content(string)
                        .contentType(MediaType.APPLICATION_JSON));

        //Then
        // Http Status 체크
        MvcResult mvc = resultActions.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}


