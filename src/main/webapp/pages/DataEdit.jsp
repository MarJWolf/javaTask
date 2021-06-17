<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 17-Jun-21
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Data</title>
    <link  rel = "stylesheet" href = "css/total.css" />
</head>
<body>
<div class="item">
    <p> All data :
        <c:forEach var="element" items="${requestScope.Data}" >
            "${element}"
        </c:forEach>
    </p>
</div>
<form action="EditDataServlet" method="post">
    <div class="item" >
        <div class="item">
            <label for="newElement">Input new element to add : </label>
            <input type="text" name="newElement" id="newElement">
        </div>
        <div class="item">
            <input type="submit" value="Add">
        </div>
    </div>
</form>
<form action="EditDataServlet" method="get">
    <div class="item" >
        <div class="item">
            <label for="delElement">Input element to delete : </label>
            <input type="text" name="delElement" id="delElement">
        </div>
        <div class="item">
            <input type="submit" value="Remove">
        </div>
    </div>
</form>
</body>
</html>
