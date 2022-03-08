package com.tuanmhoang.springmvc.simplebooking.repository;

import com.tuanmhoang.springmvc.simplebooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
