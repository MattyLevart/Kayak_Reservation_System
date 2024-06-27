<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
    <h1>Archiwum Rezerwacji</h1>

    <h3>Zakończone</h3>
    <table class="table">
        <tr>
            <th>Data</th>
            <th>Godzina</th>
            <th>Miejsce startu</th>
            <th>Status</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="reservation" items="${completedReservations}">
            <tr>
                <td>${reservation.date}</td>
                <td>${reservation.hour}</td>
                <td>${reservation.placeOfStart}</td>
                <td>${reservation.status}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/reservation/details?id=${reservation.id}" class="btn btn-info btn-sm">Szczegóły</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Odwołane</h3>
    <table class="table">
        <tr>
            <th>Data</th>
            <th>Godzina</th>
            <th>Miejsce startu</th>
            <th>Status</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="reservation" items="${cancelledReservations}">
            <tr>
                <td>${reservation.date}</td>
                <td>${reservation.hour}</td>
                <td>${reservation.placeOfStart}</td>
                <td>${reservation.status}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/reservation/details?id=${reservation.id}" class="btn btn-info btn-sm">Szczegóły</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/admin/home" class="btn btn-primary">Powrót do panelu admina</a>
</div>


<%@include file="/footer.jsp" %>
</html>