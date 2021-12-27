<%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/27
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    // Java Area
    String str = "hello";
  %>

  <%
    for (int i = 0; i < 4; i++) {
  %>
      <p>hello p tag</p>
  <%
    }
  %>

<%-- html area --%>
  <h3>str=<%=str%></h3>
  $END$
  <p id="demo">Web Area</p>

  <p>scriptlet의 종류</p>
  <%
    // 선언부
    int number = 0;
  %>

  <%
    // 코드부
    int num = 0;

    number++;
    num++;
  %>

  <%=number %>
  <%=num;%>
  </body>
</html>
