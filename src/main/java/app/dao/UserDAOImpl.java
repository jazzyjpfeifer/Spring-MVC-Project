package app.dao;

import app.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> query = currentSession.createQuery("from User", User.class);

        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public void saveUser(User newUser) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(newUser);
    }

    @Override
    public User getUserById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        User user = currentSession.get(User.class, id);

        return user;
    }

    @Override
    public void deleteUserById(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from User where id=:userId");
        query.setParameter("userId", theId);

        query.executeUpdate();

    }


}
