package com.dao;

import com.model.User;

import java.util.List;

public interface UserDAO {
    User getById(int id);
    User getByLogin(String login);
    boolean save(User user);
    boolean update(User user);
    List<User> list();
}