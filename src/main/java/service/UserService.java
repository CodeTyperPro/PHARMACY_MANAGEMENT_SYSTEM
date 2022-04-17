package service;

import model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import view.Login;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Random;

public class UserService implements UserServiceInterface{
    private ArrayList<User> users = null;

    public UserService() {
        this.users = new XmlReaderService().readUsers();
    }

    @Override
    public Boolean addUser(User user) {
        if(!existsUser(user.getUsername()))
            return new XmlWriterService().addUserXML(user);
        return false;
    }

    @Override
    public Boolean deleteUser(String username) {
        if(!username.equals(Login.active_user.getUsername()))
            return new XmlWriterService().deleteUserXML(username);
        return false;
    }

    @Override
    public Boolean updateUser(String username, User user) {
        return new XmlWriterService().updateUserXML(username, user);
    }

    @Override
    public ArrayList<User> listUsers() {
        users = new XmlReaderService().readUsers();
        return this.users;
    }

    @Override
    public Boolean existsUser(String username) {
        for (User u : users){
            if(u.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String generatePassword(int len) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[len];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< len ; i++) {
                password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        String str = password.toString();

        return str;
    }

    @Override
    public ArrayList<User> getUserInformation(User user) {
        ArrayList<User> list = new ArrayList<>();
        for (User u : users){
            if(u.getUsername().equals(user.getUsername())){
                list.add(u);
            }
        }
        return list;
    }

    @Override
    public User getUserInformation(String username) {
        for (User u : users){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
}
