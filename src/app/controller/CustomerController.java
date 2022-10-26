package app.controller;

import java.sql.SQLException;
import java.util.List;

import app.model.Customer;
import app.persistence.CustomerDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CustomerController implements InterfaceCustomerController {

    private TextField tfCustomerID;
    private TextField tfCompanyName;
    private TextField tfContactName;
    private TextField tfContactTitle;
    private TextField tfAdress;
    private TextField tfCity;
    private TextField tfRegion;
    private TextField tfPostalCode;
    private TextField tfCountry;
    private TextField tfPhone;
    private TextField tfFax;
    private TextArea taResult;

    public CustomerController(TextField tfCustomerID, TextArea tA) {
        this.tfCustomerID = tfCustomerID;
        this.taResult = tA;
        this.tfCompanyName = new TextField("");
        this.tfContactName = new TextField("");
        this.tfContactTitle = new TextField("");
        this.tfAdress = new TextField("");
        this.tfCity = new TextField("");
        this.tfRegion = new TextField("");
        this.tfPostalCode = new TextField("");
        this.tfCountry = new TextField("");
        this.tfPhone = new TextField("");
        this.tfFax = new TextField("");
        this.taResult = new TextArea("");
    }

    // insert && update
    public CustomerController(TextField tfID, TextField tfCN, TextField tfCName,
            TextField tfCT,
            TextField tfA, TextField tfCity,
            TextField tfR, TextField tfPC, TextField tfC, TextField tfP, TextField tfF,
            TextArea taR) {
        this.tfCustomerID = tfID;
        this.tfCompanyName = tfCN;
        this.tfContactName = tfCName;
        this.tfContactTitle = tfCT;
        this.tfAdress = tfA;
        this.tfCity = tfCity;
        this.tfRegion = tfR;
        this.tfPostalCode = tfPC;
        this.tfCountry = tfC;
        this.tfPhone = tfP;
        this.tfFax = tfF;
        this.taResult = taR;
    }

    @Override
    public Customer insertCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();
        CustomerDao cDao = new CustomerDao();
        return cDao.insertCustomer(c);

    }

    @Override
    public Customer updateCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();
        CustomerDao cDao = new CustomerDao();
        return cDao.updateCustomer(c);
    }

    @Override
    public Customer removeCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();
        CustomerDao cDao = new CustomerDao();
        return cDao.removeCustomer(c);

    }

    @Override
    public Customer visualizeCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();

        CustomerDao cDao = new CustomerDao();
        c = cDao.visualizeCustomer(c);

        tfCustomerID.setText(c.getCustomerID());
        tfCompanyName.setText(c.getCompanyName());
        tfContactName.setText(c.getContactName());
        tfContactTitle.setText(c.getContactTitle());
        tfAdress.setText(c.getAddress());
        tfCity.setText(c.getCity());
        tfRegion.setText(c.getRegion());
        tfPostalCode.setText(c.getPostalCode());
        tfCountry.setText(c.getCountry());
        tfPhone.setText(c.getPhone());
        tfFax.setText(c.getFax());

        if (c.getCustomerID() == null)
            return null;
        else
            return c;

    }

    @Override
    public String visualizeAllCustomers() throws ClassNotFoundException, SQLException {
        customerCleanFields();

        CustomerDao cDao = new CustomerDao();
        List<Customer> cList = cDao.visualizeAllCustomers();

        StringBuffer buffer = new StringBuffer(
                String.format(
                        "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|\n",
                        "CustomerID",
                        "CompanyName", "ContactName", "ContactTitle", "Address", "City", "PostalCode", "Region",
                        "Country",
                        "Phone", "Fax"));
        buffer.append(String.format(
                "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|" +
                        "%-45s|\n",
                "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-").replace(" ", "-"));

        for (Customer c : cList) {
            buffer.append(
                    String.format(
                            "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|\n",
                            c.getCustomerID(), c.getCompanyName(), c.getContactName(), c.getContactTitle(),
                            c.getAddress(), c.getCity(), c.getPostalCode(), c.getRegion(),
                            c.getCountry(), c.getPhone(), c.getFax()));

            buffer.append(String.format(
                    "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|" +
                            "%-45s|\n",
                    "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-").replace(" ", "-"));

        }
        return buffer.toString();

    }

    private void customerCleanFields() {

        tfCustomerID.setText("");
        if (tfCompanyName != null && taResult != null) {
            tfCompanyName.setText("");
            tfContactName.setText("");
            tfContactTitle.setText("");
            tfAdress.setText("");
            tfCity.setText("");
            tfRegion.setText("");
            tfPostalCode.setText("");
            tfCountry.setText("");
            tfPhone.setText("");
            tfFax.setText("");
            taResult.setText("");
        }
    }

}
