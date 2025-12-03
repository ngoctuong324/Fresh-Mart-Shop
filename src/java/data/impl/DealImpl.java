package data.impl;

import data.dao.DealDao;
import data.driver.MySQLDriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Deal;

public class DealImpl implements DealDao {

    private Connection con = MySQLDriver.getConnection();

    @Override
    public List<Deal> findAllDeal() {
        List<Deal> listDeal = new ArrayList<>();
        String sql = "SELECT * FROM deals";

        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {
                int dealID = rs.getInt("dealID");
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                double discountPercent = rs.getDouble("discountPercent");
                double discountPrice = rs.getDouble("discountPrice");
                String unit = rs.getString("unit");
                String imageURL = rs.getString("imageURL");

                listDeal.add(new Deal(
                        dealID,
                        productID,
                        productName,
                        price,
                        discountPercent,
                        discountPrice,
                        unit,
                        imageURL
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DealImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDeal;
    }

    @Override
    public Deal findDeal(int dealID) {
        String sql = "SELECT * FROM deals WHERE dealID = ?";

        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, dealID);
            
            ResultSet rs = sttm.executeQuery();

            if (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                double discountPercent = rs.getDouble("discountPercent");
                double discountPrice = rs.getDouble("discountPrice");
                String unit = rs.getString("unit");
                String imageURL = rs.getString("imageURL");

                return new Deal(
                        dealID,
                        productID,
                        productName,
                        price,
                        discountPercent,
                        discountPrice,
                        unit,
                        imageURL
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(DealImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
