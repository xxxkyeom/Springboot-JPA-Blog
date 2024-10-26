package com.cos.blog.test;

import com.cos.blog.domain.Role;
import com.cos.blog.domain.User;
import com.cos.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
// @DynamicInsert
public class DummyControllerTest {

    private final UserRepository userRepository;
    // 폼 타입은 그냥 이름에 맞게 받아진다. 규칙이니 의문 가지지 말 것
    @PostMapping("/dummy/join")
    public String join(@RequestBody User user) {
        System.out.println("id : " + user.getId());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("created at: " + user.getCreatedAt());

        //user.setRole(Role.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다";
    }
}
