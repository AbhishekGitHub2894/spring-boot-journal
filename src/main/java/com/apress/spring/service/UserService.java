package com.apress.spring.service;

import com.apress.spring.domain.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {

    public User findOne(BigInteger id);
    public User findByEmail(String email);
    public List<User> findAll();
    public Boolean exists(User user);
    public User save(User user);
    public User update(User user);
    public void delete(BigInteger id);
}
