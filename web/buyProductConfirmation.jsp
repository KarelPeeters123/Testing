<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Buy product</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Buy product"></jsp:param>
    </jsp:include>

    <main>

        <h3>Overview</h3>

        <p>User: ${user}</p>
        <p>Product: ${product.name}</p>
        <p>Description: ${product.description}</p>
        <p>Price: € ${product.price}</p>

        <form method="post" action="Controller?action=BuyProduct&id=${fn:escapeXml(product.productId)}"
              novalidate="novalidate">
            <p>
                <label for="amount">Amount</label>
                <input type="number" id="amount" name="amount" required>
            </p>
            <p>
                <input type="submit" id="buy" value="Buy">
            </p>
        </form>

    </main>

    <jsp:include page="footer.jsp"/>

</div>
</body>
</html>
