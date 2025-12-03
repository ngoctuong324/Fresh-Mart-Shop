/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import data.dao.CategoryDao;
import data.driver.MySQLDriver;
import java.util.List;
import model.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryImpl implements CategoryDao {

    @Override
    public List<Category> findAllCategory() {
        List<Category> listCategory = new ArrayList<>();
        Connection con = MySQLDriver.getConnection();
        String sql = "SELECT * FROM categories";

        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {

                int categoryID = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");
                String imageURL = rs.getString("ImageURL");

                listCategory.add(new Category(categoryID, categoryName, imageURL));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listCategory;
    }
}
