/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.dao.BannerDao;
import data.dao.Database;
import data.impl.BannerImpl;
import data.dao.DealDao;
import data.impl.DealImpl;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import model.Banner;
import model.Category;
import model.Deal;
import model.Product;

/**
 *
 * @author DMX
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // --- Lấy danh sách Category ---
        List<Category> listCategory = Database.getCategoryDao().findAllCategory();
        request.setAttribute("listCategory", listCategory);

        List<Product> listProduct = Database.getProductDao().findAllProduct();
        request.setAttribute("listProduct", listProduct);
        
        // --- Lấy Deals hôm nay ---
        DealDao dealDao = new DealImpl();
        int dealsInDay = 5;

        List<Deal> allDeals = dealDao.findAllDeal();
        int totalDeals = allDeals.size();

        List<Deal> dealsToday = new ArrayList<>();

        if (totalDeals > 0) {
            dealsInDay = Math.min(dealsInDay, totalDeals);

            LocalDate today = LocalDate.now();
            long daysSinceStart = ChronoUnit.DAYS.between(LocalDate.of(2025, 1, 1), today);
            // Tính vị trí bắt đầu
            int offsetDeal = (int) ((daysSinceStart * dealsInDay) % totalDeals);

            // Lấy danh sách theo LIMIT offset, dealsInDay
            dealsToday = dealDao.findDealsByLimit(offsetDeal, dealsInDay);

            // Nếu offset ở gần cuối → không đủ số lượng → cần lấy thêm từ đầu (giống vòng tròn)
            if (dealsToday.size() < dealsInDay) {
                int remaining = dealsInDay - dealsToday.size();

                List<Deal> extra = dealDao.findDealsByLimit(0, remaining);
                dealsToday.addAll(extra);
            }
        }
        request.setAttribute("listDeal", dealsToday);

        // --- Lấy Banner hôm nay ---
        BannerDao bannerDao = new BannerImpl();
        int bannersInDay = 2;

        List<Banner> allBanners = bannerDao.findAllBanner();
        int totalBanners = allBanners.size();

        List<Banner> bannersToday = new ArrayList<>();
        if (totalBanners > 0) {
            bannersInDay = Math.min(bannersInDay, totalBanners);

            LocalDate today = LocalDate.now();
            long daysSinceStart = ChronoUnit.DAYS.between(LocalDate.of(2025, 1, 1), today);
            int offsetBanner = (int) ((daysSinceStart * bannersInDay) % totalBanners);

            bannersToday = bannerDao.findBannersByLimit(offsetBanner, bannersInDay);
        }
        request.setAttribute("listBanner", bannersToday);

        // --- Title ---
        request.setAttribute("title", "Fresh Mart - Thực phẩm sạch");

        // --- Lấy id_category nếu có ---
        String id_category = request.getParameter("id_category");
        request.setAttribute("id_category", id_category);

        // --- Chuyển tiếp sang JSP ---
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
