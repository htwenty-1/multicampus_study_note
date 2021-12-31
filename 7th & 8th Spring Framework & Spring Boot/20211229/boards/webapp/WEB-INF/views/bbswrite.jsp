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

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>글추가</h1>

<div align="center">

    <form action="bbswriteAf.do" method="get">

        <table class="table table-hover" style="width: 1000px">
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" name="id" size="70px" value="<%=mem.getId() %>" readonly="readonly" />
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="title" size="70px" />
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="20" cols="80" name="content"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="글쓰기" />
                </td>
            </tr>

        </table>



    </form>


</div>




</body>
</html>


