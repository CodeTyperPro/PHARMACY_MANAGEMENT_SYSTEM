package view;

import java.util.Scanner;

public abstract class MenuPharmacist {
    public static void ShowNewMedicineOrder(){
        MenuMedicine.ShowAddMedicine();
    }

    public static void ShowMenuMedicine() {
        System.out.println("\n\t\t::: MAIN MEDICINE :::");
        System.out.print("\n\t\t" +
                "[1] => Add Medicine:\n\t\t" +
                "[2] => Remove Medicine:\n\t\t" +
                "[3] => Update Medicine:\n\t\t" +
                "[4] => List Medicines:\n\t\t" +
                "[5] => Back <=::\n\t\t" +
                "[6] => Exit.\n\t\t" +
                "Operation: ");

        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuMedicine.ShowAddMedicine();
                break;
            case '2':
                MenuMedicine.ShowRemoveMedicine();
                break;
            case '3':
                MenuMedicine.ShowUpdateMedicine();
                break;
            case '4':
                MenuMedicine.ShowListMedicine();
                ShowMenuMedicine();
                break;
            case '5':
                Login.ShowMenuPharmacist();
                break;
            case '6':
                System.exit(0);
                break;
            default:
                ShowMenuMedicine();
                break;
        }
    }


    public static void ShowMenuSupplier() {
        System.out.println("\n\t\t::: MAIN SUPPLIER :::");
        System.out.print("\n\t\t" +
                "[1] => Add Supplier:\n\t\t" +
                "[2] => Remove Supplier:\n\t\t" +
                "[3] => Update Supplier:\n\t\t" +
                "[4] => List Supplier:\n\t\t" +
                "[5] => Back <=::\n\t\t" +
                "[6] => Exit.\n\t\t" +
                "Operation: ");

        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuSupplier.ShowAddSupplier();
                break;
            case '2':
                MenuSupplier.ShowRemoveSupplier();
                break;
            case '3':
                MenuSupplier.ShowUpdateSupplier();
                break;
            case '4':
                MenuSupplier.ShowListSupplier();
                break;
            case '5':
                Login.ShowMenuPharmacist();
                break;
            case '6':
                System.exit(0);
                break;
            default:
                ShowMenuSupplier();
                break;
        }
    }

    public static void ShowMenuPharmacist() {
        System.out.println("\n\t\t::: MENU PHARMACIST :::");
        System.out.print("\n\t\t" +
                "[1] => Add Pharmacist:\n\t\t" +
                "[2] => Remove Pharmacist:\n\t\t" +
                "[3] => Update Pharmacist:\n\t\t" +
                "[4] => List Pharmacist:\n\t\t" +
                "[5] => Back <=::\n\t\t" +
                "[6] => Exit.\n\t\t" +
                "Operation: ");

        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuPharma.ShowAddPharmacist();
                break;
            case '2':
                MenuPharma.ShowRemovePharmacist();
                break;
            case '3':
                MenuPharma.ShowUpdatePharmacist();
                break;
            case '4':
                MenuPharma.ShowListPharmacist();
                ShowMenuPharmacist();
                break;
            case '5':
                Login.ShowMenuPharmacist();
                break;
            case '6':
                System.exit(0);
                break;
            default:
                ShowMenuPharmacist();
                break;
        }
    }

    public static void ShowMenuInvoice() {
        System.out.println("\n\t\t::: INVOICE MENU :::");
        System.out.print("\n\t\t" +
                "[1] => Add Invoice:\n\t\t" +
                "[2] => Remove Invoice:\n\t\t" +
                "[3] => Update Invoice:\n\t\t" +
                "[4] => List Invoice:\n\t\t" +
                "[5] => Back <=::\n\t\t" +
                "[6] => Exit.\n\t\t" +
                "Operation: ");

        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuInvoice.ShowAddInvoice();
                break;
            case '2':
                MenuInvoice.ShowRemoveInvoice();
                break;
            case '3':
                MenuInvoice.ShowUpdateInvoice();
                break;
            case '4':
                MenuInvoice.ShowListInvoice();
                ShowMenuInvoice();
                break;
            case '5':
                Login.ShowMenuPharmacist();
                break;
            case '6':
                System.exit(0);
                break;
            default:
                ShowMenuPharmacist();
                break;
        }
    }

    public static void ShowMenuUser() {
        System.out.println("\n\t\t::: USER MENU :::");
        System.out.print("\n\t\t" +
                "[1] => Add User:\n\t\t" +
                "[2] => Remove User:\n\t\t" +
                "[3] => Update User:\n\t\t" +
                "[4] => List User:\n\t\t" +
                "[5] => Back <=::\n\t\t" +
                "[6] => Exit.\n\t\t" +
                "Operation: ");

        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        switch (option){
            case '1':
                MenuUser.ShowAddUser();
                break;
            case '2':
                MenuUser.ShowRemoveUser();
                break;
            case '3':
                MenuUser.ShowUpdateUser();
                break;
            case '4':
                MenuUser.ShowListUser();
                ShowMenuUser();
                break;
            case '5':
                Login.ShowMenuPharmacist();
                break;
            case '6':
                System.exit(0);
                break;
            default:
                ShowMenuUser();
                break;
        }
    }
}
