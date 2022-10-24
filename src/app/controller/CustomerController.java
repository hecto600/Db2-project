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

    public CustomerController(TextField tfCustomerID, TextArea tA){
        this.tfCustomerID = tfCustomerID;
        this.taResult = tA;
    }

    //insert && update
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
    public void insertCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();
        CustomerDao cDao = new CustomerDao();
        cDao.insertCustomer(c);
        visualizeAllCustomers();

    }

    @Override
    public void updateCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();
        CustomerDao cDao = new CustomerDao();
        cDao.updateCustomer(c);
        visualizeAllCustomers();
    }

    @Override
    public void removeCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();
        CustomerDao cDao = new CustomerDao();
        cDao.removeCustomer(c);
        visualizeAllCustomers();

    }

    @Override
    public void visualizeCustomer(Customer c) throws ClassNotFoundException, SQLException {
        customerCleanFields();

        CustomerDao cDao = new CustomerDao();

        tfCustomerID.setText(c.getCustomerID());
        tfCompanyName.setText(c.getCompanyName());
        tfContactName.setText(c.getContactName());
        tfContactTitle.setText(c.getContactTitle());
        tfAdress.setText(c.getAddres());
        tfCity.setText(c.getCity());
        tfRegion.setText(c.getRegion());
        tfPostalCode.setText(c.getPostalCode());
        tfCountry.setText(c.getCountry());
        tfPhone.setText(c.getPhone());
        tfFax.setText(c.getFax());

        c = cDao.visualizeCustomer(c);

    }

    @Override
    public void visualizeAllCustomers() throws ClassNotFoundException, SQLException {
        customerCleanFields();

        CustomerDao cDao = new CustomerDao();
        List<Customer> cList = cDao.visualizeAllCustomers();

        StringBuffer buffer = new StringBuffer("\t\t\tList of all customers from database");
        for (Customer c : cList) {
            buffer.append(
                    "CustomerID: " + c.getCustomerID() +
                            "\tCompanyName: " + c.getCompanyName() +
                            "\tContactName: " + c.getCity() +
                            "\tAdress: " + c.getCity() +
                            "\tCity: " + c.getCity() +
                            "\tRegion: " + c.getCity() +
                            "\tPostalCode: " + c.getCity() +
                            "\tCountry: " + c.getCity() +
                            "\tPhone: " + c.getCity() +
                            "\tFax: " + c.getCity() +
                            "\n");
        }
        taResult.setText(buffer.toString());

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
