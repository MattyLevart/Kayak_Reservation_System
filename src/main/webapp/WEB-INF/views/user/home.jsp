<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Witamy w systemie rezerwacji kajaków</h1>
    <a href="${pageContext.request.contextPath}/reservationForm" class="btn btn-primary">Zarezerwuj kajak</a>
    <c:choose>
        <c:when test="${not empty principal}">
            <a href="${pageContext.request.contextPath}/user/home" class="btn btn-secondary">Moje konto</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Zaloguj się</a>
            <a href="${pageContext.request.contextPath}/register" class="btn btn-secondary">Załóż konto</a>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
