<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Meal Edit</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meal</h2>
<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>
<form method="post" action="meals">
    <input type="hidden" name="id" value="${meal.id}">
    Date:
    <input type="datetime-local" name="dateTime" value="${meal.dateTime}">
    <br>
    Description:
    <input type="text" name="description" value="${meal.description}">
    <br>
    Calories:
    <input type="number" name="calories" value="${meal.calories}">
    <br>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>
