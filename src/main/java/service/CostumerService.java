package service;

import model.Invoice;
import model.User;

import java.util.ArrayList;

public class CostumerService implements CostumerServiceInterface {
    @Override
    public User personalInformation(String username) {
        UserService userService = new UserService();
        for (User user : userService.listUsers()){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public ArrayList<Invoice> listInvoiceReport(User user) {
        ArrayList<Invoice> list = new ArrayList<>();
        for (Invoice invoice : new InvoiceService().listInvoice()){
            if(invoice.getCostumerName().equals(user.getName())){
                list.add(invoice);
            }
        }
        return list;
    }

    @Override
    public Boolean existsCostumer(String name) {
        for (User u : new UserService().listUsers()){
            if(u.getName().equals(name) && u.getLevel() == 2){
                return true;
            }
        }
        return false;
    }
}
