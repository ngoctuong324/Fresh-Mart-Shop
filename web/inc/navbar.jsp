<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="header">
  <div class="header__container">
    <!-- Logo -->
    <div class="header__logo">
      <img src="./assets/icon/logo-1.png" alt="Fresh Mart" />
    </div>

    <!-- Navigation -->
    <nav class="nav">
      <ul class="nav__list">
        <li class="nav__item"><a href="#" class="nav__link">Trang chủ</a></li>
        <li class="nav__item"><a href="#gioi-thieu" class="nav__link">Giới thiệu</a></li>
        <li class="nav__item nav__item--dropdown">
          <a href="#" class="nav__link">Sản phẩm <i class="fa-solid fa-chevron-down"></i></a>
            <ul class="nav__dropdown">
                <c:forEach items="${listCategory}" var="c">
                    <li>
                        <a href="./home?id_category=${c.categoryID}" target="_parent">${c.categoryName}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li class="nav__item"><a href="#" class="nav__link">Tin tức</a></li>
        <li class="nav__item"><a href="#hotline" class="nav__link">Liên hệ</a></li>
      </ul>
    </nav>

    <!-- Search & Icons -->
    <div class="header__actions">
      <div class="search">
        <input type="text" class="search__input" placeholder="Tìm kiếm..." />
        <button class="search__btn" aria-label="Tìm">
          <i class="fa-solid fa-magnifying-glass"></i>
        </button>
        <ul class="search__suggestions"></ul>
      </div>
      <div class="icons">
        <a href="#" class="icons__item icons__cart" title="Giỏ hàng">
          <i class="fa-solid fa-bag-shopping"></i>
          <span class="icons__badge">0</span>
        </a>
        <a href="login.html" target="_parent" class="icons__item" title="Đăng nhập">
          <i class="fa-regular fa-user"></i>
        </a>
      </div>
    </div>
  </div>
</header>
