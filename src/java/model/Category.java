/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Category {
    int categoryID;
    String categoryName;
    String imageURL;

    public Category(int categoryID, String categoryName, String imageURL) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.imageURL = imageURL;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getImageURL() {
        return imageURL;
    }

    
}

