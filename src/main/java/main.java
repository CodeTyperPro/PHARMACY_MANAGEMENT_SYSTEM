import model.User;
import view.Login;

public class main {
    public static String username;

    public static void main(String[] args) {
        Login.active_user = new User();
        ShowTitle();
        //Login.ShowLogin();
        Login.ShowMenuPharmacist();
        //Login.ShowMenuSupplier();
        //Login.ShowMenuCostumer();
    }

    public static void ShowTitle(){
        System.out.println("\n\t\t::: => PHARMACY MANAGEMENT SYSTEM <= :::");
    }
}
