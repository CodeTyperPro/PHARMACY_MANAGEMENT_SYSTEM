package view;

import model.Invoice;
import model.Medicine;
import model.User;
import service.*;

import java.util.*;
import java.util.stream.Stream;

public abstract class MenuSupplier {
    private static SupplierService supplierService;
    private static UserService userService;

    public static void ShowAddSupplier() {
    }

    public static void ShowRemoveSupplier() {
    }

    public static void ShowUpdateSupplier() {
    }

    public static void ShowListSupplier() {
    }

    public static void ShowListOfReportSupplier() {

        supplierService = new SupplierService();
        ArrayList<Medicine> medicines = supplierService.listMedicineReport(Login.active_user);

        System.out.println("\n\t\t::: LIST OF REPORT :::\n");

        if(medicines!=null){
            /*
             * leftJustifiedRows - If true, it will add "-" as a flag to format string to
             * make it left justified. Otherwise right justified.
             */
            boolean leftJustifiedRows = true;

            /*
             * Table to print in console in 2-dimensional array. Each sub-array is a row.
             */
            int n = medicines.size();
            String [][] table = new String[n+1][4];
            table[0][0] = "Id";
            table[0][1] = "Name";
            table[0][2] = "Price";
            table[0][3] = "Quantity";

            int index = 1;
            for (Medicine medicine : medicines){
                table[index][0] = String.valueOf(index);
                table[index][1] = medicine.getName();
                table[index][2] = String.valueOf(medicine.getPrice());
                table[index][3] = String.valueOf(medicine.getQuantity());
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

        } else{
            MessageService.EmptyMessage();
        }
    }

    public static void ShowPersonalInformationSupplier() {
        userService = new UserService();
        ArrayList<User> users = userService.getUserInformation(Login.active_user);

        System.out.println("\n\t\t::: PERSONAL INFORMATION :::\n");

        if(users!=null){
            /*
             * leftJustifiedRows - If true, it will add "-" as a flag to format string to
             * make it left justified. Otherwise right justified.
             */
            boolean leftJustifiedRows = true;

            /*
             * Table to print in console in 2-dimensional array. Each sub-array is a row.
             */
            int n = users.size();
            String [][] table = new String[n+1][4];
            table[0][0] = "Id";
            table[0][1] = "Name";
            table[0][2] = "Username";
            table[0][3] = "Type";

            int index = 1;
            for (User user : users){
                table[index][0] = String.valueOf(index);
                table[index][1] = user.getName();
                table[index][2] = user.getUsername();
                String type = "";
                switch (user.getLevel()){
                    case 1:
                        type = "Pharmacist";
                        break;
                    case 2:
                        type = "Costumer";
                        break;
                    case 3:
                        type = "Supplier";
                }
                table[index][3] = type;
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


        } else{
            MessageService.EmptyMessage();
        }
    }

}
