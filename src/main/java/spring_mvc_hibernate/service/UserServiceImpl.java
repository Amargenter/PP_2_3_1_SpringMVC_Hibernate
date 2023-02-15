package spring_mvc_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_mvc_hibernate.dao.UserDAO;
import spring_mvc_hibernate.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl (UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {userDAO.update(user);}

    @Override
    @Transactional
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
