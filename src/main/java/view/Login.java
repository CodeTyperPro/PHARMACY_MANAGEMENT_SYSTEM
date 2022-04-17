package view;

import controller.LoginController;
import model.User;
import service.MessageService;
import service.UserService;

import java.util.Scanner;

public abstract class Login {
    public static User active_user = null;

    public static void ShowLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t::: LOGIN :::");
        User user = new User();
        System.out.print("\n\t\tUsername: ");
        user.setUsername(sc.next());
        System.out.print("\t\tPassword: ");
        user.setPassword(sc.next());

        LoginController loginController = new LoginController();
        int acessLevel = loginController.successfulLogin(user);

        active_user = new UserService().getUserInformation(user.getUsername());
        switch (acessLevel){
            case 1:
                ShowMenuPharmacist(); break;
            case 2:
                ShowMenuCostumer(); break;
            case 3:
                ShowMenuSupplier(); break;
            default:
                MessageService.ShowDeniedMessage();

                Character choice = 0;

                do {
                    MessageService.ShowTryAgainMessage();
                    choice = sc.next().charAt(0);
                } while(choice!= '1' && choice != '2');

                if(choice == '1'){
                    ShowLogin();
                } else{
                    System.exit(0);
                }

                break;
        }
    }

    public static void ShowMenuPharmacist(){
        System.out.println("\n\t\t::: MAIN MENU :::");
        System.out.print("\n\t\t" +
                "[1] => New medicine order:\n\t\t" +
                "[2] => Medicines:\n\t\t" +
                "[3] => Suppliers:\n\t\t" +
                "[4] => Pharmacist:\n\t\t" +
                "[5] => Invoice:\n\t\t" +
                "[6] => Users:\n\t\t" +
                "[7] => Back <=::\n\t\t" +
                "[8] => Exit.\n\t\t" +
                "Operation: ");
        Scanner sc = new Scanner(System.in);
        int option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuPharmacist.ShowNewMedicineOrder();
                break;
            case '2':
                MenuPharmacist.ShowMenuMedicine();
                break;
            case '3':
                MenuPharmacist.ShowMenuSupplier();
                break;
            case '4':
                MenuPharmacist.ShowMenuPharmacist();
                break;
            case '5':
                MenuPharmacist.ShowMenuInvoice();
                break;
            case '6':
                MenuPharmacist.ShowMenuUser();
                break;
            case '7':
                ShowLogin();
                break;
            case '8':
                System.exit(0);
                break;
            default:
                ShowMenuPharmacist();
                break;
        }
    }

    public static void ShowMenuCostumer(){
        System.out.println("\n\t\t::: MAIN COSTUMER :::");
        System.out.print("\n\t\t" +
                "[1] => List of Report:\n\t\t" +
                "[2] => Personal Information:\n\t\t" +
                "[3] => Back <=::\n\t\t" +
                "[4] => Exit.\n\t\t" +
                "Operation: ");

        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuCostumer.ShowListOfReportCostumer();
                ShowMenuCostumer();
                break;
            case '2':
                MenuCostumer.ShowPersonalInformationCostumer();
                ShowMenuCostumer();
                break;
            case '3':
                Login.ShowLogin();
                break;
            case '4':
                System.exit(0);
                break;
            default:
                ShowMenuCostumer();
                break;
        }
    }

    public static void ShowMenuSupplier(){
        System.out.println("\n\t\t::: MAIN MENU :::");
        System.out.print("\n\t\t" +
                "[1] => List of Report:\n\t\t" +
                "[2] => Personal Information:\n\t\t" +
                "[3] => Back <=::\n\t\t" +
                "[4] => Exit.\n\t\t" +
                "Operation: ");
        Scanner sc = new Scanner(System.in);
        int option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuSupplier.ShowListOfReportSupplier();
                ShowMenuSupplier();
                break;
            case '2':
                MenuSupplier.ShowPersonalInformationSupplier();
                ShowMenuSupplier();
                break;
            case '3':
                Login.ShowLogin();
                break;
            case '4':
                System.exit(0);
                break;
            default:
                ShowMenuSupplier();
                break;
        }
    }
}
