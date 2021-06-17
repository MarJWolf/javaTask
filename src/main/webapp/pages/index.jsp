<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link  rel = "stylesheet" href = "css/total.css" />
</head>
<body>
<form action="ReadStrings" method="post">
    <div class="item">
        <label for="recordsPerPage">Choose records per page : </label>
        <select id="recordsPerPage" name="recordsPerPage">
            <c:forEach var="num" begin="1" end="${requestScope.numOfEl}" step="1">
                <option value="${num}">${num}</option>
            </c:forEach>
        </select>
    </div>
    <div class="item">
    <label for="chosenNumber">Choose page number for viewing : </label>
    <input type="number" name="chosenNumber" id="chosenNumber" min="0" max="${requestScope.numOfEl}"/>
    </div>
    <div class="item">
    <label for="keyWord">Input key word for search : </label>
    <input type="text" name="keyWord" id="keyWord">
    </div>
    <div class="item">
    <input type="submit" value="Search">
    </div>
</form>
</select>
</body>
</html>