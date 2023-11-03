package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Product implements Comparable<Product> {

    //khai bao thuoc tinh chung
    private String productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private double version;
    private Date productManufacturingDate;

    //ham khoi tao
    public Product() {
    }

    public Product(String id) {
        this.productID = id;
    }

    public Product(String productID, String productName, double unitPrice, int quantity, double version, Date productManufacturingDate) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.version = version;
        this.productManufacturingDate = productManufacturingDate;
    }

    //get-set
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public Date getProductManufacturingDate() {
        return productManufacturingDate;
    }

    public void setProductManufacturingDate(Date productManufacturingDate) {
        this.productManufacturingDate = productManufacturingDate;
    }

    //toString
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "ID=" + productID + ", Name=" + productName + ", UnitPrice="
                + unitPrice + ", Quantity=" + quantity + ", Version=" + version
                + ", ProductManufacturingDate=" + dateFormat.format(productManufacturingDate) + "\n";
    }
    
    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.productID, other.productID);
    }

    //compareTo
    @Override
    public int compareTo(Product o) {
        return this.getProductName().compareTo(o.productName);
    }

}
