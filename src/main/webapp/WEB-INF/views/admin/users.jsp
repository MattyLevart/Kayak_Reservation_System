<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="d-flex justify-content-between align-items-center">
    <h1>Lista użytkowników:</h1>
</div>

<table class="table">
    <tr>
        <th>ID</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th>Telefon</th>
        <th>Punkty</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.points}</td>
<%--            <td><a href="/user/edit/${user.id}" class="btn btn-warning">Edytuj</a></td>--%>
<%--            <td><a href="/user/delete/${user.id}" class="btn btn-danger">Usuń</a></td>--%>
            <td>
                <form:form action="${pageContext.request.contextPath}/admin/users/points" method="post" style="display:inline;">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="number" name="points" placeholder="Punkty">
                    <button type="submit" class="btn btn-primary btn-sm">Zaktualizuj punkty</button>
                </form:form>
                <a href="${pageContext.request.contextPath}/admin/points-history?userId=${user.id}" class="btn btn-info btn-sm">Historia punktów</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="/footer.jsp" %>
</html>
