<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Product Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Product Overview"></jsp:param>
    </jsp:include>

    <main>
        <c:if test="${error != null}">
            <div class="alert-danger">
                <p>${error}</p>
            </div>
        </c:if>

        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>

            <c:forEach var="product" items="${products}">
                <tr>
                    <c:choose>
                        <c:when test="${sessionScope.user.role=='ADMIN'}">
                            <td>
                                <a href="Controller?action=ToProductUpdate&id=${fn:escapeXml(product.productId)}">${fn:escapeXml(product.name)}</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>${fn:escapeXml(product.name)}</td>
                        </c:otherwise>
                    </c:choose>

                    <td>${fn:escapeXml(product.description)}</td>
                    <td>&euro; ${fn:escapeXml(product.price)}</td>
                    <c:if test="${sessionScope.user.role=='ADMIN'}">
                        <td>
                            <a href="Controller?action=DeleteProduct&id=${fn:escapeXml(product.productId)}">Delete</a>
                        </td>
                    </c:if>
                    <td>
                        <form id="overviewForm" method="post" action="Controller?action=AddToCart" novalidate>
                            <input type="hidden" id="id" name="id" value="${fn:escapeXml(product.productId)}">
                            <input type="number" id="quantity" name="quantity" value="1" required>
                            <input type="submit" id="addToCart" value="Add To Cart">
                        </form>
                    </td>
                </tr>
            </c:forEach>

            <caption>Product Overview</caption>
        </table>

        <p>Shopping cart (${total})</p>

    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
