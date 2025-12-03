/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import java.util.List;
import model.Banner;

/**
 *
 * @author DMX
 */
public interface BannerDao {
    List<Banner> findAllBanner();
    List<Banner> findBannersByLimit(int offset, int limit);
}

