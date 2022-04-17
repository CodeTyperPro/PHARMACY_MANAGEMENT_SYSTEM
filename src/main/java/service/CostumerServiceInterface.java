package service;

import model.Invoice;
import model.Medicine;
import model.User;

import java.util.ArrayList;

public interface CostumerServiceInterface {
    public User personalInformation(String username);
    public ArrayList<Invoice> listInvoiceReport(User user);
    public Boolean existsCostumer(String username);
}
