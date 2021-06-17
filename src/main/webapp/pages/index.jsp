<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link  rel = "stylesheet" href = "css/total.css" />
</head>
<body>
<div class="item">
    <p> All data :
        <c:forEach var="element" items="${requestScope.El}" >
            "${element}"
        </c:forEach>
    </p>
</div>
<form action="ReadStringsServlet" method="get">
    <div class="item">
        <input type="submit" value="Edit Data">
    </div>
</form>
<form action="ReadStringsServlet" method="post">
    <div class="item">
        <label for="recordsPerPage">Choose records per page : </label>
        <select id="recordsPerPage" name="recordsPerPage">
            <c:forEach var="num" begin="1" end="${requestScope.El.size()}" step="1">
                <option value="${num}">${num}</option>
            </c:forEach>
        </select>
    </div>
    <div class="item">
    <label for="chosenPage">Choose page number for viewing : </label>
    <input type="number" name="chosenPage" id="chosenPage" min="1" max="${requestScope.El.size()}" />
    </div>
    <div class="item">
    <label for="keyWord">Input key word for search : </label>
    <input type="text" name="keyWord" id="keyWord">
    </div>
    <div class="item">
    <input type="submit" value="Search">
    </div>
</form>
</body>
</html>