package app.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Customer;
import app.model.Order;
import app.model.OrderDetails;
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
    private Button btnOrdersDetailsInsertAddLastOrderDetails;

    @FXML
    private Button btnOrdersInsertCreateOrder;

    @FXML
    private Button btnProcedure;

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
    private Label labelInsertErrorMessage;

    @FXML
    private Label labelOrderInsertError;

    @FXML
    private Label labelOrderInsertErrorMessage;

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
    private Label labelUpdateErrorMessage;

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
    private TextArea taOrdersDetailsInsertResult;

    @FXML
    private TextArea taOrdersInsertResult;

    @FXML
    private TextArea taProcedureResult;

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
    private TextField tfOrdersDetailsInsertProductID;

    @FXML
    private TextField tfOrdersDetailsInsertQuantity;

    @FXML
    private TextField tfOrdersDetailsInsertUnitPrice;

    @FXML
    private TextField tfOrdersInsertFreight;

    @FXML
    private TextField tfOrdersInsertShipAddress;

    @FXML
    private TextField tfOrdersInsertShipCity;

    @FXML
    private TextField tfOrdersInsertShipCountry;

    @FXML
    private TextField tfOrdersInsertShipName;

    @FXML
    private TextField tfOrdersInsertShipPostalCode;

    @FXML
    private TextField tfOrdersInsertShipRegion;

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



    final String VISUALIZE = "visualize";
    final String INSERT = "insert";
    final String UPDATE = "update";
    final String REMOVE = "remove";
    final String ORDER_DETAILS = "od";
    final String PROCEDURE = "procedure";
    OrderController orderController;

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

    void setElementsDefaultState() {
        labelVisualizeErrorMessage.setVisible(false);
        labelVisualizeRequiredField.setVisible(false);
        labelVisualizeError.setVisible(false);

        labelInsertError.setVisible(false);
        labelInsertErrorMessage.setVisible(false);

        labelUpdateError.setVisible(false);
        labelUpdateErrorMessage.setVisible(false);

        labelRemoveError.setVisible(false);
        labelRemoveRequiredField.setVisible(false);

    }

    @FXML
    void actionCustomers(ActionEvent event) {
        String cmd = event.getSource().toString();
        CustomerController customerController;
        cmd = cmd.substring(cmd.indexOf("=") + 1, cmd.indexOf(","));

        try {

            setElementsDefaultState();
            Customer c = new Customer();

            switch (cmd) {
                case "btnVisualizeCustomer":
                    customerController = createCustomerController(VISUALIZE);
                    fullfillField(c, VISUALIZE);

                    if (tfVisualizeCustomerID.getText().isEmpty()) {
                        labelVisualizeRequiredField.setVisible(true);
                        labelVisualizeError.setVisible(true);
                    } else {

                        c = customerController.visualizeCustomer(c);
                        if (c != null)
                            taVisualizeResult
                                    .setText("Searched customerID: " + c.getCustomerID() + "\n" + c.toString());
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

                    if (isFieldsNull(INSERT)) {
                        labelInsertError.setVisible(true);
                        labelInsertError.setTextFill(Color.RED);
                        labelInsertError.setText("Error: All inputs must be fullfilled! Operation aborted.");

                    } else {
                        fullfillField(c, INSERT);

                        c = customerController.insertCustomer(c);
                        taInsertResult.setText("The last customer profile inserted:\n" + c.toString());

                        labelInsertError.setVisible(true);
                        labelInsertError.setTextFill(Color.GREEN);
                        labelInsertError.setText("Customer added successfully!");

                    }
                    break;

                case "btnUpdateCustomer":
                    customerController = createCustomerController(UPDATE);

                    if (isFieldsNull(UPDATE)) {
                        labelUpdateError.setVisible(true);
                        labelUpdateError.setTextFill(Color.RED);
                        labelUpdateError.setText("Error: All inputs must be fullfilled! Operation aborted.");
                    } else {
                        fullfillField(c, UPDATE);

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
                        labelRemoveError.setTextFill(Color.RED);
                        labelRemoveRequiredField.setVisible(true);
                        labelRemoveError.setText("Invalid CustomerID!");
                    } else {
                        fullfillField(c, REMOVE);

                        c = customerController.removeCustomer(c);
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
            labelVisualizeErrorMessage.setVisible(true);
            labelVisualizeErrorMessage.setText(se.getMessage());

            labelInsertErrorMessage.setVisible(true);
            labelInsertErrorMessage.setTextFill(Color.RED);
            labelInsertErrorMessage.setText(se.getMessage());

            labelUpdateErrorMessage.setVisible(true);
            labelUpdateErrorMessage.setText(se.getMessage());

            labelRemoveErrorMessage.setVisible(true);
            labelRemoveErrorMessage.setText(se.getMessage());
        }
    }

    void orderSetElementsDefaultState() {
        labelOrderRequiredField.setVisible(false);
        labelVisualizeOrderError.setVisible(false);
        labelVisualizeOrderMessage.setVisible(false);
        labelOrderInsertError.setVisible(false);
        labelOrderInsertErrorMessage.setVisible(false);
    }

    Order createOrderController(String type) {
        TextField[] tfs;
        TextField[] tfos;
        Order o;
        OrderDetails od;

        switch (type) {
            case VISUALIZE:
                orderController = new OrderController(taVisualizeOrderResult, tfVisualizeOrderID);
                return null;
            case INSERT:
                if(tfOrdersInsertFreight.getText().isEmpty()){
                    tfOrdersInsertFreight.setText("0");
                }
                tfs = new TextField[] {tfOrdersInsertShipName,
                        tfOrdersInsertShipAddress, tfOrdersInsertShipCity, tfOrdersInsertShipRegion,
                        tfOrdersInsertShipPostalCode, tfOrdersInsertShipCountry };
                for (TextField t : tfs) {
                    if (t.getText().isEmpty()) {
                        t.setText("NULL");
                    }
                }

                o = new Order();
                o.setFreight(new BigDecimal(tfOrdersInsertFreight.getText()));
                o.setShipName(tfOrdersInsertShipName.getText());
                o.setShipAddress(tfOrdersInsertShipAddress.getText());
                o.setShipCity(tfOrdersInsertShipCity.getText());
                o.setShipRegion(tfOrdersInsertShipRegion.getText());
                o.setShipPostalCode(tfOrdersInsertShipPostalCode.getText());
                o.setShipCountry(tfOrdersInsertShipCountry.getText());

                tfos = new TextField[] {tfOrdersDetailsInsertProductID,
                        tfOrdersDetailsInsertUnitPrice, tfOrdersDetailsInsertQuantity };
                for (TextField t : tfos) {
                    if (t.getText().isEmpty()) {
                        return null;
                    }

                }

                od = new OrderDetails();
                od.setProductID(Integer.parseInt(tfOrdersDetailsInsertProductID.getText()));
                od.setUnitPrice(new BigDecimal(tfOrdersDetailsInsertUnitPrice.getText()));
                od.setQuantity(Short.parseShort(tfOrdersDetailsInsertQuantity.getText()));
                o.setOd(od);

                orderController = new OrderController(tfOrdersInsertFreight, tfOrdersInsertShipName,
                        tfOrdersInsertShipAddress, tfOrdersInsertShipCity, tfOrdersInsertShipRegion,
                        tfOrdersInsertShipPostalCode, tfOrdersInsertShipCountry, tfOrdersDetailsInsertProductID,
                        tfOrdersDetailsInsertUnitPrice, tfOrdersDetailsInsertQuantity, taOrdersInsertResult,
                        taOrdersDetailsInsertResult);
                return o;
            case ORDER_DETAILS:
                tfos = new TextField[] {tfOrdersDetailsInsertProductID,
                        tfOrdersDetailsInsertUnitPrice, tfOrdersDetailsInsertQuantity };
                for (TextField t : tfos) {
                    if (t.getText().isEmpty()) {
                        t.setText("NULL");
                    }

                }

                o = new Order();
                od = new OrderDetails();
                od.setProductID(Integer.parseInt(tfOrdersDetailsInsertProductID.getText()));
                od.setUnitPrice(new BigDecimal(tfOrdersDetailsInsertUnitPrice.getText()));
                od.setQuantity(Short.parseShort(tfOrdersDetailsInsertQuantity.getText()));
                o.setOd(od);
                orderController = new OrderController(tfOrdersInsertFreight, tfOrdersInsertShipName,
                        tfOrdersInsertShipAddress, tfOrdersInsertShipCity, tfOrdersInsertShipRegion,
                        tfOrdersInsertShipPostalCode, tfOrdersInsertShipCountry, tfOrdersDetailsInsertProductID,
                        tfOrdersDetailsInsertUnitPrice, tfOrdersDetailsInsertQuantity, taOrdersInsertResult,
                        taOrdersDetailsInsertResult);
                return o;
            case PROCEDURE:
                orderController = new OrderController(taProcedureResult);
                return null;
            default:
                return null;
        }

    }

    @FXML
    void actionOrders(ActionEvent event) {
        orderSetElementsDefaultState();

        String cmd = event.getSource().toString();
        cmd = cmd.substring(cmd.indexOf("=") + 1, cmd.indexOf(","));
        try {
            Order o;
            switch (cmd) {
                case "btnVisualizeOrder":
                    createOrderController(VISUALIZE);
                    if (tfVisualizeOrderID.getText().isEmpty()) {
                        labelOrderRequiredField.setVisible(true);
                        labelVisualizeOrderError.setVisible(true);
                    } else {
                        o = new Order();
                        o.setOrderID(Integer.parseInt(tfVisualizeOrderID.getText()));
                        orderController.visualizeOrder(o, VISUALIZE);
                    }

                    break;

                case "btnVisualizeAllOrders":
                    createOrderController(VISUALIZE);
                    orderController.visualizeAllOrders();
                    break;

                case "btnOrdersInsertCreateOrder":
                    o = createOrderController(INSERT);
                    if(o == null){
                        labelOrderInsertError.setVisible(true);
                        labelOrderInsertError.setText("Order's details fields are required.");	
                    }else{
                        orderController.insertOrder(o);
                    }
                    break;

                case "btnOrdersDetailsInsertAddLastOrderDetails":
                    o = createOrderController(ORDER_DETAILS);
                    orderController.insertOrderAddLastOrderDetails(o);
                    break;
 
                default:
                    break;
            }
        } catch (ClassNotFoundException | SQLException se) {
            se.printStackTrace();
            labelVisualizeOrderMessage.setVisible(true);
            labelVisualizeOrderMessage.setText(se.getMessage());
            labelInsertErrorMessage.setText(se.getMessage());
        }

    }

    @FXML
    void actionProcedure(ActionEvent event) {
        try {
            
            createOrderController(PROCEDURE);            
            orderController.showProcedure();
        } catch (ClassNotFoundException | SQLException se) {

        }

    }

    @FXML
    void initialize() {
        // Orders
        taVisualizeOrderResult.setStyle("-fx-font-family: monospace");
        taOrdersInsertResult.setStyle("-fx-font-family: monospace");
        taOrdersDetailsInsertResult.setStyle("-fx-font-family: monospace");
        taProcedureResult.setStyle("-fx-font-family: monospace");

        labelOrderRequiredField.setVisible(false);
        labelVisualizeOrderError.setVisible(false);
        labelVisualizeOrderMessage.setVisible(false);
        labelOrderInsertError.setVisible(false);
        labelOrderInsertErrorMessage.setVisible(false);

        // Customers
        taVisualizeResult.setStyle("-fx-font-family: monospace");
        taInsertResult.setStyle("-fx-font-family: monospace");
        taUpdateResult.setStyle("-fx-font-family: monospace");
        taRemoveResult.setStyle("-fx-font-family: monospace");

        labelVisualizeErrorMessage.setVisible(false);
        labelVisualizeRequiredField.setVisible(false);
        labelVisualizeError.setVisible(false);

        labelInsertError.setVisible(false);
        labelInsertErrorMessage.setVisible(false);

        labelUpdateError.setVisible(false);
        labelUpdateErrorMessage.setVisible(false);

        labelRemoveError.setVisible(false);
        labelRemoveErrorMessage.setVisible(false);
        labelRemoveRequiredField.setVisible(false);

    }

}
