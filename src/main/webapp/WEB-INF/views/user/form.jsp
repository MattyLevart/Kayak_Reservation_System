<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 12/06/2024
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Dodaj kategorię</h3>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <label for="name">Imię:</label>
    <form:input id="name" path="firstName"/>
    <label for="lastN">Nazwisko:</label>
    <form:input id="lastN" path="lastName"/>
    <label for="phone">Telefon:</label>
    <form:input id="phone" path="phone"/>
    <label for="email">Email:</label>
    <form:input id="email" path="email"/>
    <label for="password">Hasło:</label>
    <form:input id="password" path="password"/>
    <label for="points">Punkty:</label>
    <form:input id="points" path="points"/>
    <label for="login">Login:</label>
    <form:input id="login" path="userName"/>
    <input type="submit">
</form:form>
</body>
</html>
