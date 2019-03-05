<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Users</h2>
<hr/>
<form method="post" action="users">
    <label>
        <select name="userId">
            <option>1</option>
            <option>2</option>
        </select>
    </label>
    <button type="submit">Login</button>
</form>
</body>
</html>
