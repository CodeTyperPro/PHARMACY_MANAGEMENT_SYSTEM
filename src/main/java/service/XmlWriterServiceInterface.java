package service;

import model.Invoice;
import model.Medicine;
import model.User;

public interface XmlWriterServiceInterface {
    public Boolean addUserXML(User user);
    public Boolean deleteUserXML(String username);
    public Boolean updateUserXML(String username, User user);

    public Boolean addMedicineXML(Medicine medicine);
    public Boolean deleteMedicineXML(String username);
    public Boolean updateMedicineXML(String username, Medicine medicine);

    public Boolean addInvoiceXML(Invoice medicine);
    public Boolean deleteInvoiceXML(Integer id);
    public Boolean updateInvoiceXML(Integer id, Invoice invoice);
}
