package service;

import model.Invoice;
import model.Medicine;
import model.User;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class XmlWriterService implements XmlWriterServiceInterface{
    private final String userPath = "src/main/resources/users.xml";
    private final String costumerPath = "src/main/resources/costumers.xml";
    private final String supplierPath = "src/main/resources/suppliers.xml";
    private final String medicinesPath = "src/main/resources/medicines.xml";
    private final String invoicesPath = "src/main/resources/invoices.xml";

    @Override
    public Boolean addUserXML(User user) {
        XmlReaderService xmlReaderService = new XmlReaderService();
        if(xmlReaderService.existsUserXML()){
            File file = new File(userPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                //root element
                Element rootElement = document.getDocumentElement();

                //supper user element
                Element superuser = document.createElement("user");
                rootElement.appendChild(superuser);

                // setting attribute to element
                Element element_name = document.createElement("name");
                element_name.appendChild(document.createTextNode(user.getName()));
                superuser.appendChild(element_name);

                Element element_username = document.createElement("username");
                element_username.appendChild(document.createTextNode(user.getUsername()));
                superuser.appendChild(element_username);

                Element element_password = document.createElement("password");
                element_password.appendChild(document.createTextNode(user.getPassword()));
                superuser.appendChild(element_password);

                Element element_level = document.createElement("level");
                element_level.appendChild(document.createTextNode(String.valueOf(user.getLevel())));
                superuser.appendChild(element_level);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");


                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                return true;
            } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
                e.printStackTrace();
            }
        } else{
            if(xmlReaderService.createUserXML()){
                addUserXML(user);
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean deleteUserXML(String username) {
        XmlReaderService service = new XmlReaderService();
        if(service.existsUserXML()){
            File file = new File(userPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                Element rootElement = document.getDocumentElement();

                NodeList nodeList = rootElement.getChildNodes();
                Node node;
                int index = -1;
                for (int i = 0; i<nodeList.getLength(); i++){
                    node = nodeList.item(i);

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        for (int j = 0; j< childNodesOfUserTag.getLength(); j++){
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if(childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){
                                if(childNodeOfUserTag.getNodeName().equals("username")){
                                    if(childNodeOfUserTag.getTextContent().equals(username)){
                                        index = i;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if(index!=-1){
                    rootElement.removeChild(nodeList.item(index));
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();

                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(file);
                    transformer.transform(source, result);

                    return true;
                } else
                    return false;
            } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }

        } else{
            if(service.createUserXML()){
                service.readUsers();
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean updateUserXML(String username, User user) {
        XmlReaderService service = new XmlReaderService();
        if(service.existsUserXML()){
            File file = new File(userPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                Element rootElement = document.getDocumentElement();

                NodeList nodeList = rootElement.getChildNodes();
                Node node;

                for (int i = 0; i<nodeList.getLength(); i++) {
                    node = nodeList.item(i);

                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        for (int j = 0; j < childNodesOfUserTag.getLength(); j++) {
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if (childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE) {
                                if (childNodeOfUserTag.getTextContent().equals(username)) {

                                    if (!user.getUsername().isEmpty() && "username".equals(childNodeOfUserTag.getNodeName())) {
                                        childNodeOfUserTag.setTextContent(user.getUsername());
                                    }

                                    if (!user.getName().isEmpty() && "name".equals(childNodeOfUserTag.getNodeName())) {
                                        childNodeOfUserTag.setTextContent(user.getName());
                                    }

                                    if (!user.getPassword().isEmpty() && "password".equals(childNodeOfUserTag.getNodeName())) {
                                        childNodeOfUserTag.setTextContent(user.getPassword());
                                    }

                                    if (user.getLevel() != 0 && "level".equals(childNodeOfUserTag.getNodeName())) {
                                        childNodeOfUserTag.setTextContent(String.valueOf(user.getLevel()));
                                    }
                                }
                            }
                        }
                    }
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                return true;
            } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
                e.printStackTrace();
            }
        } else{
            if(service.createUserXML()){
                service.readUsers();
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean addMedicineXML(Medicine medicine) {
        XmlReaderService xmlReaderService = new XmlReaderService();
        if(xmlReaderService.existsUserXML()){
            File file = new File(medicinesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                //root element
                Element rootElement = document.getDocumentElement();

                //supper user element
                Element superuser = document.createElement("medicine");
                rootElement.appendChild(superuser);

                // setting attribute to element
                Element element_name = document.createElement("name");
                element_name.appendChild(document.createTextNode(medicine.getName()));
                superuser.appendChild(element_name);

                Element element_supplier = document.createElement("supplier");
                element_supplier.appendChild(document.createTextNode(medicine.getSupplier()));
                superuser.appendChild(element_supplier);

                Element element_price = document.createElement("price");
                element_price.appendChild(document.createTextNode(medicine.getSupplier()));
                superuser.appendChild(element_price);

                Element element_quantity = document.createElement("quantity");
                element_quantity.appendChild(document.createTextNode(String.valueOf(medicine.getQuantity())));
                superuser.appendChild(element_quantity);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                return true;
            } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
                e.printStackTrace();
            }
        } else{
            if(xmlReaderService.createUserXML()){
                addMedicineXML(medicine);
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean deleteMedicineXML(String name) {
        XmlReaderService service = new XmlReaderService();
        if(service.existsUserXML()){
            File file = new File(medicinesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                Element rootElement = document.getDocumentElement();

                NodeList nodeList = rootElement.getChildNodes();
                Node node;
                int index = -1;
                for (int i = 0; i<nodeList.getLength(); i++){
                    node = nodeList.item(i);

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        for (int j = 0; j< childNodesOfUserTag.getLength(); j++){
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if(childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){
                                if(childNodeOfUserTag.getNodeName().equals("name")){
                                    if(childNodeOfUserTag.getTextContent().equals(name)){
                                        index = i;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if(index!=-1){
                    rootElement.removeChild(nodeList.item(index));
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();

                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(file);
                    transformer.transform(source, result);

                    return true;
                } else
                    return false;
            } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }

        } else{
            if(service.createMedicinesXML()){
                service.readMedicines();
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean updateMedicineXML(String name, Medicine medicine) {
        XmlReaderService service = new XmlReaderService();
        if(service.existsUserXML()){
            File file = new File(medicinesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                NodeList medList = document.getElementsByTagName("medicine");
                Element med = null;
                // loop for each medicine
                for (int i = 0; i < medList.getLength(); i++) {
                    med = (Element) medList.item(i);
                    if(med.getElementsByTagName("name").item(0).getTextContent().equals(name)){

                        Node name_medicine = med.getElementsByTagName("name").item(0).getFirstChild();
                        name_medicine.setNodeValue(medicine.getName());

                        Node supplier_medicine = med.getElementsByTagName("supplier").item(0).getFirstChild();
                        supplier_medicine.setNodeValue(medicine.getSupplier());

                        Node price_medicine = med.getElementsByTagName("price").item(0).getFirstChild();
                        price_medicine.setNodeValue(String.valueOf(medicine.getPrice()));

                        Node quantity_medicine = med.getElementsByTagName("quantity").item(0).getFirstChild();
                        quantity_medicine.setNodeValue(String.valueOf(medicine.getQuantity()));
                    }
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                return true;

            } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }

        } else{
            if(service.createMedicinesXML()){
                service.readMedicines();
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean addInvoiceXML(Invoice invoice) {
        XmlReaderService xmlReaderService = new XmlReaderService();
        if(xmlReaderService.existsInvoicesXML()){
            File file = new File(invoicesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                //root element
                Element rootElement = document.getDocumentElement();

                //supper user element
                Element superuser = document.createElement("invoice");
                rootElement.appendChild(superuser);

                // setting attribute to element
                Element element_id = document.createElement("id");
                element_id.appendChild(document.createTextNode(String.valueOf(invoice.getId())));
                superuser.appendChild(element_id);

                Element element_costumerName = document.createElement("costumerName");
                element_costumerName.appendChild(document.createTextNode(invoice.getCostumerName()));
                superuser.appendChild(element_costumerName);

                Element element_medicineName = document.createElement("medicineName");
                element_medicineName.appendChild(document.createTextNode(invoice.getMedicineName()));
                superuser.appendChild(element_medicineName);

                Element element_quantity = document.createElement("quantity");
                element_quantity.appendChild(document.createTextNode(String.valueOf(invoice.getQuantity())));
                superuser.appendChild(element_quantity);

                Element element_totalPrice = document.createElement("totalPrice");
                element_totalPrice.appendChild(document.createTextNode(String.valueOf(invoice.getTotalPrice())));
                superuser.appendChild(element_totalPrice);

                Element element_date = document.createElement("date");
                element_date.appendChild(document.createTextNode(String.valueOf(invoice.getDate())));
                superuser.appendChild(element_date);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                return true;
            } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
                e.printStackTrace();
            }
        } else{
            if(xmlReaderService.createInvoicesXML()){
                addInvoiceXML(invoice);
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean deleteInvoiceXML(Integer id) {
        XmlReaderService service = new XmlReaderService();
        if(service.existsInvoicesXML()){
            File file = new File(invoicesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                Element rootElement = document.getDocumentElement();

                NodeList nodeList = rootElement.getChildNodes();
                Node node;
                int index = -1;
                for (int i = 0; i<nodeList.getLength(); i++){
                    node = nodeList.item(i);

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        for (int j = 0; j< childNodesOfUserTag.getLength(); j++){
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if(childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){
                                if(childNodeOfUserTag.getNodeName().equals("id")){
                                    if(childNodeOfUserTag.getTextContent().equals(String.valueOf(id))){
                                        index = i;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if(index!=-1){
                    rootElement.removeChild(nodeList.item(index));
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();

                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(file);
                    transformer.transform(source, result);

                    return true;
                } else
                    return false;
            } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }

        } else{
            if(service.createMedicinesXML()){
                service.readMedicines();
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean updateInvoiceXML(Integer id, Invoice invoice) {
        XmlReaderService service = new XmlReaderService();
        if(service.existsUserXML()){
            File file = new File(invoicesPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                NodeList medList = document.getElementsByTagName("invoice");
                Element med = null;
                // loop for each medicine
                for (int i = 0; i < medList.getLength(); i++) {
                    med = (Element) medList.item(i);
                    if(Integer.parseInt(med.getElementsByTagName("id").item(0).getTextContent()) == id){

                        Node name_costumerName = med.getElementsByTagName("costumerName").item(0).getFirstChild();
                        name_costumerName.setNodeValue(invoice.getCostumerName());

                        Node name_medicine = med.getElementsByTagName("medicineName").item(0).getFirstChild();
                        name_medicine.setNodeValue(invoice.getMedicineName());

                        Node quantity = med.getElementsByTagName("quantity").item(0).getFirstChild();
                        quantity.setNodeValue(String.valueOf(invoice.getQuantity()));

                        Node price_medicine = med.getElementsByTagName("totalPrice").item(0).getFirstChild();
                        price_medicine.setNodeValue(String.valueOf(invoice.getTotalPrice()));

                        Node quantity_medicine = med.getElementsByTagName("date").item(0).getFirstChild();
                        quantity_medicine.setNodeValue(String.valueOf(invoice.getDate()));
                    }
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                return true;

            } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }

        } else{
            if(service.createMedicinesXML()){
                service.readMedicines();
            } else {
                return false;
            }
        }

        return false;
    }
}