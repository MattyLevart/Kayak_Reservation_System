<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <th>Miejsce startu</th>
            <th>Status rezerwacji</th>
            <th>Do zapłaty</th>
            <th>Punkty</th>
        </tr>
            <c:forEach var="reservation" items="${reservs}">
        <tr>
            <td>${reservation.date}</td>
            <td>${reservation.hour}</td>
            <td>${reservation.placeOfStart}</td>
            <td>${reservation.status}</td>
            <td>${reservation.price} PLN</td>
            <td>
                <c:choose>
                    <c:when test="${reservation.status == 'Oczekuje na potwierdzenie' || reservation.status == 'Potwierdzona'}">
                        ${reservation.points} (dodane po zakończonym spływie)
                    </c:when>
                    <c:otherwise>
                        ${reservation.points}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/reservation/details" class="btn btn-info btn-sm">Szczegóły</a>
                <a href="${pageContext.request.contextPath}/reservationForm?id=${reservation.id}" class="btn btn-warning btn-sm">Edytuj</a>
                <form:form action="${pageContext.request.contextPath}/reservation/cancel" method="post" style="display:inline;">
                    <input type="hidden" name="reservationId" value="${reservation.id}">
                    <button type="submit" class="btn btn-danger btn-sm">Odwołaj</button>
                </form:form>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

<%@include file="/footer.jsp" %>
</html>
