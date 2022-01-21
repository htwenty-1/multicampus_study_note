<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/28
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

<h2>home.jsp</h2>

이름: <input type="text" id="alias" value="라이언" /> <br>
<button type="button" id="abtn">name check</button>
<h3 id="answer"></h3>

<script>
    $("#abtn").click(function() {
        $.ajax({
            url: "alias",
            type: "get",
            data: "alias=" + $("#alias").val(),
            success: function(res) {
                alert('success');
                alert(res);

                $("#answer").text(res);

            },
            error: function () {
                alert("error!");
            }
        })
    })
</script>

</body>
</html>
