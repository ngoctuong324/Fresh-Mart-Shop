<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
    <c:import url="/inc/header.jsp" />
    <body>
        <c:import url="/inc/navbar.jsp" />
        <c:import url="/inc/body.jsp" />
        <c:import url="/inc/footer.jsp" />
        
        <script>
            const products = [
              <c:forEach var="p" items="${listProduct}" varStatus="i">
                {
                  name: "${p.productName}",
                  price: ${p.price},
                  oldPrice: ${p.oldPrice},
                  unit: "${p.unit}",
                  image: "<c:url value='./assets/images/${p.imageURL}'/>"
                }<c:if test="${!i.last}">,</c:if>
              </c:forEach>
            ];
        </script>
        <script src="<c:url value='/assets/js/script.js'/>"></script>
    </body>
</html>
