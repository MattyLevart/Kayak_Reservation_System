<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp"%>
<div class="login-container">
    <form method="post" class="login-form">
        <h2 class="text-center">Zaloguj się</h2>
        <div class="form-group">
            <label>Email:</label>
            <input type="text" name="username" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Hasło:</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <div class="form-group">
            <input type="submit" value="Zaloguj" class="btn btn-primary btn-block">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</div>
<%@include file="/footer.jsp"%>
</html>
