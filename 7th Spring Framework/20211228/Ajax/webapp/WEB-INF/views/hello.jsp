<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/28
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h2><a href="home">home으로 가기</a></h2>
<p>--------------------------------</p>
<h2 id="demo">Hello.jsp입니다!</h2>
<p>반갑습니다</p>
<div>건강하세요</div>
<input type="text" id="test" value="hi" />
<button type="button" onclick="btnclick()">JS Button</button>
<button type="button" id="btn">jQuery Button</button>
<%
    response.sendRedirect("home");
%>
<script type="text/javascript">
    let demo = $("#demo").html();
    console.log(demo);

    /*
    let test = document.getElementById("test").value;
    console.log(test);
    */

    let test = $("#test").val();
    console.log(test);

    function btnclick() { alert("clicked your button") }


    $("#btn").click(function() {
        alert("clicked jQuery Button");
    });
</script>
</body>
</html>
