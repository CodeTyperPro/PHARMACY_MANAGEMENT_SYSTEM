package controller;

import model.User;
import service.UserService;
import service.XmlReaderService;

public class LoginController {
    public UserService userService;

    public Integer successfulLogin(User user){
        XmlReaderService xmlReaderService = new XmlReaderService();
        userService = new UserService();

        for(User x : userService.listUsers()){
            if(x.getUsername().equals(user.getUsername()) && x.getPassword().equals(user.getPassword())){
                return x.getLevel();
            }
        }

        return -1;
    }
}
