package service;

import model.Invoice;
import model.Medicine;

import java.util.ArrayList;

public interface InvoiceServiceInterface {
    public Boolean addInvoice(Invoice invoice);
    public Boolean deleteInvoice(Integer id);
    public ArrayList<Invoice> listInvoice();
    public Boolean updateInvoice(Integer id, Invoice invoice);
    public Boolean existsInvoice(Integer id);
    public Double getTotalPrice(String medicine, Integer quantity);
    public String medicineInvoice(Integer id);
    public ArrayList<Invoice> listInvoiceCostumer(String name);
    public Integer getLastIdInvoice();
}
