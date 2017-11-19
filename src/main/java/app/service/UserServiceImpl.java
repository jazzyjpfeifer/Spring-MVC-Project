package app.service;

import app.dao.UserDAO;
import app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void saveUser (User newUser) {
        userDAO.saveUser(newUser);
    }

    @Override
    @Transactional
    public User getUserById (int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUserById (int theId) {
        userDAO.deleteUserById(theId);
    }
}
