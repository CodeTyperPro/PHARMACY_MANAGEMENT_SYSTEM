# PHARMACY MANAGEMENT SYSTEM

The pharmacy management system, also known as the pharmacy information system, is a system that stores data and enables functionality that organizes and maintains the medication use process within pharmacies.

Developed using `JAVA` programming language, Pharmacy management system is an offline application that uses `XML` as the database.

### Existing System:

The existing system is paper-based involving high amount of paper work and manpower requirement. Even though computerized systems are used in some places, they are not web-based and are very insecure and improperly managed. So, the current pharmacy management procedure is very uneconomical and inflexible to meet user demands.

### Proposed System:

The proposed system, being web-based, is very efficient and effective from the point of view of work productivity and time. It is less tedious to manage operations in a medical store or pharmacy with such a system. It has all the required modules and is developed with the aim of managing staffs, schedule, inventories, and relevant things in the medical store.

With this system, the entire operations in medical store is fully automated. Unlike the traditional system where records were maintained manually, this system maintains records in a database. Typical example of these records include purchases, counter sales, recorder levels, staffs, suppliers, customers, monetary transactions, etc.

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
* README.md
* src
  * main
    * java: source-code of the application
      * controller
        - LoginController.class
        - UserController.class
      * model
        - Costumer.class
        - Invoice.class
        - Pharmacist.class
        - Supplier.class
        - User.class
      * service
        - CostumerService.class
        - CostumerServiceInterface.class
        - InvoiceService.class
        - InvoiceServiceInterface.class
        - MedicineService.class
        - MedicineServiceInterface.class
        - SupplierService.class
        - SupplierServiceInterface.class
        - UserService.class
        - UserServiceInterface.class
        - XmlReaderService.class
        - XmlReaderServiceInterface.class
        - XmlWriterService.class
        - XmlWriterServiceInterface.class
      * view
        - Login.class
        - MenuCostumer.class
        - MenuInvoice.class
        - MenuMedicine.class
        - MenuPharma.class
        - MenuSupplier.class
        - MenuUser.class
      - main.class
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

![avatar](https://images.weserv.nl/?url=https://user-images.githubusercontent.com/34483729/163725648-9eed2057-4502-4af5-bcff-643925695e31.jpg?v=4&h=300&w=300&fit=cover&mask=circle&maxage=7d
)

> _Learn by doing._

- Facebook: `https://www.facebook.com/alfredomartins.alfredo`
- Twitter: `https://twitter.com/AlfredoMartins0`
- GitHub: `https://github.com/CodeTyperPro`

[Back to the top](#table-content)
