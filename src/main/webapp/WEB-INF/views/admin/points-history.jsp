<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="d-flex justify-content-between align-items-center">
    <h1>Historia punktów</h1>
<%--    <a href="/user/add" class="btn btn-primary">Dodaj użytkownika</a>--%>
</div>
<table class="table">
    <tr>
        <th>Data</th>
        <th>Punkty</th>
        <th>Typ</th>
    </tr>
    <c:forEach var="history" items="${pointsHistories}">
        <tr>
            <td>${history.date}</td>
            <td>${history.points}</td>
            <td>${history.type}</td>
        </tr>
    </c:forEach>
</table>
<%@include file="/footer.jsp" %>
</html>
