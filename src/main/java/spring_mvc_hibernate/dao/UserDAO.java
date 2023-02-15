package spring_mvc_hibernate.dao;

import spring_mvc_hibernate.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void add(User user);
    void update(User user);
    void delete(Integer id);
    User getById(Integer id);
}
