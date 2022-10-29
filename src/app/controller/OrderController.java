package app.controller;

import java.sql.SQLException;
import java.util.List;

import app.model.Order;
import app.persistence.OrderDao;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OrderController implements InterfaceOrderController {
    private TextArea taVisualizeOrderResult;
    private TextField tfVisualizeOrderID;

    private TextField tfOrdersInsertFreight;
    private TextField tfOrdersInsertShipName;
    private TextField tfOrdersInsertShipAddress;
    private TextField tfOrdersInsertShipCity;
    private TextField tfOrdersInsertShipRegion;
    private TextField tfOrdersInsertShipPostalCode;
    private TextField tfOrdersInsertShipCountry;
    private TextArea taOrdersInsertResult;

    private TextField tfOrdersDetailsInsertProductID;
    private TextField tfOrdersDetailsInsertUnitPrice;
    private TextField tfOrdersDetailsInsertQuantity;
    private TextArea taOrdersDetailsInsertResult;

    public OrderController(TextField tfOrdersInsertFreight, TextField tfOrdersInsertShipName,
            TextField tfOrdersInsertShipAddress, TextField tfOrdersInsertShipCity, TextField tfOrdersInsertShipRegion,
            TextField tfOrdersInsertShipPostalCode, TextField tfOrdersInsertShipCountry,
            TextField tfOrdersDetailsInsertProductID, TextField tfOrdersDetailsInsertUnitPrice,
            TextField tfOrdersDetailsInsertQuantity, TextArea taOrdersInsertResult,
            TextArea taOrdersDetailsInsertResult) {
        this.tfOrdersInsertFreight = tfOrdersInsertFreight;
        this.tfOrdersInsertShipName = tfOrdersInsertShipName;
        this.tfOrdersInsertShipAddress = tfOrdersInsertShipAddress;
        this.tfOrdersInsertShipCity = tfOrdersInsertShipCity;
        this.tfOrdersInsertShipRegion = tfOrdersInsertShipRegion;
        this.tfOrdersInsertShipPostalCode = tfOrdersInsertShipPostalCode;
        this.tfOrdersInsertShipCountry = tfOrdersInsertShipCountry;
        this.tfOrdersDetailsInsertProductID = tfOrdersDetailsInsertProductID;
        this.tfOrdersDetailsInsertUnitPrice = tfOrdersDetailsInsertUnitPrice;
        this.tfOrdersDetailsInsertQuantity = tfOrdersDetailsInsertQuantity;
        this.taOrdersInsertResult = taOrdersInsertResult;
        this.taOrdersDetailsInsertResult = taOrdersDetailsInsertResult;
    }

    public OrderController(TextArea taVisualizeOrderResult, TextField tfVisualizeOrderID) {
        this.taVisualizeOrderResult = taVisualizeOrderResult;
        this.tfVisualizeOrderID = tfVisualizeOrderID;
    }

    void cleanFields() {
        if(tfVisualizeOrderID != null){
            tfVisualizeOrderID.setText("");
        }
    }

    @Override
    public void visualizeOrder(Order o) throws ClassNotFoundException, SQLException {
        cleanFields();

        OrderDao oDao = new OrderDao();
        Order output = oDao.visualizeOrder(o);
        if (output == null)
            taVisualizeOrderResult.setText("Selected orderID: " + o.getOrderID() + "\n\tOrder not found.");
        else
            taVisualizeOrderResult.setText("Selected orderID: " + output.getOrderID() + "\n\n" + o.toString());

    }

    @Override
    public void visualizeOrder(Order o, String type) throws ClassNotFoundException, SQLException {
        cleanFields();
        OrderDao oDao = new OrderDao();
        oDao.visualizeOrder(o);
        taOrdersInsertResult.setText(o.toString());
        taOrdersDetailsInsertResult.setText(o.getOd().toString());

    }

    @Override
    public void visualizeAllOrders() throws ClassNotFoundException, SQLException {
        cleanFields();
        OrderDao oDao = new OrderDao();
        List<Order> oList = oDao.visualizeAllOrders();
        taVisualizeOrderResult.setText(null);

        StringBuffer buffer = new StringBuffer(
                String.format(
                        "|%-45s|" +
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
                                "%-45s|" +
                                "%-45s|" +
                                "%-45s|\n",
                        "OrderID",
                        "CustomerID", "employeeID", "orderDate", "requiredDate", "shippedDate", "shipVia", "freight",
                        "shipName",
                        "shipAddress", "shipCity", "shipRegion", "shipPostalCode", "shipCountry"));
        buffer.append(String.format(
                "+%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+" +
                        "%-45s+\n",
                "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-").replace(" ", "-"));

        for (Order o : oList) {
            buffer.append(
                    String.format(
                            "|%-45s|" +
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
                                    "%-45s|" +
                                    "%-45s|" +
                                    "%-45s|\n",
                            o.getOrderID(), o.getCustomerID(), o.getEmployeeID(), o.getOrderDate(),
                            o.getRequiredDate(), o.getShippedDate(), o.getShipVia(), o.getFreight(),
                            o.getShipName(), o.getShipAddress(), o.getShipCity(), o.getShipRegion(),
                            o.getShipPostalCode(), o.getShipCountry()));

            buffer.append(String.format(
                    "+%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+" +
                            "%-45s+\n",
                    "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-").replace(" ", "-"));

        }
        taVisualizeOrderResult.setText(buffer.toString());
    }

    @Override
    public void insertOrder(Order o) throws ClassNotFoundException, SQLException {
        OrderDao oDao = new OrderDao();
        o = oDao.insertOrder(o);
        visualizeOrder(o,"a");
    }

}
