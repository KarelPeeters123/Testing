<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Overview"></jsp:param>
    </jsp:include>

    <main>
        <table>
            <tr>
                <th>E-mail</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Delete</th>
                <th>Check password</th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${fn:escapeXml(user.email)}</td>
                    <td>${fn:escapeXml(user.firstName)}</td>
                    <td>${fn:escapeXml(user.lastName)}</td>
                    <td><a href="Controller?action=DeletePerson&id=${fn:escapeXml(user.userid)}">Delete</a></td>
                    <td><a href="Controller?action=CheckPassword&id=${fn:escapeXml(user.userid)}">Check</a></td>
                </tr>
            </c:forEach>

            <caption>Users Overview</caption>
        </table>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
