/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import java.util.List;
import model.Category;

/**
 *
 * @author DMX
 */
public interface CategoryDao { // interface nó đặt ra chứ không làm - và thằng làm là implement ( impl )
    public List<Category> findAllCategory();
}