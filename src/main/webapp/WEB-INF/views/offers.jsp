<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: keejung
  Date: 3/21/24
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- model에서 key가 "id_offers"였던 객체를 불러온다 --%>
    <c:forEach var="offer" items="${id_offers}">
        <p> <c:out value="${offer}"> </c:out> </p>
    </c:forEach>
</body>
</html>
