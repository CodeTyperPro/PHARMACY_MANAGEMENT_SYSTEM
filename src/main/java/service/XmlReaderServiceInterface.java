package service;

import model.*;

import java.util.ArrayList;

public interface XmlReaderServiceInterface {
    public Boolean existsUserXML();
    public Boolean existsCostumersXML();
    public Boolean existsSuppliersXML();
    public Boolean existsMedicinesXML();
    public Boolean existsInvoicesXML();

    public Boolean createUserXML();
    public Boolean createCostumersXML();
    public Boolean createSuppliersXML();
    public Boolean createMedicinesXML();
    public Boolean createInvoicesXML();

    public ArrayList<User> readUsers();
    public ArrayList<Costumer> readCostumers();
    public ArrayList<Supplier> readSuppliers();
    public ArrayList<Medicine> readMedicines();
    public ArrayList<Invoice> readInvoices();
}
