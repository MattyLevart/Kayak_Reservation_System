<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>

<div class="container">
    <h1>Szczegóły Rezerwacji</h1>

    <h3>Informacje o Rezerwacji</h3>
    <table class="table">
        <tr>
            <th>Data:</th>
            <td>${reservation.date}</td>
        </tr>
        <tr>
            <th>Godzina:</th>
            <td>${reservation.hour}</td>
        </tr>
        <tr>
            <th>Miejsce startu:</th>
            <td>${reservation.placeOfStart}</td>
        </tr>
        <tr>
            <th>Status:</th>
            <td>${reservation.status}</td>
        </tr>
        <tr>
            <th>Do zapłaty:</th>
            <td>${reservation.price} PLN</td>
        </tr>
        <tr>
            <th>Punkty:</th>
            <td>${reservation.points}</td>
        </tr>
    </table>

    <h3>Informacje o Użytkowniku</h3>
    <table class="table">
        <c:choose>
            <c:when test="${user != null}">
                <tr>
                    <th>Imię:</th>
                    <td>${user.firstName}</td>
                </tr>
                <tr>
                    <th>Nazwisko:</th>
                    <td>${user.lastName}</td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <th>Telefon:</th>
                    <td>${user.phone}</td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="2" style="background-color: yellow; text-align: center;">
                        Rezerwacja, założona przez użytkownika bez konta
                    </td>
                </tr>
                <tr>
                    <th>Imię:</th>
                    <td>${reservation.firstName}</td>
                </tr>
                <tr>
                    <th>Nazwisko:</th>
                    <td>${reservation.lastName}</td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>${reservation.email}</td>
                </tr>
                <tr>
                    <th>Telefon:</th>
                    <td>${reservation.phone}</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>

    <a href="${pageContext.request.contextPath}/admin/reservations" class="btn btn-primary">Powrót do listy rezerwacji</a>
</div>

<%@include file="/footer.jsp" %>
</html>
