package com.cos.blog.test;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
    private int id;
    private String username;
    private String password;
    private String email;
}
