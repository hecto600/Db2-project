package app.controller;

import java.sql.SQLException;
import java.util.List;

import app.model.Order;
import app.persistence.OrderDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OrderController implements InterfaceOrderController {
    private TextArea taVisualizeOrderResult;
    private TextField tfVisualizeOrderID;

    public OrderController(TextArea taVisualizeOrderResult, TextField tfVisualizeOrderID) {
        this.taVisualizeOrderResult = taVisualizeOrderResult;
        this.tfVisualizeOrderID = tfVisualizeOrderID;
    }

    void cleanFields() {
        tfVisualizeOrderID.setText("");
    }

    @Override
    public void visualizeOrder(Order o) throws ClassNotFoundException, SQLException {
        cleanFields();

        OrderDao oDao = new OrderDao();
        Order output = oDao.visualizeOrder(o);
        if (output == null)
            taVisualizeOrderResult.setText("Searched orderID: " + o.getOrderID() + "\n\tOrder not found.");
        else
            taVisualizeOrderResult.setText("Searched orderID: " + output.getOrderID() + "\n\n" + o.toString());

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
    public Order insertOrder(Order o) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public TextField getTfVisualizeOrderID() {
        return tfVisualizeOrderID;
    }

    public void setTfVisualizeOrderID(TextField tfVisualizeOrderID) {
        this.tfVisualizeOrderID = tfVisualizeOrderID;
    }

}
