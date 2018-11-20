<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Check Password</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Check Password"></jsp:param>
    </jsp:include>

    <main>
        <h3>Fill out your password:</h3>

        <form method="post" action="Controller?action=ConfirmPassword&id=${fn:escapeXml(id)}">

            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required >
            </p>

            <input type="submit" id="check" value="Check">

        </form>

    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
