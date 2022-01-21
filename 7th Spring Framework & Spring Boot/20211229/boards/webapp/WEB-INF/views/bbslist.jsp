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
<%!
    // 답글의 depth와 image를 추가해 주는 함수
    // depth가 1이라면 ===> '공백 한 칸 + 이미지'
    // depth가 2라면  ===> '공백 두 칸 + 이미지'
    public String arrow(int depth) {

        String res = "<img src='img/arrow.png' width='20px' height='20px' />";
        String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";

        String ts = "";
        for (int i = 0; i < depth; i++) {
            ts += nbsp;
        }

        return depth == 0 ? "" : ts+res;

    }
%>
<%
    List<BbsDto> bbslist = (List<BbsDto>) request.getAttribute("bbslist");
%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<h1>게시판</h1>

<div align="center">
    <!--   attribute  property   -->
    <table class="table table-hover" style="width: 1000px">
        <!-- <col width="30"><col width="200"><col width="80"> -->

        <thead>
            <tr>
                <th>번호</th><th>제목</th><th>정보</th><th>작성자</th>
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
        } else {

            for(int i = 0;i < bbslist.size(); i++){
                BbsDto bbs = bbslist.get(i);
        %>
        <tr>
            <th><%=i+1 %></th>
            <td>
                <%= arrow(bbs.getDepth())%>
                <a href="bbsdetail.do?seq=<%=bbs.getSeq() %>">
                    <%=bbs.getTitle() %>
                </a>
            </td>
            <td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
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

<div align="center">
    <select id="choice">
        <option value="title">제목</option>
        <option value="content">내용</option>
        <option value="writer">작성자</option>
    </select>

    <input type="text" id="search" value="">
    <button type="button" onclick="searchbbs()">검색</button>
    <br><br>
</div>

<!--
<script type="text/javascript">
location.href = "bbslist.do"; -> GET
</script>
 -->

<script>
    function searchbbs() {
        let choice = document.getElementById("choice").value;
        let search = document.getElementById("search").value;

        location.href = "bbslist.do?choice="+choice+"&search="+search;
    }
</script>

</body>
</html>