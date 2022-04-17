package view;

import model.User;
import service.MessageService;
import service.UserService;

import java.util.*;
import java.util.stream.Stream;

public abstract class MenuUser {
    private static UserService service;
    public static void ShowAddUser() {
        service = new UserService();

        System.out.print("\n\t\t::: ADD USER :::\n");
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.print("\n\t\tEnter the name: ");
        user.setName(sc.next());

        System.out.print("\t\tEnter the username: ");
        user.setUsername(sc.next());

        user.setPassword(service.generatePassword(4));

        Character choice = ' ';
        do {
            System.out.print("\n\t\tChoose:\n\t\t" +
                    "[1] - Pharmacist;\n\t\t" +
                    "[2] - Costumer;\n\t\t" +
                    "[3] - Supplier;\n\t\t");
            System.out.print("\n\t\tOption: ");

            choice = sc.next().charAt(0);
        } while(choice!= '1' && choice != '2' && choice != '3');

        user.setLevel(choice - '0');

        if(service.addUser(user)){
            MessageService.ShowSuccessfulUserCreateMessage();
        } else{
            MessageService.ShowFailedCreateMessage();
        }

        MenuPharmacist.ShowMenuUser();
    }

    public static void ShowRemoveUser() {
        service = new UserService();

        System.out.print("\n\t\t::: REMOVE USER :::\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tEnter the username: ");
        String username = sc.next();

        if(service.deleteUser(username)){
            MessageService.ShowSuccessfulUserDeletedMessage();
        } else{
            MessageService.ShowFailedDeleteMessage();
        }

        MenuPharmacist.ShowMenuUser();
    }

    public static void ShowUpdateUser() {
        service = new UserService();

        System.out.print("\n\t\t::: UPDATE USER :::\n");
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.print("\t\tEnter the username: ");
        String username = sc.next();

        System.out.print("\n\t\tEnter the new name/blank: ");
        user.setName(sc.next());

        System.out.print("\t\tEnter the new username/blank: ");
        user.setUsername(sc.next());

        user.setPassword(service.generatePassword(4));

        Character choice = '0';
        do {
            System.out.print("\n\t\tChoose/Enter space:\n\t\t" +
                    "[1] - Pharmacist;\n\t\t" +
                    "[2] - Costumer;\n\t\t" +
                    "[3] - Supplier;\n\t\t" +
                    "[0] - Do not change;\n\t\t");
            System.out.print("\n\t\tOption: ");

            choice = sc.next().charAt(0);
        } while(choice!= '1' && choice != '2' && choice != '3' && choice !='0');

        user.setLevel(choice - '0');

        if(service.updateUser(username, user)){
            MessageService.ShowSuccessfulUserUpdatedMessage();
        } else{
            MessageService.ShowFailedCreateMessage();
        }

        MenuPharmacist.ShowMenuUser();
    }

    public static void ShowListUser() {
        service = new UserService();
        ArrayList<User> users = service.listUsers();

        System.out.println("\n\t\t::: LIST USER :::\n");
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
    }
}
