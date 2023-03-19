package com.epam.jmp.service;

import com.epam.jmp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(long userId);

    User save(User user);

    void delete(long userId);
}
