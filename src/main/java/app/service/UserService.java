package app.service;

import app.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void saveUser (User newUser);

    public User getUserById (int id);

    public void deleteUserById (int theId);
}
