/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import data.dao.ProductDao;
import data.driver.MySQLDriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductImpl implements ProductDao {

    Connection con = MySQLDriver.getConnection();

    @Override
    public List<Product> findAllProduct() {
        List<Product> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {

                // LẤY DỮ LIỆU TỪ DB
                int productID = rs.getInt("ProductID");
                int categoryID = rs.getInt("CategoryID");
                String productName = rs.getString("ProductName");
                String unit = rs.getString("Unit");
                String imageURL = rs.getString("ImageURL");
                double price = rs.getDouble("Price");
                double oldPrice = rs.getDouble("OldPrice");

                listProduct.add(new Product(
                        productID,
                        categoryID,
                        productName,
                        unit,
                        imageURL,
                        price,
                        oldPrice
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProduct;
    }

    @Override
    public Product findProduct(int id_product) {

        String sql = "SELECT * FROM products WHERE ProductID = ?";

        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, id_product);
            
            ResultSet rs = sttm.executeQuery();

            if (rs.next()) {

                int productID = rs.getInt("ProductID");
                int categoryID = rs.getInt("CategoryID");
                String productName = rs.getString("ProductName");
                String unit = rs.getString("Unit");
                String imageURL = rs.getString("ImageURL");
                double price = rs.getDouble("Price");
                double oldPrice = rs.getDouble("OldPrice");

                return new Product(
                        productID,
                        categoryID,
                        productName,
                        unit,
                        imageURL,
                        price,
                        oldPrice
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
