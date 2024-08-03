package com.example.kata.service;

import com.example.kata.dao.UserDAOInterface;
import com.example.kata.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class UserService implements UserServiceInterface {

    private final UserDAOInterface userDAO;

    @Autowired
    public UserService(UserDAOInterface userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getThemAll() {
        return userDAO.getThemAll();
    }

    @Override
    public User getThemById(Long id) {
        return userDAO.getThemById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(User updatedUser) {
        userDAO.update(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
