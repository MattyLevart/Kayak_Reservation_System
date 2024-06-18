<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp"%>
<div class="container">
  <h1 class="mt-5">Rejestracja</h1>
  <form:form method="post" action="${pageContext.request.contextPath}/user/register" modelAttribute="user">
    <div class="form-group">
      <label for="firstName">Imię:</label>
      <form:input id="firstName" path="firstName" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="lastName">Nazwisko:</label>
      <form:input id="lastName" path="lastName" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="email">Mail:</label>
      <form:input id="email" path="email" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="phone">Nr. tel:</label>
      <form:input id="phone" path="phone" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="password">Hasło:</label>
      <form:password id="password" path="password" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-primary">Zarejestruj się</button>
  </form:form>
</div>
<%@include file="/footer.jsp"%>
</html>
