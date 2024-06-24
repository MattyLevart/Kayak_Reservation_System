<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<div class="container">
    <h2>Formularz rezerwacji</h2>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            <p>${error}</p>
        </div>
    </c:if>

    <form:form modelAttribute="reservation" method="post" class="form-horizontal">

        <div class="form-group">
            <label for="date">Data:</label>
            <form:input path="date" type="date" class="form-control"/>
            <form:errors path="date" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="hour">Godzina:</label>
            <form:select path="hour" class="form-control">
                <form:option value="8">8:00</form:option>
                <form:option value="9">9:00</form:option>
                <form:option value="10">10:00</form:option>
                <form:option value="11">11:00</form:option>
                <form:option value="12">12:00</form:option>
                <form:option value="13">13:00</form:option>
                <form:option value="14">14:00</form:option>
                <form:option value="15">15:00</form:option>
            </form:select>
            <form:errors path="hour" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="placeOfStart">Miejsce startu:</label>
            <form:select path="placeOfStart" class="form-control">
                <form:option value="Jaracz" label="Jaracz"/>
                <form:option value="Kowanówko" label="Kowanówko"/>
                <form:option value="Wełna" label="Wełna"/>
                <form:option value="Ruda" label="Ruda"/>
            </form:select>
            <form:errors path="placeOfStart" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="singleKayaks">Liczba kajaków jednoosobowych:</label>
            <form:input path="singleKayaks" type="number" min="0" class="form-control"/>
            <form:errors path="singleKayaks" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="doubleKayaks">Liczba kajaków dwuosobowych:</label>
            <form:input path="doubleKayaks" type="number" min="0" class="form-control"/>
            <form:errors path="doubleKayaks" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="babySeats">Liczba kajaków z dostawką (2 dorosłych + dziecko do lat 4):</label>
            <form:input id="babySeats" path="babySeats" type="number" min="0" class="form-control" value="0"/>
            <form:errors path="babySeats" cssClass="text-danger"/>
        </div>
        <c:if test="${empty principal}">
            <div class="form-group">
                <label for="firstName">Imię:</label>
                <form:input path="firstName" class="form-control"/>
                <form:errors path="firstName" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="lastName">Nazwisko:</label>
                <form:input path="lastName" class="form-control"/>
                <form:errors path="lastName" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <form:input path="email" type="email" class="form-control"/>
                <form:errors path="email" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="phone">Numer telefonu:</label>
                <form:input path="phone" class="form-control"/>
                <form:errors path="phone" cssClass="text-danger"/>
            </div>
        </c:if>
        <div class="form-group">
            <input type="submit" value="Zarezerwuj" class="btn btn-primary"/>
        </div>
    </form:form>
</div>
<%@include file="/footer.jsp" %>
</html>
