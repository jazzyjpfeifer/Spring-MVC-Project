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


}
