<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
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
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>

            <c:forEach var="product" items="${products}">
                <tr>
                    <td><a href="Controller?action=ToProductUpdate&id=${fn:escapeXml(product.productId)}">${fn:escapeXml(product.name)}</a></td>
                    <td>${fn:escapeXml(product.description)}</td>
                    <td>&euro; ${fn:escapeXml(product.price)}</td>
                    <td><a href="Controller?action=DeleteProduct&id=${fn:escapeXml(product.productId)}">Delete</a></td>
                </tr>
            </c:forEach>

            <caption>Product Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
