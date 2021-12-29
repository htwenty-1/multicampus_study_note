<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/29
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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

    <h2>Login Page</h2>

    <div class="center">
        <table border="1">
            <tr>
                <th>ID</th>
                <td>
                    <input type="text" id="id" name="id" size="20"><br>
                    <input type="checkbox" id="chk_save_id"> ID 저장
                </td>
            </tr>
            <tr>
                <th>Password</th>
                <td>
                    <input type="password" name="pwd" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="login">
                    <a href="regi">Sign Up</a>
                </td>
            </tr>
        </table>
    </div>

</body>
</html>
