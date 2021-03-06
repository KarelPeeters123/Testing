<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Home"></jsp:param>
    </jsp:include>

    <main>

        <c:choose>
            <c:when test="${!loggedIn}">
                <h3>Log in</h3>

                <c:if test="${error != null}">
                    <div class="alert-danger">
                        <p>${error}</p>
                    </div>
                </c:if>

                <form method="post" action="Controller?action=Login" novalidate="novalidate">
                    <p>
                        <label for="userid">User id</label>
                        <input type="text" id="userid" name="userid" required>
                    </p>
                    <p>
                        <label for="passwd">Password</label>
                        <input type="password" id="passwd" name="passwd" required>
                    </p>
                    <p>
                        <input type="submit" id="login" value="Log in">
                    </p>
                </form>
            </c:when>
            <c:otherwise>
                <p>Welcome, ${sessionScope.user.firstName}.</p>
                <form method="post" action="Controller?action=Logout" novalidate="novalidate">
                    <p>
                        <input type="submit" id="logOut" value="Log out">
                    </p>
                </form>
            </c:otherwise>
        </c:choose>
    </main>

    <jsp:include page="footer.jsp"/>

</div>
</body>
</html>
