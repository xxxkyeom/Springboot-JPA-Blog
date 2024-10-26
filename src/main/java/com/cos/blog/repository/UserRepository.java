package com.cos.blog.repository;

import com.cos.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 빈 자동 등록
public interface UserRepository extends JpaRepository<User, Integer> {
}
