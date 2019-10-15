<%--
  Created by IntelliJ IDEA.
  User: 95702
  Date: 2019/9/1
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<BODY bgColor="#ffffff">
<%
    String name = request.getParameter("name");
%>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50" >
    <tr>
        <td width="30%">&nbsp;</td>
        <td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
        <td width="30%" align="right" valign="bottom">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="3" align="left">欢迎您<%=name%>!</td>
    </tr>
</table>
<hr>
<h2 align="center">订单已生成！您的订单号是：20080220001。</h2>
<center><a href="LoginSuccess.jsp?name=<%=name%>">请返回</a></center>
</BODY>
</html>
