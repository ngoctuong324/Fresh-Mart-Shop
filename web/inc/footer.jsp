<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!-- FOOTER -->
        <footer class="footer">
          <div class="container footer__container">
            <!-- About -->
            <div class="footer__section footer__about">
              <img
                src="./assets/icon/logo-1.png"
                alt="Fresh Mart"
                class="footer__logo"
              />
              <p class="footer__text">
                Fresh Mart cung cấp thực phẩm sạch, tươi ngon và hữu cơ, đảm bảo sức
                khỏe cho bạn và gia đình.
              </p>
            </div>

            <!-- Quick Links -->
            <div class="footer__section footer__links">
              <h3 class="footer__title">Liên kết nhanh</h3>
              <ul class="footer__list">
                <li><a href="#" class="footer__link">Trang chủ</a></li>
                <li><a href="#gioi-thieu" class="footer__link">Giới thiệu</a></li>
                <c:forEach items="${listCategory}" var="c">
                  <li><a href="#products-${c.categoryID}" class="footer__link">${c.categoryName}</a></li>
                </c:forEach>
              </ul>
            </div>

            <!-- Contact -->
            <div id="hotline" class="footer__section footer__contact">
              <h3 class="footer__title">Liên hệ</h3>
              <p class="footer__text">
                <i class="fa-solid fa-location-dot"></i> 26/73 Trần Quý Khoáng
              </p>
              <p class="footer__text">
                <i class="fa-solid fa-phone"></i> 0399 030 204
              </p>
              <p class="footer__text">
                <i class="fa-solid fa-envelope"></i> 22t1020505@husc.edu.vn
              </p>
              <div class="footer__socials">
                <a href="#" class="footer__social"
                  ><i class="fa-brands fa-facebook-f"></i
                ></a>
                <a href="#" class="footer__social"
                  ><i class="fa-brands fa-instagram"></i
                ></a>
                <a href="#" class="footer__social"
                  ><i class="fa-brands fa-twitter"></i
                ></a>
                <a href="#" class="footer__social"
                  ><i class="fa-brands fa-youtube"></i
                ></a>
              </div>
            </div>
          </div>
        </footer>
