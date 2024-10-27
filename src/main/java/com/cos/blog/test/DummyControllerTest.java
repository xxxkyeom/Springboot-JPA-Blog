package com.cos.blog.test;

import com.cos.blog.domain.User;
import com.cos.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/dummy/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        // null이 반환될 수도 있으니 optional로 받아서 처리
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not exist user"));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/dummy/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<User> users = userRepository.findAll(pageable).getContent();
        return users;
    }

    // @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable

    // Page<User> page = userRepository.findAll(PageRequest.of(1, 10, Sort.by("id").descending()));

    @Transactional
    @PutMapping("/dummy/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not exist user"));
        findUser.setPassword(user.getPassword());
        findUser.setEmail(user.getEmail());

        // save 호출하지 않고 더티 체킹, 영속성 컨텍스트에 의해 자동 update 쿼리 실행
        return ResponseEntity.ok().body(findUser);
    }
}
