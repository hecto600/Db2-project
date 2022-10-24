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

    CustomerController createCustomerController(String type) {
        CustomerController cc;
        switch (type) {
            case "visualize":
                cc = new CustomerController(tfVisualizeCustomerID, taVisualizeResult);
                return cc;

            case "insert":
                cc = new CustomerController(tfInsertCustomerID, tfInsertCompanyName, tfInsertContactName,
                        tfInsertContactTitle, tfInsertAddress, tfInsertCity, tfInsertRegion, tfInsertPostalCode,
                        tfInsertCountry, tfInsertPhone, tfInsertFax, taVisualizeResult);
                return cc;

            case "update":
                cc = new CustomerController(tfUpdateCustomerID, tfUpdateCompanyName, tfUpdateContactName,
                        tfInsertContactTitle, tfUpdateAddress, tfUpdateCity, tfUpdateRegion, tfUpdatePostalCode,
                        tfUpdateCountry, tfUpdatePhone, tfUpdateFax, taVisualizeResult);
                return cc;

            case "remove":
                cc = new CustomerController(tfRemoveCustomerID, taVisualizeResult);
                return cc;

            default:
                return null;
        }

    }

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
        CustomerController customerController;
        cmd = cmd.substring(cmd.indexOf("=") + 1, cmd.indexOf(","));

        try {
            // Setting the errors message to false
            labelVisualizeErrorMessage.setVisible(false);
            labelVisualizeRequiredField.setVisible(false);
            labelVisualizeError.setVisible(false);
            labelInsertRequiredField.setVisible(false);
            labelInsertError.setVisible(false);
            labelUpdateError.setVisible(false);
            labelUpdateRequiredField.setVisible(false);
            labelRemoveError.setVisible(false);
            labelRemoveRequiredField.setVisible(false);
            final String VISUALIZE = "visualize";
            final String INSERT = "insert";
            final String UPDATE = "update";
            final String REMOVE = "remove";

            Customer c = new Customer();
            switch (cmd) {
                case "btnVisualizeCustomer":
                    customerController = createCustomerController(VISUALIZE);

                    if (tfVisualizeCustomerID.getText().isEmpty()) {
                        labelVisualizeRequiredField.setVisible(true);
                        labelVisualizeError.setVisible(true);
                    } else {
                        fullfillField(c, VISUALIZE);
                        taVisualizeResult.setText("Searched customerID: " + c.getCustomerID());
                        customerController.visualizeCustomer(c);
                        c.setCustomerID(tfVisualizeCustomerID.getText());
                    }
                    break;

                case "btnVisualizeAllCustomers":
                    customerController = createCustomerController(VISUALIZE);
                    customerController.visualizeAllCustomers();
                    break;

                case "btnInsertCustomer":
                    customerController = createCustomerController(INSERT);

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
                    customerController = createCustomerController(UPDATE);

                    if (tfUpdateCustomerID.getText().isEmpty()) {
                        labelUpdateError.setVisible(true);
                        labelUpdateRequiredField.setVisible(true);
                    } else {
                        fullfillField(c, "update");
                        customerController.updateCustomer(c);
                    }
                    break;

                case "btnRemoveCustomer":
                    customerController = createCustomerController(REMOVE);

                    if (tfRemoveCustomerID.getText().isEmpty()) {
                        labelRemoveError.setVisible(true);
                        labelRemoveRequiredField.setVisible(true);
                    } else {
                        customerController.removeCustomer(c);
                    }
                    break;
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
