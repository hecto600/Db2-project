package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInsertCustomer;

    @FXML
    private Button btnSearchCustomer;

    @FXML
    private Button btnShowAllCustomers;

    @FXML
    private TextArea taCustomersResult;

    @FXML
    private TextField tfSearchCustomerID;

    @FXML
    void actionCustomers(ActionEvent event) {
        
    }
 

}
