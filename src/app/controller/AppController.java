package app.controller;

import java.sql.SQLException;

import app.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private Button btnInsertCustomer;

    @FXML
    private Button btnRemoveCustomer;

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
    private Label labelRemoveRequiredField;

    @FXML
    private Label labelUpdateError;

    @FXML
    private Label labelUpdateRequiredField;

    @FXML
    private Label labelRemoveError;

    @FXML
    private Label labelRemoveErrorMessage;

    @FXML
    private Label labelVisualizeError;

    @FXML
    private Label labelVisualizeErrorMessage;

    @FXML
    private Label labelVisualizeRequiredField;

    @FXML
    private TextArea taVisualizeResult;

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
    private TextField tfRemoveCustomerID;

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

    void fullfillField(Customer c, String type) {
        switch (type) {
            case "visualize":
                c.setCustomerID(tfVisualizeCustomerID.getText());

                break;
            case "insert":
                c.setCustomerID(tfInsertCustomerID.getText());
                c.setCompanyName(tfInsertCompanyName.getText());
                c.setContactName(tfInsertContactName.getText());
                c.setContactTitle(tfInsertContactTitle.getText());
                c.setAddres(tfInsertAddress.getText());
                c.setCity(tfInsertCity.getText());
                c.setRegion(tfInsertRegion.getText());
                c.setPostalCode(tfInsertPostalCode.getText());
                c.setCountry(tfInsertCountry.getText());
                c.setPhone(tfInsertPhone.getText());
                c.setFax(tfInsertFax.getText());
                break;

            case "update":
                c.setCustomerID(tfUpdateCustomerID.getText());
                c.setCompanyName(tfUpdateCompanyName.getText());
                c.setContactName(tfUpdateContactName.getText());
                c.setContactTitle(tfUpdateContactTitle.getText());
                c.setAddres(tfUpdateAddress.getText());
                c.setCity(tfUpdateCity.getText());
                c.setRegion(tfUpdateRegion.getText());
                c.setPostalCode(tfUpdatePostalCode.getText());
                c.setCountry(tfUpdateCountry.getText());
                c.setPhone(tfUpdatePhone.getText());
                c.setFax(tfUpdateFax.getText());
                break;

            case "remove":
                c.setCustomerID(tfRemoveCustomerID.getText());
                break;

            default:
                break;
        }
    }

    @FXML
    void actionCustomers(ActionEvent event) {
        String cmd = event.getSource().toString();
        CustomerController customerController = new CustomerController(tfInsertCompanyName, tfInsertContactName,
                tfInsertAddress, tfInsertCity, tfInsertRegion, tfInsertPostalCode,
                tfInsertCountry, tfInsertPhone, tfInsertFax, null);
        cmd = cmd.substring(cmd.indexOf("=") + 1, cmd.indexOf(","));

        try {
            //Setting the errors message to false
            labelVisualizeErrorMessage.setVisible(false);
            labelVisualizeRequiredField.setVisible(false);
            labelVisualizeError.setVisible(false);
            labelInsertRequiredField.setVisible(false);
            labelInsertError.setVisible(false);
            labelUpdateError.setVisible(false);
            labelUpdateRequiredField.setVisible(false);
            labelRemoveError.setVisible(false);
            labelRemoveRequiredField.setVisible(false);
            Customer c = new Customer();
            switch (cmd) {
                case "btnVisualizeCustomer":
                    if (tfVisualizeCustomerID.getText().isEmpty()) {
                        labelVisualizeRequiredField.setVisible(true);
                        labelVisualizeError.setVisible(true);
                    } else {
                        fullfillField(c, "visualize");
                        taVisualizeResult.setText("Searched customerID: " + c.getCustomerID());
                        customerController.visualizeCustomer(c);
                        c.setCustomerID(tfVisualizeCustomerID.getText());
                    }
                    break;
                case "btnVisualizeAllCustomers":
                    customerController.visualizeAllCustomers();
                    break;

                case "btnInsertCustomer":
                    if (tfInsertCustomerID.getText().isEmpty()) {
                        labelInsertRequiredField.setVisible(true);
                        labelInsertError.setVisible(true);
                    } else {
                        fullfillField(c, "insert");
                        c.setCustomerID(tfInsertCustomerID.getText());
                        customerController.insertCustomer(c);
                    }
                    break;

                case "btnUpdateCustomer":
                    if (tfUpdateCustomerID.getText().isEmpty()) {
                        labelUpdateError.setVisible(true);
                        labelUpdateRequiredField.setVisible(true);
                    } else {
                        fullfillField(c, "update");
                        customerController.updateCustomer(c);
                    }
                case "btnRemoveCustomer":
                    if(tfRemoveCustomerID.getText().isEmpty()){
                        labelRemoveError.setVisible(true);
                        labelRemoveRequiredField.setVisible(true);
                    }

                default:
                    break;
            }
        } catch (ClassNotFoundException | SQLException se) {
            se.printStackTrace();
            labelVisualizeErrorMessage.setText(se.getMessage());
            labelVisualizeErrorMessage.setVisible(true);
        }
    }

}
