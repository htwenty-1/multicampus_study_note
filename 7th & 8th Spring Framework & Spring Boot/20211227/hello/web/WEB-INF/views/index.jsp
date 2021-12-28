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
<%--<form action="listAll" method="get">--%>
<%--    <body>--%>
<%--    <button type="submit">CRUD게시판 가기</button>--%>
<%--    <h1>--%>
<%--        Hiiii !--%>
<%--    </h1>--%>
<%--    </body>--%>
<%--</form>--%>
<body>
    <form action="myname" method="get">
        <label>
            <input type="text" name="myNameIs" />
        </label>
        <input type="submit" value="제출" />
    </form>
</body>
</html>
