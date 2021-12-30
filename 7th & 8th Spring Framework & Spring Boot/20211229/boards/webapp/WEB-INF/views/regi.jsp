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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
    <h2>회원가입</h2>
    <div class="center">
        <form action="regiAf.do" method="post" id="frm">
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
                        <input type="text" name="pwd" id="pwd" size="20">
                    </td>
                </tr>
                <tr>
                    <th>NAME</th>
                    <td>
                        <input type="text" name="name" id="name" size="20">
                    </td>
                </tr>
                <tr>
                    <th>EMAIL</th>
                    <td>
                        <input type="text" name="email" size="20">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
<%--                        <input type="submit" value="Sign Up">--%>
                        <button type="button" onclick="account()">Sign Up</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

<script>

    $(document).ready(function () {

        $("#btn").click(function () {
            console.log('Button clicked');

            let id = $("#id").val();

            $.ajax({
                url: "idCheck.do",
                type: "post",
                data: { "id": id },       // json형태로 넘겨주기
                success: function(res) {
                    console.log('success');
                    console.log(res);

                    if (res === "Usable") {
                        $("#idcheck").css("color", "#0000ff");
                        $("#idCheck").html("사용 가능한 ID");
                    } else {
                        $("#idcheck").css("color", "#ff0000");
                        $("#idCheck").html("이미 사용 중인 ID");
                        $("#id").val("");
                    }
                },
                error: function (e) {
                    throw new Error(e);
                }
            });
        });

    });

    function account() {
        // alert("account btn");

        if($("#id").val() === "") {
            alert('ID가 입력되지 않았습니다.');
        } else if ($("#pwd").val() === "") {
            alert('비밀번호가 입력되지 않았습니다.');
        } else if ($("#name").val() === "") {
            alert('이름이 입력되지 않았습니다.');
        } else if ($("#email").val() === "") {
            alert('이메일이 입력되지 않았습니다.');
        } else {
            $("#frm").submit();
        }
    }

</script>
</body>
</html>
