package view;

import model.Invoice;
import model.Medicine;
import model.User;
import service.*;

import java.util.*;
import java.util.stream.Stream;

public abstract class MenuCostumer {
    private static CostumerService costumerService;
    private static UserService service;

    /*
    * @Author: RAVIK, NOVEMBER 5, 2019
    * @url: https://itsallbinary.com/java-printing-to-console-in-table-format-simple-code-with-flexible-width-left-align-header-separator-line/
    * */
    public static void ShowListOfReportCostumer() {

        costumerService = new CostumerService();
        ArrayList<Invoice> invoices = costumerService.listInvoiceReport(Login.active_user);

        System.out.println("\n\t\t::: LIST OF REPORT :::\n");

        if(invoices.size()>0){

            /*
             * leftJustifiedRows - If true, it will add "-" as a flag to format string to
             * make it left justified. Otherwise right justified.
             */
            boolean leftJustifiedRows = true;

            /*
             * Table to print in console in 2-dimensional array. Each sub-array is a row.
             */
            int n = invoices.size();
            String [][] table = new String[n+1][6];
            table[0][0] = "Ord";
            table[0][1] = "Id";
            table[0][2] = "Medicine";
            table[0][3] = "Quantity";
            table[0][4] = "Total Price";
            table[0][5] = "Date";

            int index = 1;
            for (Invoice invoice : invoices){
                table[index][0] = String.valueOf(index);
                table[index][1] = String.valueOf(invoice.getId());
                table[index][2] = invoice.getMedicineName();
                table[index][3] = String.valueOf(invoice.getQuantity());
                table[index][4] = String.valueOf(invoice.getTotalPrice());
                table[index][5] = String.valueOf(invoice.getDate());
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

    /*
     * @Author: RAVIK, NOVEMBER 5, 2019
     * @url: https://itsallbinary.com/java-printing-to-console-in-table-format-simple-code-with-flexible-width-left-align-header-separator-line/
     * */
    public static void ShowPersonalInformationCostumer() {
        service = new UserService();
        ArrayList<User> users = service.getUserInformation(Login.active_user);

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


    public static void ShowAddCostumer() {
        service = new UserService();

        System.out.print("\n\t\t::: ADD COSTUMER :::\n");
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.print("\n\t\tEnter the name: ");
        user.setName(sc.next());

        System.out.print("\t\tEnter the username: ");
        user.setUsername(sc.next());

        user.setPassword(service.generatePassword(4));

        user.setLevel(2);

        if(service.addUser(user)){
            MessageService.ShowSuccessfulUserCreateMessage();
        } else{
            MessageService.ShowFailedCreateMessage();
        }

        MenuPharmacist.ShowMenuPharmacist();
    }

    public static void ShowRemoveCostumer() {
        service = new UserService();

        System.out.print("\n\t\t::: REMOVE COSTUMER :::\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tEnter the username: ");
        String username = sc.next();

        if(service.deleteUser(username)){
            MessageService.ShowSuccessfulUserDeletedMessage();
        } else{
            MessageService.ShowFailedDeleteMessage();
        }

        MenuPharmacist.ShowMenuPharmacist();
    }

    public static void ShowUpdateCostumer() {
        service = new UserService();

        System.out.print("\n\t\t::: UPDATE COSTUMER :::\n");
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.print("\t\tEnter the username: ");
        String username = sc.next();

        System.out.print("\n\t\tEnter the new name/blank: ");
        user.setName(sc.next());

        System.out.print("\t\tEnter the new username/blank: ");
        user.setUsername(sc.next());

        user.setPassword(service.generatePassword(4));

        user.setLevel(2);

        if(service.updateUser(username, user)){
            MessageService.ShowSuccessfulUserUpdatedMessage();
        } else{
            MessageService.ShowFailedCreateMessage();
        }

        MenuPharmacist.ShowMenuPharmacist();
    }

    /*
     * @Author: RAVIK, NOVEMBER 5, 2019
     * @url: https://itsallbinary.com/java-printing-to-console-in-table-format-simple-code-with-flexible-width-left-align-header-separator-line/
     * */
    public static void ShowListCostumer() {
        service = new UserService();
        ArrayList<User> users = service.listUsers();

        System.out.println("\n\t\t::: LIST COSTUMER :::\n");
        /*
         * leftJustifiedRows - If true, it will add "-" as a flag to format string to
         * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = true;

        /*
         * Table to print in console in 2-dimensional array. Each sub-array is a row.
         */
        int n = users.size();
        String [][] table = new String[n+1][3];
        table[0][0] = "Id";
        table[0][1] = "Name";
        table[0][2] = "Username";

        int index = 1;
        for (User user : users){
            table[index][0] = String.valueOf(index);
            table[index][1] = user.getName();
            table[index][2] = user.getUsername();
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
