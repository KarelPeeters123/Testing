<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Order successful</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Order successful"></jsp:param>
    </jsp:include>

    <main>
        <p>Order carried out successfully.</p>
        <p>Your products will arrive at ${fn:escapeXml(address)} in 2 to 3 workdays.</p>

        <br><br>
        <p><a href="Controller?action=ClearCart">Return to cart</a></p>
    </main>

    <jsp:include page="footer.jsp"/>

</div>
</body>
</html>
