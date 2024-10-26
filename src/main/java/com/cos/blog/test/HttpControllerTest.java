package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController // 데이터 그 자체를 반환하는 컨트롤러
public class HttpControllerTest {

    // localhost:8080/http/~

    // 브라우저를 통한 요청은 get만 가능하다
    @GetMapping("/http/get")
    public String getTest(Member member) {
        return "get request"+ " " + member.getId() + ", " + member.getUsername();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member member) {
        return "post request"+ " " + member.getId() + ", " + member.getUsername();
    }

    @PutMapping("/http/put")
    public String putTest() {
        return "put request";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete request";
    }
}
