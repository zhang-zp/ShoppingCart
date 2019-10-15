<%@ page import="dao.daoimp.UserDaoImp" %>
<%@ page import="dao.daoimp.CarDaoImp" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.SCar" %>
<%-- Created by IntelliJ IDEA.
User: 95702
Date: 2019/8/28
Time: 10:09
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<HEAD>
    <TITLE>我的购物车</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=gb2312">
</HEAD>

<BODY bgColor="#ffffff">
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50">
    <tr>
        <td width="30%">&nbsp;</td>
        <td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
        <td width="30%" align="right" valign="bottom">&nbsp;</td>
    </tr>
    <tr>
        <%
            String name = (String) request.getParameter("username");
            if(name == null){
//                PrintWriter pw = response.getWriter();
//                pw.write("请先登录！");
        %>

        <td colspan="3" align="right"><a href="login.html">登录</a></td>
        <%
        } else {
        %>
        <td colspan="3" align="right"> <%=name%> </td>
        <%
            }
        %>
    </tr>
</table>
<hr>
<H1 align="center">购物车 </H1>

<FORM name="cartForm" action="order.html" method="post">
    <table cellspacing="0" cellpadding="0" width="74%" align="center" border="1">
        <tr align="center">
            <td width="7%">编号</td>
            <td width="20%" height="30">商品名称</td>
            <td width="12%" height="30">单价</td>
            <td width="20%" height="30">数量</td>
            <td width="15%" height="30">合计</td>
            <td width="26%" height="30">&nbsp;</td>
        </tr>
<%--        打印购物车内容--%>
        <%
            UserDaoImp userDao = new UserDaoImp();
            CarDaoImp carDao = new CarDaoImp();
            int userID = userDao.returnUid(name);
            List<SCar>list = carDao.showCar(userID);
            for (int i = 0;i<list.size();i++){
        %>
        <tr align="center">
            <td height="30"><%=i+1%></td>
            <td height="30"><%=list.get(i).getG_name()%></td>
            <td height="30"><%=list.get(i).getG_price()%></td>
            <td height="30"><%=list.get(i).getGoodsNum()%></td>
            <td height="30"><%=list.get(i).getSumPrice()%></td>
            <td height="30"><input type="text" name="num" size="6"/> <a href="LoginSuccess.jsp">修改数量</a> <button>删除</button></td>
        </tr>
        <%
            }
        %>
    </table>
    <BR>
    <BR>
    <TABLE cellSpacing="0" cellPadding="0" width="450" align="center" border="0">
        <TR align="center">
            <TD width="26%"><input onClick="clearCart()" type="submit" value="清空购物车" name="submit"></TD>
            <TD width="12%"><input onclick = "window.location.href='order.jsp?name=<%=name%>'" type="button" value="结账" name="submit"></TD>
            <TD width="20%"><input onclick = "window.location.href='../JSP/LoginSuccess.jsp?rename=<%=name%>'" type="button" value="继续购物"></TD>
        </TR>
    </TABLE>
</form>
</BODY>
</html>
