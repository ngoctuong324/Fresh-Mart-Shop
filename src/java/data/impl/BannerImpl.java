/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import data.dao.BannerDao;
import data.driver.MySQLDriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Banner;

public class BannerImpl implements BannerDao {

    @Override
    public List<Banner> findAllBanner() {
        List<Banner> listBanner = new ArrayList<>();
        String sql = "SELECT * FROM banners ORDER BY SortOrder ASC";

        try (Connection con = MySQLDriver.getConnection();
             PreparedStatement sttm = con.prepareStatement(sql);
             ResultSet rs = sttm.executeQuery()) {

            while (rs.next()) {
                int bannerID = rs.getInt("BannerID");
                String imageURL = rs.getString("ImageURL");
                int sortOrder = rs.getInt("SortOrder");

                listBanner.add(new Banner(bannerID, imageURL, sortOrder));
            }

        } catch (Exception ex) {
            Logger.getLogger(BannerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listBanner;
    }

    @Override
    public List<Banner> findBannersByLimit(int offset, int limit) {
        List<Banner> listBanner = new ArrayList<>();
        String sql = "SELECT * FROM banners ORDER BY SortOrder ASC LIMIT ?, ?";

        try (Connection con = MySQLDriver.getConnection();
             PreparedStatement sttm = con.prepareStatement(sql)) {

            sttm.setInt(1, offset); //gán vị trí bắt đầu lấy banner
            sttm.setInt(2, limit); //gán số lượng banner cần lấy

            try (ResultSet rs = sttm.executeQuery()) {
                while (rs.next()) {
                    int bannerID = rs.getInt("BannerID");
                    String imageURL = rs.getString("ImageURL");
                    int sortOrder = rs.getInt("SortOrder");

                    listBanner.add(new Banner(bannerID, imageURL, sortOrder));
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(BannerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listBanner;
    }
}
