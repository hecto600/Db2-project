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
    private TextField tfAdress;
    private TextField tfCity;
    private TextField tfRegion;
    private TextField tfPostalCode;
    private TextField tfCountry;
    private TextField tfPhone;
    private TextField tfFax;
    private TextArea taResult;

    public CustomerController(TextField tfCompanyName, TextField tfContactName, TextField tfAdress, TextField tfCity,
            TextField tfRegion, TextField tfPostalCode, TextField tfCountry, TextField tfPhone, TextField tfFax,
            TextArea taResult) {
        this.tfCompanyName = tfCompanyName;
        this.tfContactName = tfContactName;
        this.tfAdress = tfAdress;
        this.tfCity = tfCity;
        this.tfRegion = tfRegion;
        this.tfPostalCode = tfPostalCode;
        this.tfCountry = tfCountry;
        this.tfPhone = tfPhone;
        this.tfFax = tfFax;
        this.taResult = taResult;
    }

    @Override
    public void insertCustomer(Customer c) throws ClassNotFoundException, SQLException {
        CustomerDao cDao = new CustomerDao();
        cDao.insertCustomer(c);
        customerCleanFields();
        visualizeAllCustomers();

    }

    @Override
    public void updateCustomer(Customer c) throws ClassNotFoundException, SQLException {
        CustomerDao cDao = new CustomerDao();
        cDao.updateCustomer(c);
        customerCleanFields();
        visualizeAllCustomers();
    }

    @Override
    public void removeCustomer(Customer c) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        CustomerDao cDao = new CustomerDao();
        cDao.removeCustomer(c);
        customerCleanFields();
        visualizeAllCustomers();

    }

    @Override
    public void visualizeCustomer(Customer c) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        customerCleanFields();
        CustomerDao cDao = new CustomerDao();
        c = cDao.visualizeCustomer(c);

        tfCustomerID.setText(c.getCustomerID());
    }

    @Override
    public void visualizeAllCustomers() throws ClassNotFoundException, SQLException {
        customerCleanFields();
        taResult.setText("test");

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
        tfCustomerID.setText(null);
        tfCompanyName.setText(null);
        tfContactName.setText(null);
        tfAdress.setText(null);
        tfCity.setText(null);
        tfRegion.setText(null);
        tfPostalCode.setText(null);
        tfCountry.setText(null);
        tfPhone.setText(null);
        tfFax.setText(null);
        taResult.setText(null);
    }

}
