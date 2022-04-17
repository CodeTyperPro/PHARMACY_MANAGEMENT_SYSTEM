package service;

import model.Invoice;
import model.Medicine;

import java.util.ArrayList;

public class InvoiceService implements InvoiceServiceInterface{
    private ArrayList<Invoice>  invoices = null;

    public InvoiceService() {
        this.invoices = new XmlReaderService().readInvoices();
    }

    @Override
    public Boolean addInvoice(Invoice invoice) {
        CostumerService costumerService = new CostumerService();
        if(!costumerService.existsCostumer(invoice.getCostumerName()))
            return false;

        if(invoice.getTotalPrice()<=0.0)
            return false;

        invoice.setId(getLastIdInvoice() + 1);
        return new XmlWriterService().addInvoiceXML(invoice);
    }

    @Override
    public Boolean deleteInvoice(Integer id) {
        if(existsInvoice(id)){
            return new XmlWriterService().deleteInvoiceXML(id);
        }
        return false;
    }

    @Override
    public Boolean updateInvoice(Integer id, Invoice invoice) {
        invoice.setTotalPrice(getTotalPrice(invoice.getMedicineName(), invoice.getQuantity()));
        if(existsInvoice(id))
            return new XmlWriterService().updateInvoiceXML(id, invoice);
        return false;
    }


    @Override
    public ArrayList<Invoice> listInvoice() {
        invoices = new XmlReaderService().readInvoices();
        return invoices;
    }

    @Override
    public Boolean existsInvoice(Integer id) {
        for (Invoice i : invoices){
            if(i.getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public Double getTotalPrice(String name, Integer quantity) {
        Double medicinePrice = new MedicineService().priceMedicine(name);
        return (quantity*medicinePrice);
    }

    @Override
    public String medicineInvoice(Integer id) {
        for (Invoice i : invoices){
            if(i.getId() == id){
                return i.getMedicineName();
            }
        }
        return "default";
    }

    @Override
    public ArrayList<Invoice> listInvoiceCostumer(String name) {
        invoices = new XmlReaderService().readInvoices();
        ArrayList<Invoice> list = new ArrayList<>();
        for (Invoice m : invoices){
            if(m.getCostumerName().equals(name)){
                list.add(m);
            }
        }
        return list;
    }

    @Override
    public Integer getLastIdInvoice() {
        invoices = new XmlReaderService().readInvoices();
        int len = invoices.size();
        if(len == 0)
            return 0;

        Integer last_id = invoices.get(len-1).getId();
        return last_id;
    }


}