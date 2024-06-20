<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp"%>
<div class="container confirmation-container">
    <h1>Właśnie dokonałeś rezerwacji spływu kajakowego.</h1>
    <h2>Twoja rezerwacja czeka na potwierdzenie, które otrzymasz drogą telefoniczną</h2>
    <p>W razie jakichkolwiek pytań lub wątpliwości zachęcamy do kontaktu</p>
    <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Powrót do strony głównej</a>
</div>
<%@include file="/footer.jsp"%>
</html>
