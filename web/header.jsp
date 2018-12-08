<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <h1><span>Web shop</span></h1>
    <nav>
        <ul>
            <li id="<c:if test="${param.title eq 'Home'}">actual</c:if>"><a href="Controller?action=Index">Home</a></li>
            <li id="<c:if test="${param.title eq 'Overview'}">actual</c:if>"><a id="" href="Controller?action=UserOverview">Users</a></li>
            <li id="<c:if test="${param.title eq 'Product Overview'}">actual</c:if>"><a href="Controller?action=ProductOverview">Products</a></li>
            <li id="<c:if test="${param.title eq 'Add Product'}">actual</c:if>"><a href="Controller?action=ToAddProduct">Add Product</a></li>
            <li id="<c:if test="${param.title eq 'Sign Up'}">actual</c:if>"><a href="signUp.jsp">Sign up</a></li>
        </ul>
    </nav>
    <h2>${param.title}</h2>
</header>
