package service;

import model.Invoice;
import model.Medicine;
import model.User;

import java.util.ArrayList;

public class MedicineService implements MedicineServiceInterface{
    private ArrayList<Medicine>  medicines = null;

    public MedicineService() {
        this.medicines = new XmlReaderService().readMedicines();
    }

    @Override
    public Boolean addMedicine(Medicine medicine) {
        if(medicine.getQuantity()<0)
            medicine.setQuantity(0);
        if(medicine.getPrice()<0.0)
            medicine.setPrice(0.0);

        if(!existsMedicine(medicine.getName()))
            return new XmlWriterService().addMedicineXML(medicine);
        return false;
    }

    @Override
    public Boolean deleteMedicine(String username) {
        return new XmlWriterService().deleteMedicineXML(username);
    }

    @Override
    public Boolean updateMedicine(String name, Medicine medicine) {
        if(existsMedicine(name))
            return new XmlWriterService().updateMedicineXML(name, medicine);
        return false;
    }

    @Override
    public ArrayList<Medicine> listMedicines() {
        medicines = new XmlReaderService().readMedicines();
        return this.medicines;
    }

    @Override
    public Boolean existsMedicine(String name) {
        for (Medicine m : medicines){
            if(m.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Double priceMedicine(String name) {
        for (Medicine m : medicines){
            if(m.getName().equals(name)){
                return m.getPrice();
            }
        }
        return -1.0;
    }

    @Override
    public ArrayList<Medicine> listMedicinesSupplier(String name) {
        medicines = new XmlReaderService().readMedicines();
        ArrayList<Medicine> list = new ArrayList<>();
        for (Medicine m : medicines){
            if(m.getSupplier().equals(name)){
                list.add(m);
            }
        }
        return list;
    }
}
