<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">

    <h1>Rezerwacje</h1>
    <h3>Rezerwacje oczekujące</h3>

    <table class="table">
        <tr>
            <th>Data</th>
            <th>Godzina</th>
            <th>Miejsce startu</th>
            <th>Status</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="reservation" items="${waitingReservations}">
            <tr>
                <td>${reservation.date}</td>
                <td>${reservation.hour}</td>
                <td>${reservation.placeOfStart}</td>
                <td>${reservation.status}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/reservation/details?id=${reservation.id}" class="btn btn-info btn-sm">Szczegóły</a>
<%--                    <a href="${pageContext.request.contextPath}/admin/reservation/edit?id=${reservation.id}" class="btn btn-warning btn-sm">Edytuj</a>--%>
                    <form:form action="${pageContext.request.contextPath}/admin/reservation/confirm" method="post" style="display:inline;">
                        <input type="hidden" name="reservationId" value="${reservation.id}">
                        <button type="submit" class="btn btn-primary btn-sm">Potwierdź</button>
                    </form:form>
                    <form:form action="${pageContext.request.contextPath}/admin/reservation/cancel" method="post" style="display:inline;">
                        <input type="hidden" name="reservationId" value="${reservation.id}">
                        <button type="submit" class="btn btn-danger btn-sm">Odwołaj</button>
                    </form:form>

<%--                    <form:form action="${pageContext.request.contextPath}/admin/reservation/cancel" method="post" style="display:inline;">--%>
<%--                        <input type="hidden" name="reservationId" value="${reservation.id}">--%>
<%--                        <button type="submit" class="btn btn-danger btn-sm">Odwołaj</button>--%>
<%--                    </form:form>--%>

                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Potwierdzone</h3>
    <table class="table">
        <tr>
            <th>Data</th>
            <th>Godzina</th>
            <th>Miejsce startu</th>
            <th>Status</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="reservation" items="${confirmedReservations}">
            <tr>
                <td>${reservation.date}</td>
                <td>${reservation.hour}</td>
                <td>${reservation.placeOfStart}</td>
                <td>${reservation.status}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/reservation/details?id=${reservation.id}" class="btn btn-info btn-sm">Szczegóły</a>
                    <form:form action="${pageContext.request.contextPath}/admin/reservation/cancel" method="post" style="display:inline;">
                        <input type="hidden" name="reservationId" value="${reservation.id}">
                        <button type="submit" class="btn btn-danger btn-sm">Odwołaj</button>
                    </form:form>
                    <form:form action="${pageContext.request.contextPath}/admin/reservation/complete" method="post" style="display:inline;">
                        <input type="hidden" name="reservationId" value="${reservation.id}">
                        <button type="submit" class="btn btn-success btn-sm">Zakończ</button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="/footer.jsp" %>
</html>