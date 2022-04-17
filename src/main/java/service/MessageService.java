package service;

import java.io.IOException;

public abstract class MessageService {

    public static void ShowDeniedMessage(){
        ClearConsole();
        String message = "\n\t\tAccess denied. Try again later, please!";
        System.out.println(message);
    }

    public static void ShowSuccessfulUserCreateMessage(){
        ClearConsole();
        String message = "\n\t\tSuccessful. User created!";
        System.out.println(message);
    }

    public static void ShowFailedCreateMessage(){
        ClearConsole();
        String message = "\n\t\tSomething went wrong. Please, try again later.";
        System.out.println(message);
    }

    public static void ShowTryAgainMessage(){
        ClearConsole();
        System.out.print("\n\t\tPress:\n\t\t[1] - Try again;\n\t\t[2] - Exit.\n");
        System.out.print("\n\t\tOption: ");
    }

    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Linux") || operatingSystem.contains("iOS")){
                ProcessBuilder processBuilder = new ProcessBuilder("clear");
                Process process = processBuilder.start();
                process.waitFor();
            } else{
                ProcessBuilder processBuilder = new ProcessBuilder("cml", "/c", "cls");
                Process process = processBuilder.start();
                process.waitFor();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void ShowSuccessfulUserDeletedMessage() {
        ClearConsole();
        String message = "\n\t\tSuccessful. User deleted!";
        System.out.println(message);
    }

    public static void ShowFailedDeleteMessage() {
        ClearConsole();
        String message = "\n\t\tSomething went wrong. Please, try again later.";
        System.out.println(message);
    }

    public static void ShowSuccessfulUserUpdatedMessage() {
        ClearConsole();
        String message = "\n\t\tSuccessful. User updated!";
        System.out.println(message);
    }

    public static void ShowSuccessfulMedicineCreateMessage() {
        ClearConsole();
        String message = "\n\t\tSuccessful. Medicine created!";
        System.out.println(message);
    }

    public static void ShowSuccessfulMedicineDeletedMessage() {
        ClearConsole();
        String message = "\n\t\tSuccessful. Medicine deleted!";
        System.out.println(message);
    }

    public static void ShowSuccessfulMedicineUpdatedMessage() {
        ClearConsole();
        String message = "\n\t\tSuccessful. Medicine updated!";
        System.out.println(message);
    }

    public static void ShowFailedUpdateMessage() {
        ClearConsole();
        String message = "\n\t\tSomething went wrong. Please, try again later.";
        System.out.println(message);
    }

    public static void ShowSuccessfulInvoiceDeletedMessage() {
        ClearConsole();
        String message = "\n\t\tSuccessful. Invoice deleted!";
        System.out.println(message);
    }


    public static void ShowSuccessfulInvoiceCreateMessage() {
        ClearConsole();
        String message = "\n\t\tSuccessful. Invoice created!";
        System.out.println(message);
    }

    public static void EmptyMessage() {
        ClearConsole();
        String message = "\n\t\tNo item. It's empty!";
        System.out.println(message);
    }
}
