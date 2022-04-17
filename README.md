# PHARMACY MANAGEMENT SYSTEM

Pharmacy Management System is blá blá blá

### Table Content
1. [Workplace](#workplace)
2. [How to use the project](#how-to-use-the-project)
3. [Project Structure](#project-structure)
4. [Main Classes](#main-classes)
5. [License](#license)
6. [Author Info](#author-info)

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

### User

|Order|Field|Type|
|:--|:-----|:------|
| 1 | name  | string |
| 2 | username  | string |
| 3 | password  | string |

### Medicine

|Order|Field|Type|
|:--|:-----|:------|
| 1 | name  | `string` |
| 2 | supplier  | `string` |
| 3 | price  | `double` |
| 4 | quantity  | `integer` |

### Invoice

|Order|Field|Type|
|:--|:-----|:------|
| 1 | costumer_name  | `string` |
| 2 | medicine_name  | `string` |
| 3 | quantity  | `integer` |
| 4 | total_price  | `double` |
| 5 | date  | `string` |


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

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
---

## Author Info
Information here.

[Back to the top](#table-content)
