package com.hackathon.wagle.test;

import com.hackathon.wagle.global.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;


@RestController
public class TestController {

    @GetMapping("/test")
    public ApiResponse<Void> test() {
        return ApiResponse.response(OK, "Test 응답에 성공했습니다!");
    }

    @GetMapping("/test1")
    public ApiResponse<TestDto> test1() {
        TestDto response = TestDto.of(1L, "우석", "201935282", "koreaioi@gachon.ac.kr");

        return ApiResponse.response(OK, "Test1 응답에 성공했습니다!", response);
    }

    @GetMapping("/test2")
    public ApiResponse<Void> test2() {

        throw new TestException();
//        return ApiResponse.response(OK, "Test2 응답에 성공했습니다!");
    }

    @GetMapping("/test3")
    public ApiResponse<TestDto> test3(
            @RequestParam String studentNumber
    ) {
        System.out.println(studentNumber);
        TestDto response = TestDto.of(1L, "우석", "201935282", "koreaioi@gachon.ac.kr");

        return ApiResponse.response(OK, "축하합니다", response);
    }

}
