<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
    <table class="formtable"> <!-- class 속성은 CSS 스타일링 관련 -->
        <tr>
            <td class="label"> Name: </td>
            <td><sf:input class="control" type="text" path="name"/> <br/>
                <sf:errors path="name" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> Email: </td>
            <td><sf:input class="control" type="text" path="email"/> <br/>
                <sf:errors path="email" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> Offer: </td>
            <td><sf:textarea class="control" rows="10" cols="10" path="text"/> <br/>
                <sf:errors path="text" class="error"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="새 제안"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
