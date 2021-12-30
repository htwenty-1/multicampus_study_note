<%@ page import="com.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: hwangduil
  Date: 2021/12/30
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%
     MemberDto mem = (MemberDto) request.getSession().getAttribute("writebbs");

 %>
