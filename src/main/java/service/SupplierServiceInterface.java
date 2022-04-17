package service;

import model.Medicine;
import model.User;

import java.util.ArrayList;

public interface SupplierServiceInterface {
    public User personalInformation(String username);
    public ArrayList<Medicine> listMedicineReport(User user);
}
