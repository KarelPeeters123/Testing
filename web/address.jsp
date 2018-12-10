<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Address</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Address"></jsp:param>
    </jsp:include>

    <main>
        <c:if test="${errors != null}">
            <div class="alert-danger">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <form method="post" action="Controller?action=ConfirmAddress" novalidate="novalidate">

            <p>
                <label for="address">Address</label>
                <input type="text" id="address" name="address"
                       required value="${fn:escapeXml(addressPreviousValue)}">
            </p>

            <p>
                <label for="place">Place</label>
                <input type="text" id="place" name="place"
                       required value="${fn:escapeXml(placePreviousValue)}">
            </p>

            <p>
                <label for="postalCode">Postal code</label>
                <input type="number" id="postalCode" name="postalCode"
                       required value="${fn:escapeXml(postalCodePreviousValue)}">
            </p>

            <p>
                <label for="houseNumber">House number</label>
                <input type="number" id="houseNumber" name="houseNumber"
                       required value="${fn:escapeXml(houseNumberPreviousValue)}">
            </p>

            <p><input type="submit" id="confirm" value="Confirm"></p>

        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
