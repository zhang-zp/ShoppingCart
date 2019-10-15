<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="js/ajax.js"></script>
</HEAD>

<BODY bgColor="#ffffff">
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50">
    <tr>
        <td width="30%">&nbsp;</td>
        <td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
        <td width="30%" align="right" valign="bottom">&nbsp;</td>
    </tr>
    <tr>

        <c:if test="${userInfo.username eq null}" var="flag">
<%--                <td colspan="3" align="right"><a href="login.jsp">登录</a></td>--%>
        <script type="text/javascript" language="javascript">
            alert("您还没有登录，请登录");
            window.location.href = "login.jsp";
        </script>
        </c:if>
        <c:if test="${!flag}">
        <td colspan="3" align="right"> ${userInfo.username} </td>
        </c:if>
    </tr>
</table>
<hr>
<H1 align="center">购物车 </H1>

<FORM name="cartForm"  method="post">
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

        <c:forEach items="${cart}" var="list" varStatus="status">
            <tr align="center" >
                <td height="30">${status.count}</td>
                <td height="30" id="${status.count}">${list.getG_name()}</td>
                <td height="30">${list.getG_price()}</td>
                <td height="30">${list.getGoodsNum()}</td>
                <td height="30">${list.getSumPrice()}</td>
                <td height="30"><button onclick="deleteGoods('${list.getG_name()}')">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script>
        function deleteGoods(name) {
            // var goodsName = document.getElementById(id).innerText;
            $ajax({
                url:"deleteGoods.cart",
                type:"post",
                data:{
                    goodsName:name
                },
                success:function (data) {
                    alert("删除成功！")
                },
                error:function (data) {
                    alert(data)
                }
            });
        }
    </script>
    <BR>
    <BR>
    <TABLE cellSpacing="0" cellPadding="0" width="450" align="center" border="0">
        <TR align="center">
            <TD width="26%"><input onClick="javascript:location.href='clear.cart'"  type="button" value="清空购物车"></TD>
            <TD width="12%"><input onclick="javascript:location.href='order.jsp'" type="button" value="结账"
                                   name="submit"></TD>
            <TD width="20%"><input onclick="window.location.href='index.jsp'" type="button"
                                   value="继续购物"></TD>
        </TR>
    </TABLE>
</form>
</BODY>
</html>
