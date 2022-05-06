package service;

import model.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

import java.util.ArrayList;

public class XmlReaderService implements XmlReaderServiceInterface{
    private final String userPath = "src/main/resources/users.xml";
    private final String costumerPath = "src/main/resources/costumers.xml";
    private final String supplierPath = "src/main/resources/suppliers.xml";
    private final String medicinesPath = "src/main/resources/medicines.xml";
    private final String invoicesPath = "src/main/resources/invoices.xml";

    @Override
    public Boolean existsUserXML() {
        File file = new File(userPath);
        return file.exists();
    }


    @Override
    public Boolean existsMedicinesXML() {
        File file = new File(medicinesPath);
        return file.exists();
    }

    @Override
    public Boolean existsInvoicesXML() {
        File file = new File(invoicesPath);
        return file.exists();
    }

    @Override
    public Boolean createUserXML() {
        if(!existsUserXML()){
            File file = new File(userPath);
            try {
                if(file.createNewFile()){
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public Boolean createMedicinesXML() {
        if(!existsUserXML()){
            File file = new File(medicinesPath);
            try {
                if(file.createNewFile()){
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean createInvoicesXML() {
        if(!existsUserXML()){
            File file = new File(invoicesPath);
            try {
                if(file.createNewFile()){
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ArrayList<User> readUsers() {
        ArrayList<User> users = new ArrayList<>();

        if(existsUserXML()){
            File file = new File(userPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                Element rootElement = document.getDocumentElement();

                NodeList nodeList = rootElement.getChildNodes();
                Node node;
                for (int i = 0; i<nodeList.getLength(); i++){
                    node = nodeList.item(i);

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        User user = new User();
                        for (int j = 0; j< childNodesOfUserTag.getLength(); j++){
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if(childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){
                                switch (childNodeOfUserTag.getNodeName()){
                                    case "name" -> user.setName(childNodeOfUserTag.getTextContent());
                                    case "username" -> user.setUsername(childNodeOfUserTag.getTextContent());
                                    case "password" -> user.setPassword(childNodeOfUserTag.getTextContent());
                                    case "level" -> user.setLevel(Integer.parseInt(childNodeOfUserTag.getTextContent()));
                                }
                            }
                        }

                        users.add(user);
                    }
                }
            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }
        } else{
            if(createUserXML()){
                readUsers();
            } else {
                return null;
            }
        }

        return users;
    }

    @Override
    public ArrayList<Medicine> readMedicines() {
        ArrayList<Medicine> medicines = new ArrayList<>();

        if(existsMedicinesXML()){
            File file = new File(medicinesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                Element rootElement = document.getDocumentElement();

                NodeList nodeList = rootElement.getChildNodes();
                Node node;
                for (int i = 0; i<nodeList.getLength(); i++){
                    node = nodeList.item(i);

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        Medicine medicine = new Medicine();
                        for (int j = 0; j< childNodesOfUserTag.getLength(); j++){
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if(childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){
                                switch (childNodeOfUserTag.getNodeName()){
                                    case "name" -> medicine.setName(childNodeOfUserTag.getTextContent());
                                    case "supplier" -> medicine.setSupplier(childNodeOfUserTag.getTextContent());
                                    case "price" -> medicine.setPrice(Double.parseDouble(childNodeOfUserTag.getTextContent()));
                                    case "quantity" -> medicine.setQuantity(Integer.parseInt(childNodeOfUserTag.getTextContent()));
                                }
                            }
                        }

                        medicines.add(medicine);
                    }
                }
            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }
        } else{
            if(createMedicinesXML()){
                readMedicines();
            } else {
                return null;
            }
        }

        return medicines;
    }

    @Override
    public ArrayList<Invoice> readInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<>();

        if(existsInvoicesXML()){
            File file = new File(invoicesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                Element rootElement = document.getDocumentElement();

                NodeList nodeList = rootElement.getChildNodes();
                Node node;
                for (int i = 0; i<nodeList.getLength(); i++){
                    node = nodeList.item(i);

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        Invoice invoice = new Invoice();
                        for (int j = 0; j < childNodesOfUserTag.getLength(); j++){
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if(childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){
                                switch (childNodeOfUserTag.getNodeName()){
                                    case "id" -> invoice.setId(Integer.parseInt(childNodeOfUserTag.getTextContent()));
                                    case "costumerName" -> invoice.setCostumerName(childNodeOfUserTag.getTextContent());
                                    case "medicineName" -> invoice.setMedicineName(childNodeOfUserTag.getTextContent());
                                    case "quantity" -> invoice.setQuantity(Integer.parseInt(childNodeOfUserTag.getTextContent()));
                                    case "totalPrice" -> invoice.setTotalPrice(Double.parseDouble(childNodeOfUserTag.getTextContent()));
                                    case "date" -> invoice.setDate(childNodeOfUserTag.getTextContent());
                                }
                            }
                        }

                        invoices.add(invoice);
                    }
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        } else{
            if(createInvoicesXML()){
                readInvoices();
            } else {
                return null;
            }
        }

        return invoices;
    }
}
