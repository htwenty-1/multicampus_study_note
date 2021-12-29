<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/29
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        .center {
            margin: auto;
            width: 60%;
            border: 3px solid #0000ff;
            padding: 10px;
        }
    </style>
</head>
<body>
    <h2>회원가입</h2>
    <div class="center">
        <form action="regiAf" method="post">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <td>
                        <input type="text" name="id" id="id" size="20"><br>
                        <p id="idCheck" style="font-size: 8px"></p>
                        <input type="button" value="ID 확인" id="btn">
                    </td>
                </tr>
                <tr>
                    <th>P/W</th>
                    <td>
                        <input type="text" name="pwd" size="20">
                    </td>
                </tr>
                <tr>
                    <th>NAME</th>
                    <td>
                        <input type="text" name="pwd" size="20">
                    </td>
                </tr>
                <tr>
                    <th>EMAIL</th>
                    <td>
                        <input type="text" name="pwd" size="20">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Sign Up">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
