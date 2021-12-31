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
</head>
<body>

<h1>게시판</h1>

<div align="center">
    <!--   attribute  property   -->
    <table class="table table-hover" style="width: 1000px">
        <!-- <col width="30"><col width="200"><col width="80"> -->

        <thead>
        <tr>
            <th>번호</th><th>제목</th><th>seq</th><th>작성자</th>
        </tr>
        </thead>

        <tbody>
        <%
            if(bbslist == null || bbslist.size() == 0){
        %>
        <tr>
            <td colspan="3">작성된 글이 없습니다</td>
        </tr>
        <%
        }else{

            for(int i = 0;i < bbslist.size(); i++){
                BbsDto bbs = bbslist.get(i);
        %>
        <tr>
            <th><%=i+1 %></th>
            <td>
                <a href="bbsdetail.do?seq=<%=bbs.getSeq() %>">
                    <%=bbs.getTitle() %>
                </a>
            </td>
            <td><%=bbs.getSeq() %></td>
            <td align="center"><%=bbs.getId() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<br>
<div align="center">
    <a href="bbswrite.do">글쓰기</a>
</div>

<!--
<script type="text/javascript">
location.href = "bbslist.do"; -> GET
</script>
 -->
</body>
</html>