<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
    <h1>Historia Punktów</h1>
    <h3 class="text-right" style="color: #f86e1b">Aktualny stan konta: ${user.points} PKT</h3>
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
    <a href="${pageContext.request.contextPath}/user/reservations" class="btn btn-primary">Powrót do rezerwacji</a>
</div>
<%@include file="/footer.jsp" %>
</html>
