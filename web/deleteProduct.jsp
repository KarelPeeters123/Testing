<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Delete Product</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Delete Product"></jsp:param>
    </jsp:include>

    <main>
        <h3>Are you sure?</h3>

        <form method="post" action="Controller?action=ConfirmDeleteProduct&id=${fn:escapeXml(id)}">
            <input type="submit" id="ok" value="Ok">
        </form>

        <form method="post" action="Controller?action=ProductOverview">
            <input type="submit" id="cancel" value="Cancel">
        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
