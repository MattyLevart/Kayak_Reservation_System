<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
    <div class="header-buttons">
        <span>Zalogowany jako: ${user.firstName}</span>
    </div>
    <h1>Witamy w systemie rezerwacji kajaków</h1>
    <a href="${pageContext.request.contextPath}/reservationForm" class="btn btn-primary ml-3">Zarezerwuj kajak</a>
    <h3 class="upcoming-trips mb-4">Twoje nadchodzące spływy kajakowe:</h3>
    <table class="table">
        <tr>
            <th>Data</th>
            <th>Godzina</th>
            <th>Mijesce startu</th>
            <th>Status rezerwacji</th>
        </tr>
        <tr>
            <c:forEach var="reservation" items="${reservs}">
            <td>${reservation.date}</td>
                <td>${reservation.hour}</td>
                <td>${reservation.placeOfStart}</td>
                <td>${reservation.status}</td>
            </c:forEach>
        </tr>
    </table>
</div>

<%@include file="/footer.jsp" %>
</html>
