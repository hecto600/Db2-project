package app.model;

import java.math.BigDecimal;

public class Product {
    private int productID;
    private String productName;
    private int supplierID;
    private int categoryID;
    private String quantityPerUnity;
    private BigDecimal unitPrice;
    private short unitsInStock;
    private short unitsOnOrder;
    private short reorderLevel;
    private boolean discontinued;

}
