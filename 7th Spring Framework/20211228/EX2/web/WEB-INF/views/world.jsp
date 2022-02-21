<%@ page import="com.example.src.dto.HumanDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/28
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<HumanDto> list = (List<HumanDto>) request.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>World.jsp입니다</h1>
<table border="1">
    <tr>
        <th>JOB</th>
        <th>AGE</th>
    </tr>


    <%
        for (HumanDto dto : list) {
    %>
    <tr>
        <td><%= dto.getJob()%>
        </td>
        <td><%= dto.getAge()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
