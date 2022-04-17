package service;

import model.Invoice;
import model.Medicine;
import model.User;

import java.util.ArrayList;

public class SupplierService implements SupplierServiceInterface{
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
    public ArrayList<Medicine> listMedicineReport(User user) {
        ArrayList<Medicine> list = new ArrayList<>();
        for (Medicine medicine : new MedicineService().listMedicines()){
            if(medicine.getSupplier().equals(user.getName())){
                list.add(medicine);
            }
        }
        return list;
    }
}
