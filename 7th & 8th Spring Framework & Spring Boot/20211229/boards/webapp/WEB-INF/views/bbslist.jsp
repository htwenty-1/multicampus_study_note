<%@ page import="java.util.List" %>
<%@ page import="com.dto.BbsDto" %>
<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/30
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BbsDto> bbslist = (List<BbsDto>) request.getAttribute("bbslist");
%>
<html>
<head>
    <title>Boards</title>
</head>
<body>
    <div align="center">
        <table border="1" style="width: 1000px">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Writer</th>
                </tr>
            </thead>
            <tbody>

                <%
                    if(bbslist == null || bbslist.size() == 0) {
                %>
                       <tr>
                           <td colspan="3">작성된 글이 없습니다.</td>
                       </tr>

                <%
                    } else {
                        for (int i = 0; i < bbslist.size(); i++) {
                            BbsDto bd = bbslist.get(i);
                %>
                            <th>
                                <tr><%=i+1%></tr>
                                <td>
                                    <a href="bbsdetail.do?seq=<%= bd.getSeq()%>">
                                        <%= bd.getTitle()%>
                                    </a>
                                </td>
                                <td><%= bd.getId()%></td>
                            </th>
                <%

                        }
                    }
                %>


            </tbody>
        </table>
    </div>
    <div align="center">
        <a href="bbswrite.do">글쓰기</a>
    </div>
</body>
</html>
