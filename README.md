# PHARMACY MANAGEMENT SYSTEM

The PHARMACY MANAGEMENT SYSTEM is a console system that organizes and manages the medicinal use process in pharmacies by storing data, transcripting and enabling functionality.
Developed using `JAVA` programming language, Pharmacy management system is an offline application that uses `XML` as the database. 

### Purpose:

Technology has improved immensely in recent days. Improving the quality of one’s life is an important benefit of technology in healthcare. Besides, it also reduces the burden of staff in the hospital and improves the health of the patient easily and efficiently.
The purpose of this console-based system is to improve the eficiency regardign to the produtivy in Pharmacies of Medical stores. With this system, the entire operations in medical store is fully automated. Unlike the traditional system where records were maintained manually, this system maintains records in a database. Typical example of these records include purchases, counter sales, staffs, suppliers, customers, customers, etc.

### Users of the system:

Listed below are the main users of the system. They are required to register into the system to access records and details stored in the database. Only the Pharmacist has the privilege or access over all records and users. The system access to other users in restricted as per their functions in the medical store.

User Pharmacist
User Costumer
User Supplier

### Table Content
1. [Workplace](#workplace)
2. [How to use the project](#how-to-use-the-project)
3. [Project Structure](#project-structure)
4. [Main Classes](#main-classes)
5. [List of forms](#list-of-forms)
6. [List of XML files](#list-of-xml-files)
7. [License](#license)
8. [Author Info](#author-info)

---

## Workplace

* Download and install the latest JDK: https://www.oracle.com/java/technologies/downloads/

  - Set environment parameters:
    - On Windows in Commandline:
      - set JAVA_HOME=C:\Program Files\Java\jdk-17.0.2
      - set PATH=%JAVA_HOME%\bin;%PATH%
    - On Linux in Terminal:
      - export JAVA_HOME=/opt/jdk-17.0.2
      - export PATH=$JAVA_HOME/bin:$PATH
* Download and install Git: https://git-scm.com/download/win
* Download and install Maven (Binary): https://maven.apache.org/download.cgi
* Unzip it into your Java directory
* Download and install IntelliJ IDEA: https://www.jetbrains.com/idea/download/#section=windows

* Clone this repository:
  - Click on green Clone button
  - Copy the URL
  - Start IntelliJ IDEA
  - Select File / New / Project from Version Control...
  - Enter the URL
  - Click on Clone button
  - Register on https://github.com/

* In IntelliJ:
  - Select File / Settings...
  - Select Version Control / GitHub on the left
  - Click on Add... icon
  - Select Log In via GitHub... option
  - Click on Authorize in GitHub button

---
## How to use the project
Run the `main()` method on `main.class` pressing: Shift + F10.

![image](https://user-images.githubusercontent.com/34483729/163723638-9d12f94f-f3e1-4a93-b6e5-c969def15ec0.png)

See the ilustrations to have a nice overview to what to expect on [List of forms](#list-of-forms)
User `username: codetyperpro` and `password:[e@5b35e0d2`.

Based on acess level, you can be redirected to `3` possible screens after log in:
- [Main Menu Costumer](#main-menu-costumer)
- [Main Menu Supplier](#main-menu-supplier)
- [Main Menu Pharmacist](#main-menu-pharmacist)

What would you like to do?
- [Order a new medicine](#order-a-new-medicine)
- [Add new user](#add-new-user)
- [List invoices](#list-invoices)
- [More ...](#more)

---
## Project Structure
* pom.xml
* README.md : github documentation of the project.
* src
  * main
    * java: source-code of the application
      * controller
        - LoginController.class
          - public Integer successfulLogin(User user): check if the logging was sucessiful.
      * model
        - Invoice.class
          - Invoice(): empty constructor the invoice class.
          - Invoice(Integer id, String costumerName, String medicineName, Integer quantity, Double discount, Double totalPrice, String date): invoice constructor to fill information required by the class.
          - Integer getId(): allow the program to get invoice id outside of the class.
          - void setId(Integer id): allow the program to set invoice id outside of the class.
          - String getCostumerName(): return user's name related to the invoice.
          - void setCostumerName(String costumerName): set user's name related to the invoice.
          - String getMedicineName(): return medicine's name related to the invoice.
          - void setMedicineName(String medicineName): set medicine's name related to the invoice.
          - Integer getQuantity(): return the quantity of medicines to sell.
          - void setQuantity(Integer quantity): set the quantity of medicines to sell.
          - Double getTotalPrice(): calculate and return the total price of the invoice.
          - void setTotalPrice(Double totalPrice): set the total price of the invoice.
          - String getDate(): return the date of the sell.
          - void setDate(): set the date of the sell.
        - Medicine.class
          - Medicine(): empty constructor the medicine class.
          - String getName(): allow the program to get the name outside of the class.
          - void setName(String name):
          - String getSupplier(): allow the program to get the supplier outside of the class.
          - void setSupplier(String supplier): allow the program to set the supplier outside of the class.
          - Double getPrice(): allow the program to get the price outside of the class.
          - void setPrice(Double price): allow the program to set the price outside of the class.
          - Integer getQuantity(): allow the program to return the quantity of the medicines outside of the class.
          - void setQuantity(Integer quantity): allow the program to set the quantity of the medicines outside of the class.
          - Medicine(String name, String supplier, Double price, Integer quantity): constuctor of the medicine class.
        - User.class
          - String getName(): allow the program to get the name outside of the class.
          - void setName(String name):
          - String getUsername():  allow the program to get the username outside of the class.
          - void setUsername(String username):
          - String getPassword(): allow the program to get the password outside of the class.
          - void setPassword(String password): allow the program to set the password outside of the class.
          - Integer getLevel(): allow the program to get the level of the user outside of the class.
          - setLevel(Integer level): allow the program to set the level outside of the class.
          - public String toString(): return user informations.
      * service
        - CostumerService.class
          - User personalInformation(String username): return the information of the user with that passed username if it exists.
          - ArrayList<Invoice> listInvoiceReport(User user): list the invoices related to the user.
          - Boolean existsCostumer(String username): check if the costumer with that username exists actually.
        - CostumerServiceInterface.class
        - InvoiceService.class 
          - Boolean addInvoice(Invoice invoice): append new medicine in the xml file.
          - Boolean deleteInvoice(Integer id): delete medicine in the xml file.
          - ArrayList<Invoice> listInvoice(): list the invoices stored in the xml file.
          - Boolean updateInvoice(Integer id, Invoice invoice): update medicine in the xml file.
          - Boolean existsInvoice(Integer id): check if the id already exist in the database (xml).
          - Double getTotalPrice(String medicine, Integer quantity): caculate the total price.
          - String medicineInvoice(Integer id): return the name of the medicine with that id.
          - ArrayList<Invoice> listInvoiceCostumer(String name): list all the invoices related to the costumer.
          - Integer getLastIdInvoice(): find the last id number to set the next to the new item. Like, if the last stored is 10, the new will be 11.
        - InvoiceServiceInterface.class
        - MedicineService.class
          - Boolean addMedicine(Medicine medicine):  append new medicine in the xml file.
          - Boolean deleteMedicine(String name): delete medicine in the xml file.
          - Boolean updateMedicine(String name, Medicine medicine): update medicine in the xml file.
          - ArrayList<Medicine> listMedicines(): list the medicines stored in the xml file.
          - Boolean existsMedicine(String name): check if the name already exist in the database (xml).
          - Double priceMedicine(String name): calculate the price of the medicine.
          - ArrayList<Medicine> listMedicinesSupplier(String name): list all the medicines provided by the supplier <name>.
        - MedicineServiceInterface.class
        - SupplierService.class 
          - ArrayList<Medicine> listMedicineReport(User user):
        - SupplierServiceInterface.class
        - UserService.class
          - Boolean addUser(User user): append new user in the xml file.
          - Boolean deleteUser(String username): delete user in the xml file.
          - Boolean updateUser(String username, User user): update user in the xml file.
          - ArrayList<User> listUsers(): list the users stored in the xml file.
          - Boolean existsUser(String username): check if the username already exist in the database (xml).
          - String generatePassword(int len): generate a random password with length "len".
          - ArrayList<User> getUserInformation(User user): search a specific user and return a vector with this single user to then print the beautiful table.
          - User getUserInformation(String username): return the user information in order to visualize his own information.
        - UserServiceInterface.class
        - ValidateService.class
          - Boolean checkIntegerNumber(String number): check if the given string is an integer number actually.
          - Boolean checkDoubleNumber(String number): check if the given string is an double number actually.
        - ValidateServiceInterface.class
        - XmlReaderService.class
          - Boolean existsUserXML(): check if user xml file exists.
          - Boolean existsMedicinesXML(): check if medicine xml file exists.
          - Boolean existsInvoicesXML(): check if invoice xml file exists.
          - Boolean createUserXML(): create user xml file.
          - Boolean createMedicinesXML(): create medicine xml file.
          - Boolean createInvoicesXML(): create invoice xml file.
          - ArrayList<User> readUsers(): read users-data from the file and return as an array.
          - ArrayList<Medicine> readMedicines(): read medicines-data from the file and return as an array.
          - ArrayList<Invoice> readInvoices(): read invoices-data from the file and return as an array.
        - XmlReaderServiceInterface.class
        - XmlWriterService.class
          - Boolean addUserXML(User user): add user data to the xml file.
          - Boolean deleteUserXML(String username): delete user data from the xml file.
          - Boolean updateUserXML(String username, User user): update stored data of user data in the xml file.
          - Boolean addMedicineXML(Medicine medicine): add medicine data to the xml file.
          - Boolean deleteMedicineXML(String username): delete medicine data from the xml file.
          - Boolean updateMedicineXML(String username, Medicine medicine): update stored medicine of invoice data in the xml file.
          - Boolean addInvoiceXML(Invoice medicine): add invoice data to the xml file.
          - Boolean deleteInvoiceXML(Integer id): delete invoice data from the xml file.
          - Boolean updateInvoiceXML(Integer id, Invoice invoice): update stored data of invoice data in the xml file.
        - XmlWriterServiceInterface.class
      * view
        - Login.class
          - void ShowLogin(): allows all the uses access to the system in case of having correct credentials.
          - void ShowMenuPharmacist(): show the main menu of the pharmacist.
          - void ShowMenuCostumer(): show the main menu of the costumer.
          - void ShowMenuSupplier(): show the main menu of the supplier.
        - MenuCostumer.class
          - void ShowListOfReportCostumer()
          - void ShowPersonalInformationCostumer():
        - MenuInvoice.class
          - void ShowAddInvoice(): ask information from the user to add in the xml file.
          - void ShowRemoveInvoice(): ask user identification to find and delete in the xml file if it exists.
          - void ShowUpdateInvoice(): ask information from the user to update in the xml file.
          - void ShowListInvoice(): list the invoices from a vector of medicines.
        - MenuMedicine.class
          - void ShowAddMedicine(): ask information from the user to add in the xml file.
          - void ShowRemoveMedicine(): ask medicine identification to find and delete in the xml file if it exists.
          - void ShowUpdateMedicine(): ask information from the medicine to update in the xml file.
          - void ShowListMedicine(): list the medicines from a vector of medicines.
        - MenuPharma.class
          - void ShowAddPharmacist(): ask information from the user to add in the xml file.
          - void ShowRemovePharmacist(): ask user identification to find and delete in the xml file if it exists.
          - void ShowUpdatePharmacist(): ask information from the user to update in the xml file.
          - void ShowListPharmacist(): list the pharmacists from a vector of Users.
        - MenuSupplier.class
          - void ShowListOfReportSupplier():
          - void ShowPersonalInformationSupplier():
        - MenuUser.class
        - void ShowAddUser(): ask information from the user to add in the xml file.
        - void ShowRemoveUser(): ask user identification to find and delete in the xml file if it exists.
        - void ShowUpdateUser(): ask information from the user to update in the xml file.
        - void ShowListUser(): list the users from a vector of Users.
      - main.class
        - void main(String[] args): the first method to run when the program is executed.
        - void ShowTitle(): show the title in the top of the console.
    * resources: xml files of the application
      - invoices.xml
      - medicines.xml
      - users.xml
  * test: Empty folder

## Main Classes
- [User](#user)
- [Medicine](#medicine)
- [Invoice](#invoice)

### User

|Order|Field|Type|
|:--:|:-----:|:------:|
| 1 | name  | `string` |
| 2 | username  | `string` |
| 3 | password  | `string` |
| 4 | acess_level  | `integer` |

### Medicine

|Order|Field|Type|
|:--:|:-----:|:------:|
| 1 | name  | `string` |
| 2 | supplier  | `string` |
| 3 | price  | `double` |
| 4 | quantity  | `integer` |

### Invoice

|Order|Field|Type|
|:--:|:-----:|:------:|
| 1 | costumer_name  | `string` |
| 2 | medicine_name  | `string` |
| 3 | quantity  | `integer` |
| 4 | total_price  | `double` |
| 5 | date  | `string` |

---

## List of forms
- [Login](#login)
- [Main Menu Costumer](#main-menu-costumer)
- [Main Menu Supplier](#main-menu-supplier)
- [Main Menu Pharmacist](#main-menu-pharmacist)
- [Menu Users](#menu-users)
- [Menu Medicines](#menu-medicines)
- [Menu Invoices](#menu-invoices)
- [Supplier Report](#supplier-report)
- [costumer Report](#costumer-report)

### Login

![login](https://user-images.githubusercontent.com/34483729/163722628-6623a0d1-ff29-4084-898e-bbdeb33f5dc6.png)


### Main Menu Costumer

![main_menu_costumer](https://user-images.githubusercontent.com/34483729/163722637-83af0334-a525-4f6f-a682-113222c74f0d.png)

### Main Menu Supplier

![main_menu_supplier](https://user-images.githubusercontent.com/34483729/163722656-d7a7f793-2604-4ce1-b5ff-04d77986e750.png)

### Main Menu Pharmacist

![main_menu_pharmacist](https://user-images.githubusercontent.com/34483729/163722649-f9784e1b-f8d4-43d6-b638-94f088413324.png)

### Menu Users

![menu_user](https://user-images.githubusercontent.com/34483729/163722667-286e5a75-3f38-4b12-913d-9e88765f2109.png)

### Menu Medicines

![menu_medicine](https://user-images.githubusercontent.com/34483729/163722683-50b55263-d945-419b-9e32-9ebedd567070.png)


### Menu Invoices

![menu_invoice](https://user-images.githubusercontent.com/34483729/163722686-7d8983d1-03e7-4e56-bdbd-1babdb53d648.png)

### Supplier Report

![supplier_report](https://user-images.githubusercontent.com/34483729/163722729-4d6fa5a8-6fce-49a7-bb66-0885b58c53df.png)

### Costumer Report

![costumer_report](https://user-images.githubusercontent.com/34483729/163722735-5f262fbf-96b4-46be-93f8-81e0d47d06a2.png)

---

## List of XML files

### Users

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<Users>
	<user>
		<name>Alfredo Martins</name>
		<username>codetyperpro</username>
		<password>[e@5b35e0d2</password>
		<level>1</level>
	</user>
	<user>
		<name>Hayat Chouhib</name>
		<username>hayat</username>
		<password>[C@5b37e0d2</password>
		<level>1</level>
	</user>
</Users>
```

### Invoice

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<invoices>
  <invoice>
    <id>1</id>
    <costumerName>Teresa</costumerName>
    <medicineName>Paracetamol</medicineName>
    <quantity>4</quantity>
    <totalPrice>180.0</totalPrice>
    <date>2022-04-24</date>
  </invoice>
  <invoice>
    <id>2</id>
    <costumerName>John</costumerName>
    <medicineName>Atorvastatin</medicineName>
    <quantity>4</quantity>
    <totalPrice>1834.0</totalPrice>
    <date>2022-05-06</date>
  </invoice>
</invoices>
```

### Medicine

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<medicines>
  <medicine>
    <name>Atorvastatin</name>
    <supplier>Rafaela</supplier>
    <price>1500.0</price>
    <quantity>20</quantity>
  </medicine>
  <medicine>
    <name>Paracetamol</name>
    <supplier>Rafaela</supplier>
    <price>8400.0</price>
    <quantity>30</quantity>
  </medicine>
</medicines>
```

---
## License
MIT License

Copyright (c) 2022, Alfredo Martins

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

---

## Credits
Author: `Alfredo Martins` | Nickname: `CodeTyper`

![avatar](https://images.weserv.nl/?url=https://user-images.githubusercontent.com/34483729/163725648-9eed2057-4502-4af5-bcff-643925695e31.jpg?v=4&h=100&w=100&fit=cover&mask=circle&maxage=7d
)

> _Learn by doing._

- Facebook: `https://www.facebook.com/alfredomartins.alfredo`
- Twitter: `https://twitter.com/AlfredoMartins0`
- GitHub: `https://github.com/CodeTyperPro`

[Back to the top](#table-content)
