<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/28
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Home.jsp</h1>
    <%
        String job = (String)request.getAttribute("job");
        int age = (int)request.getAttribute("age");
    %>
    <p>
        <%= job%>의 나이는 <%= age%>세
    </p>
</body>
</html>
