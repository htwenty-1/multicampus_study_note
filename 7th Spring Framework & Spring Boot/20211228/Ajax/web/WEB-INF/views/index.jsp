<%--
  Created by IntelliJ IDEA.
  User: hjun
  Date: 2021-11-01
  Time: 오후 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page session="false" %>

<html>
<head>
    <title>Home</title>
</head>

<body>
<%--기존방법--%>
<a href="hello">hello로 가기</a>
<%
    // response 객체를 사용하는 방법
    response.sendRedirect("home");
%>
</body>
</html>
