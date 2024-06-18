<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</body>
</html>
