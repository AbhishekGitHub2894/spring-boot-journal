package com.apress.spring.repository;

import com.apress.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    public User findUserByEmail(String email);
}
