<%@ page import="MemberDto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/29
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MemberDto mem = (MemberDto) request.getAttribute("mem");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    회원정보: <br>
    ID: <%= mem.getId()%> <br>
    PW: <%= mem.getPwd()%> <br>
    Name: <%= mem.getName()%> <br>
    EMAIL: <%= mem.getEmail()%> <br>
</body>
</html>
