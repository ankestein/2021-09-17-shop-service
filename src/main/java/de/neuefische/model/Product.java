package de.neuefische.model;

public class Product {

    private int id;
    private String productName;

    public Product(int id, String productName) {
        this.productName = productName;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", productName='" + productName + '\'';
    }
}
