<%@ page import="MemberDto.MemberDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/29
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello.jsp</h1>

    <table border="1">
        <tr>
            <th>Num</th><th>ID</th><th>PW</th><th>Name</th>
        </tr>


<%
    for (int i = 0; i < list.size(); i++) {
        MemberDto mem = list.get(i);
%>
    <tr>
        <th><%= i + 1%></th>
        <td><%=mem.getId()%></td>
        <td><%=mem.getPwd()%></td>
        <td><%=mem.getName()%></td>
    </tr>

<%
    }
%>

    </table>

<br>

    <form action="home">
        ID <input type="text" name="id" />
        <input type="submit" value="회원정보" />
    </form>

</body>
</html>
