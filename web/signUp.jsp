<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Sign Up"></jsp:param>
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

        <form method="post" action="Controller?action=SignUp" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="userid">User id</label><input type="text" id="userid" name="userid"
                                                         required value="${fn:escapeXml(userIdPreviousValue)}"></p>

            <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"
                                                               required value="${fn:escapeXml(firstNamePreviousValue)}">
            </p>

            <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"
                                                             required value="${fn:escapeXml(lastNamePreviousValue)}">
            </p>

            <p><label for="email">Email</label><input type="email" id="email" name="email"
                                                      required value="${fn:escapeXml(emailPreviousValue)}"></p>

            <p><label for="password">Password</label><input type="password" id="password" name="password"
                                                            required></p>

            <p><input type="submit" id="signUp" value="Sign Up"></p>

        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
