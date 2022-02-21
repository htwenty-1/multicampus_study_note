<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/28
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello JSP 입니다!</h1>
<%
    // 짐풀기
    String name = (String)request.getAttribute("_name");
%>
<p><%= name%></p>
name: <input type="text" value="<%= name%>" />
</body>
</html>
