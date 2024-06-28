<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
    <h1>Formularz Kajaka</h1>
    <c:choose>
        <c:when test="${kayak.id == 0}">
            <form:form modelAttribute="kayak" action="${pageContext.request.contextPath}/admin/kayaks/add" method="post">
                <div class="form-group">
                    <form:label path="type">Typ</form:label>
                    <form:input path="type" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="places">Miejsca</form:label>
                    <form:input path="places" type="number" class="form-control"/>
                    <form:errors cssClass="text-danger" path="places"/>
                </div>
                <div class="form-group">
                    <form:label path="babyOption">Opcja dla dzieci</form:label>
                    <form:checkbox path="babyOption" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="description">Opis</form:label>
                    <form:textarea path="description" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-primary">Zapisz</button>
            </form:form>
        </c:when>
        <c:otherwise>
            <form:form modelAttribute="kayak" action="${pageContext.request.contextPath}/admin/kayaks/edit/${kayak.id}" method="post">
                <div class="form-group">
                    <form:label path="type">Typ</form:label>
                    <form:input path="type" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="places">Miejsca</form:label>
                    <form:input path="places" type="number" class="form-control"/>
                    <form:errors cssClass="text-danger" path="places"/>
                </div>
                <div class="form-group">
                    <form:label path="babyOption">Opcja dla dzieci</form:label>
                    <form:checkbox path="babyOption" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="description">Opis</form:label>
                    <form:textarea path="description" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-primary">Zapisz</button>
            </form:form>
        </c:otherwise>
    </c:choose>
</div>

<%@include file="/footer.jsp" %>
</html>
