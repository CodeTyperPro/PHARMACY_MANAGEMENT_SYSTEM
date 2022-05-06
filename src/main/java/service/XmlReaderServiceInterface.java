package service;

import model.*;

import java.util.ArrayList;

public interface XmlReaderServiceInterface {
    public Boolean existsUserXML();
    public Boolean existsMedicinesXML();
    public Boolean existsInvoicesXML();

    public Boolean createUserXML();
    public Boolean createMedicinesXML();
    public Boolean createInvoicesXML();

    public ArrayList<User> readUsers();
    public ArrayList<Medicine> readMedicines();
    public ArrayList<Invoice> readInvoices();
}
