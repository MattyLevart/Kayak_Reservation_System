<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp"%>
<div class="container">
  <h1 class="mt-5">Park Linowy Adrenalina wita:</h1>
  <h2>W systemie rezerwacji kajaków</h2>
  <div class="container">
    <div class="header-buttons">
      <c:choose>
        <c:when test="${not empty principal}">
          <a href="${pageContext.request.contextPath}/user/home" class="btn btn-secondary">Moje konto</a>
        </c:when>
        <c:otherwise>
          <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Zaloguj się</a>
          <a href="${pageContext.request.contextPath}/register" class="btn btn-secondary">Załóż konto</a>
        </c:otherwise>
      </c:choose>
    </div>
    <div class="centered-button">
      <a href="${pageContext.request.contextPath}/reservationForm" class="btn btn-primary">Zarezerwuj kajak</a>
    </div>
    <div>
      <img src="${pageContext.request.contextPath}theme/img/kajaki.png" class="full-width-image" alt="Zdjęcie kajaka">
    </div>

  </div>
<%@include file="/footer.jsp"%>
</html>
