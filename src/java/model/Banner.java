/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DMX
 */
public class Banner {
    int bannerID, sortOder;
    String imageURL;

    public Banner(int bannerID, String imageURL, int sortOder) {
        this.bannerID = bannerID;
        this.sortOder = sortOder;
        this.imageURL = imageURL;
    }

    public int getBannerID() {
        return bannerID;
    }

    public int getSortOder() {
        return sortOder;
    }

    public String getImageURL() {
        return imageURL;
    }
}
