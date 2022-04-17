package service;

import model.Medicine;
import java.util.ArrayList;

public interface MedicineServiceInterface {
    public Boolean addMedicine(Medicine medicine);
    public Boolean deleteMedicine(String name);
    public Boolean updateMedicine(String name, Medicine medicine);
    public ArrayList<Medicine> listMedicines();
    public Boolean existsMedicine(String name);
    public Double priceMedicine(String name);
    public ArrayList<Medicine> listMedicinesSupplier(String name);
}
