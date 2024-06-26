<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
    <h1>Lista Kajaków</h1>
    <a href="${pageContext.request.contextPath}/admin/kayaks/add" class="btn btn-primary mb-3">Dodaj Kajak</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Typ</th>
            <th>Miejsca</th>
            <th>Opcja dla dzieci</th>
            <th>Opis</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="kayak" items="${kayaks}">
            <tr>
                <td>${kayak.id}</td>
                <td>${kayak.type}</td>
                <td>${kayak.places}</td>
                <td>${kayak.babyOption ? "Tak" : "Nie"}</td>
                <td>${kayak.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/kayaks/edit/${kayak.id}" class="btn btn-warning btn-sm">Edytuj</a>
                    <a href="${pageContext.request.contextPath}/admin/kayaks/delete/${kayak.id}" class="btn btn-danger btn-sm">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="/footer.jsp" %>
</html>
