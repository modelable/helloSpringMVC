<%--
  Created by IntelliJ IDEA.
  User: keejung
  Date: 3/28/24
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${offer.name} 가 새로운 제안을 하였습니다. 감사합니다. <!-- View는 Model(offer)에 접근할 수 있다 -->
<a href="${pageContext.request.contextPath}/offers"> Click here to view current offers </a>
</body>
</html>
