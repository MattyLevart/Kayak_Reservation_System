<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
    <div class="header-buttons">
        <span>Zalogowany jako: ${user.firstName}</span>
    </div>
    <h1>Szczegóły rezerwacji</h1>
    <table class="table">
        <tr>
            <th>Data</th>
            <td>${reservation.date}</td>
        </tr>
        <tr>
            <th>Godzina</th>
            <td>${reservation.hour}</td>
        </tr>
        <tr>
            <th>Miejsce startu</th>
            <td>${reservation.placeOfStart}</td>
        </tr>
        <tr>
            <th>Status rezerwacji</th>
            <td>${reservation.status}</td>
        </tr>
        <tr>
            <th>Liczba kajaków dwuosobowych</th>
            <td>${reservation.doubleKayaks}</td>
        </tr>
        <tr>
            <th>Liczba kajaków jednoosobowych</th>
            <td>${reservation.singleKayaks}</td>
        </tr>
        <tr>
            <th>Liczba kajaków z dostawką (2 dorosłych + dziecko do lat 4</th>
            <td>${reservation.babySeats}</td>
        </tr>
        <tr>
            <th>Punkty za rezerwację (dodane po zakończonym spływie)</th>
            <td>${reservation.points}</td>
        </tr>
        <tr>
            <th>Podstawowa cena rezerwacji</th>
            <td>${reservation.price} PLN</td>
        </tr>
    </table>
    <c:choose>
        <c:when test="${reservation.status != 'Zakończona'}">
            <c:choose>
                <c:when test="${reservation.status != 'Potwierdzona'}">
                    <a href="${pageContext.request.contextPath}/reservationForm?id=${reservation.id}"
                       class="btn btn-warning">Edytuj</a>
                </c:when>
            </c:choose>
            <form:form action="${pageContext.request.contextPath}/reservation/cancel" method="post"
                       style="display:inline;">
                <input type="hidden" name="reservationId" value="${reservation.id}">
                <button type="submit" class="btn btn-danger">Odwołaj</button>
            </form:form>
        </c:when>
    </c:choose>
    <a href="${pageContext.request.contextPath}/user/reservations" class="btn btn-secondary">Powrót</a>
</div>

<%@include file="/footer.jsp" %>
</html>
