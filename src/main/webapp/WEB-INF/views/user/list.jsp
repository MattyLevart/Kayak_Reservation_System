<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 13/06/2024
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            font-size: 18px;
            text-align: left;
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f4f4f4;
            font-weight: bold;
        }
        td {
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<h1>Lista Użytkowników</h1>

<table>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th>Telefon</th>
        <th>Punkty</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.points}</td>
            <td><a href="/user/edit/${user.id}" class="button-edit">Edytuj</a></td>
            <td><a href="/user/delete/${user.id}" class="button-delete">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
