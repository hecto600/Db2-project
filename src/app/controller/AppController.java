package app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
    private Button btnVisualizeAllOrders;

    @FXML
    private Button btnVisualizeCustomer;

    @FXML
    private Button btnVisualizeOrder;

    @FXML
    private Label labelInsertError;

    @FXML
    private Label labelOrderRequiredField;

    @FXML
    private Label labelRemoveError;

    @FXML
    private Label labelRemoveErrorMessage;

    @FXML
    private Label labelRemoveRequiredField;

    @FXML
    private Label labelUpdateError;

    @FXML
    private Label labelVisualizeError;

    @FXML
    private Label labelVisualizeErrorMessage;

    @FXML
    private Label labelVisualizeOrderError;

    @FXML
    private Label labelVisualizeOrderMessage;

    @FXML
    private Label labelVisualizeRequiredField;

    @FXML
    private TextArea taInsertResult;

    @FXML
    private TextArea taRemoveResult;

    @FXML
    private TextArea taUpdateResult;

    @FXML
    private TextArea taVisualizeOrderResult;

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

    @FXML
    private TextField tfVisualizeOrderID;

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
                c.setAddress(tfInsertAddress.getText());
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
                c.setAddress(tfUpdateAddress.getText());
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

    boolean isFieldsNull(String type) {
        switch (type) {
            case "insert":
                List<TextField> a = new ArrayList<TextField>();
                a.add(tfInsertCustomerID);
                a.add(tfInsertCompanyName);
                a.add(tfInsertContactName);
                a.add(tfInsertContactTitle);
                a.add(tfInsertAddress);
                a.add(tfInsertCity);
                a.add(tfInsertRegion);
                a.add(tfInsertPostalCode);
                a.add(tfInsertCountry);
                a.add(tfInsertPhone);
                a.add(tfInsertFax);

                for (TextField textField : a) {
                    if (textField.getText().isEmpty()) {
                        return true;
                    }
                }
                return false;
            case "update":
                List<TextField> b = new ArrayList<TextField>();
                b.add(tfUpdateCustomerID);
                b.add(tfUpdateCompanyName);
                b.add(tfUpdateContactName);
                b.add(tfUpdateContactTitle);
                b.add(tfUpdateAddress);
                b.add(tfUpdateCity);
                b.add(tfUpdateRegion);
                b.add(tfUpdatePostalCode);
                b.add(tfUpdateCountry);
                b.add(tfUpdatePhone);
                b.add(tfUpdateFax);

                for (TextField textField : b) {
                    if (textField.getText().isEmpty()) {
                        return true;
                    }
                }
            default:
                break;
        }
        return false;

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
            labelInsertError.setVisible(false);
            labelUpdateError.setVisible(false);
            labelRemoveError.setVisible(false);
            labelRemoveRequiredField.setVisible(false);
            final String VISUALIZE = "visualize";
            final String INSERT = "insert";
            final String UPDATE = "update";
            final String REMOVE = "remove";
            taVisualizeResult.setStyle("-fx-font-family: monospace");
            Customer c = new Customer();
            switch (cmd) {
                case "btnVisualizeCustomer":
                    customerController = createCustomerController(VISUALIZE);
                    fullfillField(c, VISUALIZE);
                    if (tfVisualizeCustomerID.getText().isEmpty()) {
                        labelVisualizeRequiredField.setVisible(true);
                        labelVisualizeError.setVisible(true);
                    } else {

                        taVisualizeResult.setText("Searched customerID: " + c.getCustomerID());
                        c = customerController.visualizeCustomer(c);
                        if (c != null)
                            taVisualizeResult.setText(c.toString());
                        else
                            taVisualizeResult.setText("Customer not found.");
                    }

                    break;

                case "btnVisualizeAllCustomers":
                    customerController = createCustomerController(VISUALIZE);
                    taVisualizeResult.setText(customerController.visualizeAllCustomers());
                    break;

                case "btnInsertCustomer":
                    customerController = createCustomerController(INSERT);

                    if (isFieldsNull("insert")) {
                        labelInsertError.setVisible(true);
                        labelInsertError.setTextFill(Color.RED);
                        labelInsertError.setText("Error: All inputs must be fullfilled! Operation aborted.");

                    } else {
                        fullfillField(c, "insert");

                        c = customerController.insertCustomer(c);
                        taInsertResult.setText("The last customer profile inserted:\n" + c.toString());

                        labelInsertError.setVisible(true);
                        labelInsertError.setTextFill(Color.GREEN);
                        labelInsertError.setText("Customer added successfully!");
                        
                    }
                    break;

                case "btnUpdateCustomer":
                    customerController = createCustomerController(UPDATE);

                    if (isFieldsNull("update")) {
                        labelUpdateError.setVisible(true);
                        labelUpdateError.setTextFill(Color.RED);
                        labelUpdateError.setText("Error: All inputs must be fullfilled! Operation aborted.");
                    } else {
                        fullfillField(c, "update");

                        c = customerController.updateCustomer(c);
                        taUpdateResult.setText("The last customer profile updated:\n" + c.toString());


                        labelUpdateError.setVisible(true);
                        labelUpdateError.setTextFill(Color.GREEN);
                        labelUpdateError.setText("Customer updated successfully!");
                    }
                    break;

                case "btnRemoveCustomer":
                    customerController = createCustomerController(REMOVE);

                    if (tfRemoveCustomerID.getText().isEmpty()) {
                        labelRemoveError.setVisible(true);
                        labelRemoveRequiredField.setVisible(true);
                        labelRemoveError.setText("Invalid CustomerID!");
                    } else {
                        fullfillField(c, REMOVE);

                        customerController.removeCustomer(c);
                        taRemoveResult.setText("The last customer profile deleted:\n" + c.toString());


                        labelRemoveError.setVisible(true);
                        labelRemoveError.setTextFill(Color.GREEN);
                        labelRemoveError.setText("Customer removed successfully!");
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
