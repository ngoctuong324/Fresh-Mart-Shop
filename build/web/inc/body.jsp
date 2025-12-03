<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <!-- BANNER -->
    <section class="banner" role="img" aria-label="Banner thực phẩm">
      <div class="banner__content">
        <h1 class="banner__title">Thực phẩm Sạch - Tươi - Ngon</h1>
        <p class="banner__subtitle">
          Chúng tôi cung cấp sản phẩm hữu cơ chất lượng cao
        </p>
      </div>
    </section>

    <!-- CATEGORIES -->
    <section id="gioi-thieu" class="categories">
      <div class="container categories__container">
        <c:forEach items="${listCategory}" var="c">
            <article class="category-card">
                <a href="#products-${c.categoryID}">
                    <img src="./assets/images/${c.imageURL}" 
                         alt="${c.categoryName}" class="category-card__img"/>
                    <h3 class="category-card__title">${c.categoryName}</h3>
                </a>
            </article>
        </c:forEach>
      </div>
    </section>

    <section class="deals">
      <div class="deals__header">
        <i class="fa-solid fa-fire deals__icon"></i>
        <h2 class="deals__title">Ưu đãi trong ngày</h2>
      </div>
      <div class="deals__list">
        <c:forEach items="${listDeal}" var="d">
          <article class="deal-card">
            <span class="deal-card__badge">
              <fmt:formatNumber value="-${d.discountPercent}" type="number" maxFractionDigits="2" />%
            </span>
            <img src="./assets/images/${d.imageURL}" alt="${d.productName}" class="deal-card__img" />
            <h3 class="deal-card__name">${d.productName}</h3>
            <p class="deal-card__price"> <fmt:formatNumber value="${d.price * (1 - (d.discountPercent / 100.0))}" type="currency" currencySymbol="VNĐ" /> / ${d.unit} </p>
            <span style="text-decoration: line-through; color: gray; font-size: 0.85em; display: block;"> <fmt:formatNumber value="${d.price}" type="currency" currencySymbol="VNĐ" /> </span>
            <button class="p-card__btn">Add to Cart</button>
          </article>
        </c:forEach>
      </div>
    </section>



    <!-- PROMO BANNERS -->
    <section class="promo">
        <div class="promo__header">
            <i class="fa-solid fa-fire promo__icon"></i>
            <h2 class="promo__title">Chương trình</h2>
        </div>
        <c:forEach items="${listBanner}" var="b">
            <div class="promo__item">
                <img src="./assets/images/${b.imageURL}" alt="Banner ${b.bannerID}" class="promo__img" />
            </div>
        </c:forEach>
    </section>

    <!-- CATEGORY BLOCKS -->
    <c:forEach items="${listCategory}" var="c">
      <section class="category-block" id="products-${c.categoryID}">
        <div class="category-block__header">
          <i class="fa-solid fa-leaf category-block__icon"></i>
          <h2 class="category-block__title">${c.categoryName}</h2>
        </div>
        <div class="category-block__list">
          <c:forEach items="${listProduct}" var="p">
            <c:if test="${p.categoryID eq c.categoryID}">
              <article class="p-card">
                <img src="./assets/images/${p.imageURL}" class="p-card__img" alt="${p.productName}" />
                <h3 class="p-card__name">${p.productName}</h3>
                <p class="p-card__price">
                  <fmt:formatNumber value="${p.price}" type="number" maxFractionDigits="2" />đ / ${p.unit} </p>  <!-- Note: maxFractionDigits ==> hiển thị tối đa 2 chữ số thập phân -->
                <button class="p-card__btn">Add to Cart</button>
              </article>
            </c:if>
          </c:forEach>
        </div>
      </section>
    </c:forEach>

