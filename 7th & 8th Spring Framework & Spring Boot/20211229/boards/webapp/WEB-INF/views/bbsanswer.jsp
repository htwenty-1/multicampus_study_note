<%@ page import="com.dto.BbsDto" %>
<%@ page import="com.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/31
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BbsDto bbs = (BbsDto) request.getAttribute("bbs");
    MemberDto mem = (MemberDto) request.getSession().getAttribute("login");
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>bbsanswer</title>
</head>
<body>

<div>

    <div align="center">
        <h1>기본글 보기</h1>

        <table class="table table-bordered" style="width: 1000px">
            <tr>
                <th>작성자</th>
                <td><%=bbs.getId() %></td>
            </tr>

            <tr>
                <th>제목</th>
                <td><%=bbs.getTitle() %></td>
            </tr>

            <tr>
                <th>작성일</th>
                <td><%=bbs.getWdate() %></td>
            </tr>

            <tr>
                <th>내용</th>
                <td align="center">
                    <textarea rows="15" cols="100" readonly="readonly"><%=bbs.getContent() %></textarea>
                </td>
            </tr>
        </table>

        <h1>답글</h1>

        <form action="answerAf.do" method="get">
            <%--  부모글에 대한 sequence를 가지고 감  --%>
            <input type="hidden" name="seq" value="<%=bbs.getSeq()%>" />

                <table class="table table-bordered" style="width: 1000px">
                    <tr>
                        <th>아이디</th>
                        <td>
                            <input type="text" name="id" size="70px" value="<%=mem.getId() %>" readonly="readonly">
                        </td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td>
                            <input type="text" name="title" size="70px">
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
                            <input type="submit" value="글쓰기">
                        </td>
                    </tr>

                </table>

        </form>

</div>


</body>
</html>
