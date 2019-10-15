<%@ page import="dao.daoimp.UserDaoImp" %>
<%@ page import="dao.daoimp.CarDaoImp" %>
<%@ page import="entity.SCar" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 95702
  Date: 2019/9/1
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
        <td colspan="3" align="left">欢迎您,<%=name%>!</td>
    </tr>
</table>
<hr>
<H1 align="center">你所购买的商品如下： </H1>
<TABLE cellSpacing="0" cellPadding="0" width="75%" align="center" border="1">
    <TBODY>
    <TR align="center">
        <td></td>
        <TD width="21%" height="30">商品名称</TD>
        <TD width="14%" height="30">单价</TD>
        <TD width="25%" height="30">数量</TD>
        <TD width="33%" height="30">合计</TD></TR>
    <%
        UserDaoImp userDao = new UserDaoImp();
        CarDaoImp carDao = new CarDaoImp();
        int userID = userDao.returnUid(name);
        List<SCar> list = carDao.showCar(userID);
        int sum = 0;
        for (int i = 0;i<list.size();i++){
            sum += list.get(i).getSumPrice();
    %>
    <tr align="center">
        <td height="30"><%=i+1%></td>
        <td height="30"><%=list.get(i).getG_name()%></td>
        <td height="30"><%=list.get(i).getG_price()%></td>
        <td height="30"><%=list.get(i).getGoodsNum()%></td>
        <td height="30"><%=list.get(i).getSumPrice()%></td>
    </tr>
    <%
        }
    %>
    <TR>
        <TD colSpan="5" height="30">您的购物车中所有商品总金额：<%=sum%></TD></TR></TBODY></TABLE>
<P>
<H1 align="center">用户联系方式如下：</H1>
<P></P>
<FORM name="form1" action="message.html" method="post">
    <TABLE cellSpacing="0" cellPadding="0" width="500" align="center" border="0">
        <TR>
            <TD width="117" height="23">姓名：</TD>
            <TD width="383">匹夫</TD></TR>
        <TR>
            <TD height="24">地址：</TD>
            <TD><INPUT value="湖南工大" name="address"></TD></TR>
        <TR>
            <TD height="24">邮政编码：</TD>
            <TD><INPUT value="410010" name="postCode"></TD></TR>
        <TR>
            <TD height="23">E-mail：</TD>
            <TD><INPUT value="<%=name%>" name="email"></TD></TR>
        <TR>
            <TD height="23">联系电话：</TD>
            <TD><INPUT value="8233110" name="homePhone"></TD></TR>
    </TABLE><BR>
    <br>
    <center>
        <input type="button" value="生成定单" onclick="location.href='message.jsp?name=<%=name%>'">
        <input type="button" value="返回" onclick="location.href='javascript:history.go(-1)'">
    </center>
</FORM></BODY>
</html>
