package com.atguigu.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atguigu.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
