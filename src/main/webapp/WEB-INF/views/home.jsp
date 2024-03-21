<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%-- 현재 웹 애플리케이션의 컨텍스트 경로를 반환하는 EL 표현식 placeholder --%>
  <p><a href="${pageContext.request.contextPath}/offers"> Show current offers</a></p>
  </body>
</html>
