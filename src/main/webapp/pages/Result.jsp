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
    <title>Result</title>
    <link  rel = "stylesheet" href = "css/total.css" />
</head>
<body>
<c:choose>
    <c:when test="${requestScope.chosenPage > requestScope.noOfPages || requestScope.chosenPage < 1}">
        <p>Invalid page chosen!</p>
    </c:when>
    <c:when test="${requestScope.Data.size() == 1 && requestScope.Data.get(0).equals('Няма резултат')}">
        <p>${requestScope.Data.get(0)}</p>
    </c:when>
    <c:otherwise>
        <div class="item">
            <p>Items : </p>
            <c:forEach var="element" items="${requestScope.Data}" begin="${requestScope.beginValue}" end="${requestScope.endValue}">
                "${element}"
            </c:forEach>
        </div>
        <div class="item">
            <p>Total items : ${requestScope.Data.size()}</p>
        </div>
        <div class="item">
            <p>Total pages : ${requestScope.noOfPages}</p>
        </div>
    </c:otherwise>
</c:choose>
<form action="BeginServlet" method="get">
    <div class="item">
        <input type="submit" value="Go back">
    </div>
</form>
</body>
</html>
