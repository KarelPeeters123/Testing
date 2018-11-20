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

    <jsp:include page="header.jsp"/>


    <main>
        <p><b>${product.name}</b></p>
        <form method="post" action="Controller?action=buyProduct" novalidate="novalidate">

            <p><label for="amountBuy">Amount</label><input type="number" id="amountBuy" name="amount"
                                                                   required value="${fn:escapeXml(pricePreviousValue)}"> </p>
            <p><input type="submit" id="buy" value="buy"></p>

        </form>
            <caption>Buy product confirmation</caption>

    </main>

    <jsp:include page="footer.jsp"/>

</div>
</body>
</html>