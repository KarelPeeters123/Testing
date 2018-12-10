<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Cart</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Cart"></jsp:param>
    </jsp:include>

    <main>
        <c:choose>
            <c:when test="${products==null}">
                <p>Your cart is empty.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Qty</th>
                    </tr>

                    <c:forEach var="entry" items="${products}">
                        <tr>
                            <td>${fn:escapeXml(entry.key.name)}</td>
                            <td>${fn:escapeXml(entry.key.description)}</td>
                            <td>&euro; ${fn:escapeXml(entry.key.price)}</td>
                            <td>${entry.value}</td>
                        </tr>
                    </c:forEach>
                </table>

                <br><br>
                <p>Total amount: &euro; ${total}</p>

                <form method="post" action="Controller?action=Buy" novalidate="novalidate">
                    <p><input type="submit" id="buy" value="Buy"></p>
                </form>

            </c:otherwise>
        </c:choose>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
