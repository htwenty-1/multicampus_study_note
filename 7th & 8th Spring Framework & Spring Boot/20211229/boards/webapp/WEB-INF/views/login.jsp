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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>
</head>
<body>

<h2>Login Page</h2>

<div class="center">
    <form action="loginAf.do" id="frm" method="post">
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
                    <input type="password" name="pwd" id="pwd" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2">
<%--                    <input type="submit" value="login">--%>
                    <button type="button" id="loginBtn" onclick="login()">Sign In</button>
                    <a href="regi.do">Sign Up</a>
                </td>
            </tr>
        </table>
    </form>
</div>

<script type="text/javascript">

    /*
        Web의 저장공간
        - session : web server의 저장공간 ... Java 코드로 구성        ... 사용자를 Object로 저장
        - cookies : web client의 저장공간 ... JavaScript 코드로 구성  ... id, pw, 방문횟수
    */

    let userId = $.cookie("userId");

    if (userId !== null) {
        $("#id").val(userId);
        $("#chk_save_id").attr("checked", "checked");
        $("#chk_save_id").prop("checked", true);
    }

    $("#chk_save_id").click(function () {
        if($("#chk_save_id").is(":checked")) {
            if($("#id").val().trim() === "") {
                alert("ID를 입력하세요.")
                $("#chk_save_id").prop("checked", false);
            } else {
                $.cookie("userId", $("#id").val().trim(), { expires: 7, path: './' });
            }
        } else {
            $.removeCookie("userId", { path: './' })
        }
    })

    function login () {
        if($("#id").val().trim() === "") {
            alert("ID 또는 비밀번호가 입력되지 않았습니다!");
        } if($("#pwd").val().trim() === "") {
            alert("ID 또는 비밀번호가 입력되지 않았습니다!");
        } else {
            $("#frm").submit();
        }

    }

</script>

</body>
</html>
