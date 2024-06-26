<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp"%>
<div class="container">
    <h1 class="mt-5">Edycja Użytkownika</h1>
    <form:form method="post" modelAttribute="user">
        <form:hidden path="id"></form:hidden>
        <div class="form-group">
            <label for="firstName">Imię:</label>
            <form:input id="firstName" path="firstName" class="form-control"/>
            <form:errors cssClass="error" path="firstName"/>
        </div>
        <div class="form-group">
            <label for="lastName">Nazwisko:</label>
            <form:input id="lastName" path="lastName" class="form-control"/>
            <form:errors cssClass="error" path="lastName"/>
        </div>
        <div class="form-group">
            <label for="email">Mail:</label>
            <form:input id="email" path="email" class="form-control"/>
            <form:errors cssClass="error" path="email"/>
        </div>
        <div class="form-group">
            <label for="phone">Nr. tel:</label>
            <form:input id="phone" path="phone" class="form-control"/>
            <form:errors cssClass="error" path="phone"/>
        </div>
        <div class="form-group">
            <label for="points">Punkty:</label>
            <span id="points" class="form-control-plaintext">${user.points}</span>
        </div>
        <button type="submit" class="btn btn-primary">Zapisz</button>
    </form:form>
</div>
<%@include file="/footer.jsp"%>
</html>
