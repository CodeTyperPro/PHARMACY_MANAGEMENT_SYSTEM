package service;

import model.User;

import java.util.ArrayList;

public interface UserServiceInterface {
    public Boolean addUser(User user);
    public Boolean deleteUser(String username);
    public Boolean updateUser(String username, User user);
    public ArrayList<User> listUsers();
    public Boolean existsUser(String username);
    public String generatePassword(int len);
    public ArrayList<User> getUserInformation(User user);
    public User getUserInformation(String username);
}
