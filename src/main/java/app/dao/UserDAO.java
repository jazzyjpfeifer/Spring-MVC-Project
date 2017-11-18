package app.dao;

import app.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUsers();

    public void saveUser (User newUser);

}
