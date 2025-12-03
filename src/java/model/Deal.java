/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DMX
 */
public class Deal {
    int dealID, productID;
    String productName, unit , imageURL;
    double price, discountPercent, discountPrice;

    public Deal(int dealID, int productID, String productName, double price, double discountPercent, double discountPrice, String unit, String imageURL) {
        this.dealID = dealID;
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.imageURL = imageURL;
        this.price = price;
        this.discountPercent = discountPercent;
        this.discountPrice = discountPrice;
    }

    public int getDealID() {
        return dealID;
    }

    public int getProductID() {
        return productID;
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

    public double getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }
}
