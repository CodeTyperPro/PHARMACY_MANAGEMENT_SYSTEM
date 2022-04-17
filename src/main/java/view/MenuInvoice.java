package view;

import model.Invoice;
import model.Medicine;
import service.InvoiceService;
import service.MedicineService;
import service.MessageService;

import java.util.*;
import java.util.stream.Stream;

public abstract class MenuInvoice {
    private static InvoiceService service;

    public static void ShowAddInvoice() {
        service = new InvoiceService();

        System.out.print("\n\t\t::: ADD INVOICE :::\n");
        Scanner sc = new Scanner(System.in);
        Invoice invoice = new Invoice();
        System.out.print("\n\t\tEnter the costumer name: ");
        invoice.setCostumerName(sc.next());

        System.out.print("\t\tEnter the medicine: ");
        invoice.setMedicineName(sc.next());

        System.out.print("\t\tEnter the quantity: ");
        invoice.setQuantity(Integer.parseInt(sc.next()));

        invoice.setTotalPrice(service.getTotalPrice(invoice.getMedicineName(), invoice.getQuantity()));
        System.out.print("\t\tTotal Price = " + invoice.getTotalPrice() + "\n");

        if(service.addInvoice(invoice)){
            MessageService.ShowSuccessfulInvoiceCreateMessage();
        } else{
            MessageService.ShowFailedCreateMessage();
        }

        MenuPharmacist.ShowMenuInvoice();
    }

    public static void ShowRemoveInvoice() {
        service = new InvoiceService();

        System.out.print("\n\t\t::: REMOVE INVOICE :::\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tEnter the ID: ");
        Integer id = Integer.parseInt(sc.next());

        if(service.deleteInvoice(id)){
            MessageService.ShowSuccessfulInvoiceDeletedMessage();
        } else{
            MessageService.ShowFailedDeleteMessage();
        }

        MenuPharmacist.ShowMenuInvoice();
    }

    public static void ShowUpdateInvoice() {
        service = new InvoiceService();

        System.out.print("\n\t\t::: UPDATE INVOICE :::\n");
        Scanner sc = new Scanner(System.in);

        Invoice invoice = new Invoice();

        System.out.print("\t\tEnter the id: ");
        Integer id = sc.nextInt();

        System.out.print("\t\tEnter the new quantity: ");
        invoice.setQuantity(sc.nextInt());

        if(service.updateInvoice(id, invoice)){
            MessageService.ShowSuccessfulMedicineUpdatedMessage();
        } else{
            MessageService.ShowFailedUpdateMessage();
        }

        MenuPharmacist.ShowMenuMedicine();
    }

    public static void ShowListInvoice() {
        service = new InvoiceService();
        ArrayList<Invoice> invoices = service.listInvoice();

        System.out.println("\n\t\t::: LIST INVOICES :::\n");
        /*
         * leftJustifiedRows - If true, it will add "-" as a flag to format string to
         * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = true;

        /*
         * Table to print in console in 2-dimensional array. Each sub-array is a row.
         */
        int n = invoices.size();
        String [][] table = new String[n+1][7];
        table[0][0] = "Ord";
        table[0][1] = "Id";
        table[0][2] = "Costumer";
        table[0][3] = "Medicine";
        table[0][4] = "Quantity";
        table[0][5] = "Total_Price";
        table[0][6] = "Date";

        int index = 1;
        for (Invoice invoice : invoices){
            table[index][0] = String.valueOf(index);
            table[index][1] = String.valueOf(invoice.getId());
            table[index][2] = invoice.getCostumerName();
            table[index][3] = invoice.getMedicineName();
            table[index][4] = String.valueOf(invoice.getQuantity());
            table[index][5] = String.valueOf(invoice.getTotalPrice());
            table[index][6] = invoice.getDate();
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
