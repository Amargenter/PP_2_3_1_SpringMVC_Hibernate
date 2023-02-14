package spring_mvc_hibernate.dao;

import org.springframework.stereotype.Service;
import spring_mvc_hibernate.model.User;

import javax.persistence.*;
import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
    @Override
    public void add(User user) {

        if (user.getId() == null) {
        em.persist(user);
        em.flush();
        } else {
            em.merge(user);
            em.flush();
        }
    }

    @Override
    public void delete(Integer id) {
        User user = em.find(User.class, id);
        em.remove(user);
        em.flush();
    }

    @Override
    public User getById(Integer id) {
        return em.find(User.class, id);
    }
}
