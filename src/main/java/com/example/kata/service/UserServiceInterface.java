package com.example.kata.service;

import com.example.kata.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getThemAll();

    User getThemById(Long id);

    void save(User user);

    void update(User updatedUser);

    void delete(Long id);
}
