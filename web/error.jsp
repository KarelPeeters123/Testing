<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Error"></jsp:param>
    </jsp:include>

    <main>
        <article>
            <p>Description: ${fn:escapeXml(pageContext.exception)}</p>
            <p><a href="Controller">Home</a></p>
        </article>
    </main>

    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
