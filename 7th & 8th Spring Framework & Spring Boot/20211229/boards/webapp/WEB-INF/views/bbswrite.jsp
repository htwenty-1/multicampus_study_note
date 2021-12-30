<%@ page import="com.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/30
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // take user information from session
    MemberDto mem = (MemberDto) request.getSession().getAttribute("login");
%>

<%--
request.getAttribute() ===> 데이터를 다른곳으로 전송할 때
request.getSession.getAttribute() ===> 세션에 저장한 후 다른 곳으로 넘겨줌.
--%>

<html>
<head>
    <title>글 작성하기</title>
</head>
<body>
    <h1>글 추가</h1>

    <div align="center">

        <form action="bbswriterAf.do" method="post">
            <table>
                <tr>
                    <th>ID</th>
                    <td>
                        <input type="text" name="id" size="70px" id="id" value=<%mem.getId()%> readonly>
                    </td>
                </tr>
                <tr>
                    <th>Title</th>
                    <td>
                        <input type="text" name="title" id="title" size="70px" />
                    </td>
                </tr>

                <tr>
                    <th>내용</th>
                    <td>
                        <textarea rows="20px" cols="80" name="content" id="content"></textarea>
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <button type="submit" onclick="onSubmit()">Upload</button>
                    </td>
                </tr>

            </table>
        </form>

    </div>

    <script>
        function onSubmit () {
            const title = document.getElementById("title").value;
            const content = document.getElementById("content").value;

            if (title !== null && content !== null) {
                <%

                %>
            }
        }
    </script>
</body>
</html>
