package app.model;

import java.math.BigDecimal;

public class OrderDetails {
    private int orderID;
    private int productID;
    private BigDecimal unitPrice;
    private short quantity;
    private float discount;

    @Override
    public String toString() {
        return "OrderID: " + orderID +
                "\n\tProductID: " + productID +
                "\n\tUnitPrice: " + unitPrice +
                "\n\tQuantity: " + quantity +
                "\n\tDiscount: " + discount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
