/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import java.util.List;
import model.Deal;

public interface DealDao {
    public List<Deal> findAllDeal();
    public Deal findDeal(int dealID);
    public List<Deal> findDealsByLimit(int offset, int limit);
}

