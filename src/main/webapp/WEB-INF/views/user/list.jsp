<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
<h1>Twoje Dane:</h1>

<table class="table">
    <tr>
        <th>Imię</th>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <th>Nazwisko</th>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${user.email}</td>
    </tr>
    <tr>
        <th>Telefon</th>
        <td>${user.phone}</td>
    </tr>
    <tr>
        <th>Zebrane punkty</th>
        <td>${user.points}</td>
    </tr>
</table>
</div>
<div class="text-center">
    <a href="/user/edit" class="btn btn-warning">Edytuj Dane Konta</a>
    <a href="/user/delete" class="btn btn-danger">Usuń Konto</a>
</div>
<%@include file="/footer.jsp" %>
</html>
