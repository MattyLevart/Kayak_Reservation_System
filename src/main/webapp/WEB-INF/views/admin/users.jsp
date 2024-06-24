<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="d-flex justify-content-between align-items-center">
    <h1>Twoje Dane:</h1>
    <a href="/user/add" class="btn btn-primary">Dodaj użytkownika</a>
</div>

<table class="table">
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th>Telefon</th>
        <th>Punkty</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.points}</td>
            <td><a href="/user/edit/${user.id}" class="btn btn-warning">Edytuj</a></td>
            <td><a href="/user/delete/${user.id}" class="btn btn-danger">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
<%@include file="/footer.jsp" %>
<%--</body>--%>
</html>
