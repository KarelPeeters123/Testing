<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Update Product</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Update Product"></jsp:param>
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

        <form method="post" action="Controller?action=UpdateProductSubmit" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->

            <input type="hidden" id="id" name="id" value="${fn:escapeXml(id)}" required>

            <p><label for="name">Name</label><input type="text" id="name" name="name"
                required value="${fn:escapeXml(namePreviousValue)}"></p>

            <p><label for="description">Description</label><input type="text" id="description" name="description"
                required value="${fn:escapeXml(descriptionPreviousValue)}"> </p>

            <p><label for="price">Price</label><input type="number" id="price" name="price" step="0.01"
                required value="${fn:escapeXml(pricePreviousValue)}"> </p>

            <p><input type="submit" id="save" value="Save"></p>

        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
