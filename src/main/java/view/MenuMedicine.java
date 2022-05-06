package view;

import model.Medicine;
import model.User;
import service.MedicineService;
import service.MessageService;
import service.UserService;
import service.ValidateService;

import java.util.*;
import java.util.stream.Stream;


public abstract class MenuMedicine {
    private static MedicineService service;
    private static ValidateService validateService;
    public static void ShowAddMedicine() {

        service = new MedicineService();

        System.out.print("\n\t\t::: ADD MEDICINE :::\n");
        Scanner sc = new Scanner(System.in);
        Medicine medicine = new Medicine();
        System.out.print("\n\t\tEnter the name: ");
        medicine.setName(sc.next());

        System.out.print("\t\tEnter the supplier: ");
        medicine.setSupplier(sc.next());


        String number = "";
        do{
            System.out.print("\t\tEnter the price: ");
            number = sc.next();
            if(!validateService.checkDoubleNumber(number)){
                MessageService.ShowInvalidNumber();
            }
        } while(validateService.checkDoubleNumber(number));

        medicine.setPrice(Double.parseDouble(number));


        number = "";
        do{
            System.out.print("\t\tEnter the quantity: ");
            number = sc.next();
            if(!validateService.checkIntegerNumber(number)){
                MessageService.ShowInvalidNumber();
            }
        } while(validateService.checkIntegerNumber(number));

        medicine.setQuantity(Integer.parseInt(number));

        if(service.addMedicine(medicine)){
            MessageService.ShowSuccessfulMedicineCreateMessage();
        } else{
            MessageService.ShowFailedCreateMessage();
        }

        MenuPharmacist.ShowMenuMedicine();
    }

    public static void ShowRemoveMedicine() {
        service = new MedicineService();

        System.out.print("\n\t\t::: REMOVE MEDICINE :::\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tEnter the name: ");
        String name = sc.next();

        if(service.deleteMedicine(name)){
            MessageService.ShowSuccessfulMedicineDeletedMessage();
        } else{
            MessageService.ShowFailedDeleteMessage();
        }

        MenuPharmacist.ShowMenuMedicine();
    }

    public static void ShowUpdateMedicine() {
        service = new MedicineService();

        System.out.print("\n\t\t::: UPDATE MEDICINE :::\n");
        Scanner sc = new Scanner(System.in);

        Medicine medicine = new Medicine();

        System.out.print("\t\tEnter the name: ");
        String name = sc.next();

        System.out.print("\t\tEnter the new name: ");
        medicine.setName(sc.next());

        System.out.print("\t\tEnter the new supplier: ");
        medicine.setSupplier(sc.next());

        String number = "";
        do{
            System.out.print("\t\tEnter the new price: ");
            number = sc.next();
            if(!validateService.checkDoubleNumber(number)){
                MessageService.ShowInvalidNumber();
            }
        } while(validateService.checkDoubleNumber(number));

        medicine.setPrice(Double.parseDouble(number));

        number = "";
        do{
            System.out.print("\t\tEnter the new quantity: ");
            number = sc.next();
            if(!validateService.checkIntegerNumber(number)){
                MessageService.ShowInvalidNumber();
            }
        } while(validateService.checkIntegerNumber(number));

        medicine.setQuantity(Integer.parseInt(number));

        if(service.updateMedicine(name, medicine)){
            MessageService.ShowSuccessfulMedicineUpdatedMessage();
        } else{
            MessageService.ShowFailedUpdateMessage();
        }

        MenuPharmacist.ShowMenuMedicine();
    }

    /*
     * @Author: RAVIK, NOVEMBER 5, 2019
     * @url: https://itsallbinary.com/java-printing-to-console-in-table-format-simple-code-with-flexible-width-left-align-header-separator-line/
     * */
    public static void ShowListMedicine() {
        service = new MedicineService();
        ArrayList<Medicine> medicines = service.listMedicines();

        System.out.println("\n\t\t::: LIST MEDICINES :::\n");
        /*
         * leftJustifiedRows - If true, it will add "-" as a flag to format string to
         * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = true;

        /*
         * Table to print in console in 2-dimensional array. Each sub-array is a row.
         */
        int n = medicines.size();
        String [][] table = new String[n+1][5];
        table[0][0] = "Id";
        table[0][1] = "Name";
        table[0][2] = "Supplier";
        table[0][3] = "Price";
        table[0][4] = "Quantity";

        int index = 1;
        for (Medicine medicine : medicines){
            table[index][0] = String.valueOf(index);
            table[index][1] = medicine.getName();
            table[index][2] = medicine.getSupplier();
            table[index][3] = String.valueOf(medicine.getPrice());
            table[index][4] = String.valueOf(medicine.getQuantity());
            index++;
        }

        /*
         * Calculate appropriate Length of each column by looking at width of data in
         * each column.
         *
         * Map columnLengths is <column_number, column_length>
         */
        Map<Integer, Integer> columnLengths = new HashMap<>();
        Arrays.stream(table).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
            if (columnLengths.get(i) == null) {
                columnLengths.put(i, 0);
            }
            if (columnLengths.get(i) < a[i].length()) {
                columnLengths.put(i, a[i].length());
            }
        }));
        //System.out.println("columnLengths = " + columnLengths);

        /*
         * Prepare format String
         */
        final StringBuilder formatString = new StringBuilder("");
        String flag = leftJustifiedRows ? "-" : "";
        columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
        formatString.append("|\n");
        //System.out.println("formatString = " + formatString.toString());

        /*
         * Print table
         */
        Stream.iterate(0, (i -> i < table.length), (i -> ++i))
                .forEach(a -> System.out.printf("\t\t" + formatString.toString(), table[a]));

    }
}
