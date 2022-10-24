package app.controller;

import java.sql.SQLException;


import app.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private Button btnInsertCustomer;

    @FXML
    private Button btnUpdateCustomer;

    @FXML
    private Button btnVisualizeAllCustomers;

    @FXML
    private Button btnVisualizeCustomer;

    @FXML
    private Label labelInsertError;

    @FXML
    private Label labelInsertRequiredField;

    @FXML
    private Label labelUpdateError;

    @FXML
    private Label labelUpdateRequiredField;

    @FXML
    private TextField tfInsertAddress;

    @FXML
    private TextField tfInsertCity;

    @FXML
    private TextField tfInsertCompanyName;

    @FXML
    private TextField tfInsertContactName;

    @FXML
    private TextField tfInsertContactTitle;

    @FXML
    private TextField tfInsertCountry;

    @FXML
    private TextField tfInsertCustomerID;

    @FXML
    private TextField tfInsertFax;

    @FXML
    private TextField tfInsertPhone;

    @FXML
    private TextField tfInsertPostalCode;

    @FXML
    private TextField tfInsertRegion;

    @FXML
    private TextField tfUpdateAddress;

    @FXML
    private TextField tfUpdateCity;

    @FXML
    private TextField tfUpdateCompanyName;

    @FXML
    private TextField tfUpdateContactName;

    @FXML
    private TextField tfUpdateContactTitle;

    @FXML
    private TextField tfUpdateCountry;

    @FXML
    private TextField tfUpdateCustomerID;

    @FXML
    private TextField tfUpdateFax;

    @FXML
    private TextField tfUpdatePhone;

    @FXML
    private TextField tfUpdatePostalCode;

    @FXML
    private TextField tfUpdateRegion;

    @FXML
    private TextField tfVisualizeCustomerID;


    @FXML
    void actionCustomers(ActionEvent event) {
        String cmd = event.getSource().toString();
        CustomerController customerController = new CustomerController(tfInsertCompanyName, tfInsertContactName,
                tfInsertAddress, tfInsertCity, tfInsertRegion, tfInsertPostalCode,
                tfInsertCountry, tfInsertPhone, tfInsertFax, null);
        cmd = cmd.substring(cmd.indexOf("=") + 1, cmd.indexOf(","));
        
        try {
            switch (cmd) {
                case "btnInsertCustomer":
                    if (tfInsertCustomerID.getText().isEmpty()) {
                        labelInsertRequiredField.setVisible(true);
                        labelInsertError.setVisible(true);
                    } else {
                        Customer c = new Customer();
                        c.setCustomerID(tfInsertCustomerID.getText());
                        customerController.insertCustomer(c);
                    }
                    break;
                case "btnVisualizeCustomer":
                    if(tfVisualizeCustomerID.getText().isEmpty())
                    {
                        System.out.println("WTF");
                    }else{

                        Customer c = new Customer();
                        customerController.visualizeCustomer(c);
                        c.setCustomerID(tfVisualizeCustomerID.getText());
                    }

                    break;
                case "btnVisualizeAllCustomers":
                    customerController.visualizeAllCustomers();
                    break;
                default:
                    break;
            }
        } catch (ClassNotFoundException | SQLException se) {
            se.printStackTrace();
        }
    }

}
