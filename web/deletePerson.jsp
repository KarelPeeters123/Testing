<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Delete Person</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Delete Person"></jsp:param>
    </jsp:include>

    <main>
        <h3>Are you sure?</h3>

        <form method="post" action="Controller?action=ConfirmDeletePerson&id=${fn:escapeXml(id)}">
            <input type="submit" id="ok" value="Ok">
        </form>

        <form method="post" action="Controller?action=UserOverview">
            <input type="submit" id="cancel" value="Cancel">
        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>