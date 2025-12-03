/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Product {
    int productID, categoryID;
    String productName, unit, imageURL;
    double price, oldPrice;

    public Product(int productID, int categoryID, String productName, String unit, String imageURL, double price, double oldPrice) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.unit = unit;
        this.imageURL = imageURL;
        this.price = price;
        this.oldPrice = oldPrice;
    }

    public int getProductID() {
        return productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnit() {
        return unit;
    }

    public String getImageURL() {
        return imageURL;
    }

    public double getPrice() {
        return price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    
}
