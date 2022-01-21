<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/28
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>여기는 World</h3>
    <form action="/account" method="post" >
        name: <input type="text" name="name" /> <br>
        age : <input type="text" name="age" /> <br>
        <input type="submit" value="Send" />
    </form>
</body>
</html>
