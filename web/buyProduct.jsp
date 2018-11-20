<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Purchase finished</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Purchase finished"></jsp:param>
    </jsp:include>

    <main>
        <p>You just bought ${amount} ${product.name}.</p>
    </main>

    <jsp:include page="footer.jsp"/>

</div>
</body>
</html>
