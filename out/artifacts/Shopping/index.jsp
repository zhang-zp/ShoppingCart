<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 95702
  Date: 2019/9/27
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD><TITLE>index</TITLE>
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
    <C:if test="${userInfo.getUsername() eq null}" var="flag">
        <tr>
            <td colspan="3" align="right"><a href="login.jsp">登录</a></td>
    </C:if>
    <c:if test="${!falg}">
        </tr><tr>
            <td colspan="3" align="right">${userInfo.getUsername()}</td>
        </tr>
    </c:if>
</table>
<hr>
<H1 align="center">本系统的所有商品列表如下： <BR><BR>

    <TABLE width="400" border="1">
        <TR height="25">
            <td>图片</td>
            <TD>产品名称</TD>
            <td>单价</td>
            <TD>添加到购物车</TD>
        </TR>
        <c:forEach items="${list}" var="list">
            <TR>
                <td><img src="images/${list.g_photo}"/></td>
                <TD>${list.g_name}</TD>
                <td>${list.g_price}</td>
<%--                <TD><A href = "addGoods.do?name=${list.g_name}&price=${list.g_price}&id=${ID}">添加到购物车</A></TD>--%>
                <TD><A href = "javascript:add('${list.g_name}','${list.g_price}')">添加到购物车</A></TD>
<%--                <td><button onclick="addCart(this)">添加到购物车</button></td>--%>
            </TR>
        </c:forEach>
        <script>
            function add(g_name,g_price) {
                $ajax({
                    url:"buy.cart",
                    type:"post",
                    data:{
                        g_name:g_name,
                        g_price:g_price
                    },
                    success:function(data){
                        alert("添加购物车成功！")
                    },
                    error:function(error){
                        alert(error);
                    }
                });
            }
        </script>
    </TABLE>
    <BR>
<%--    <a href="cart.jsp?name=${name}">查看购物车</a>--%>
    <a href="cart.jsp">查看购物车</a>
</H1>
</BODY>
</HTML>