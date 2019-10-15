<%@ page import="entity.Goods" %><%--
  Created by IntelliJ IDEA.
  User: 95702
  Date: 2019/8/27
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD><TITLE>index</TITLE>
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
            String id = (String) request.getAttribute("ID");
            String name = (String) request.getAttribute("name");
//            System.out.println("LoginSuccess.jsp拿到ID＝"+id);
//            System.out.println("LoginSuccess.jsp拿到用户名＝"+name);
            String rename = request.getParameter("rename");
            //可以获取到rename
//            System.out.println("重新购物："+rename);
            if(name != null){
        %>

        <td colspan="3" align="right"> <%=name%> </td>
<%--        <td colspan="3" align="right"><a href="login.html">登录</a></td>--%>
        <%
            } else if(rename!=null) {
        %>
        <td colspan="3" align="right"> <%=rename%> </td>
        <%
            } else {
        %>
        <script type="text/javascript" language="javascript">
            alert("您还没有登录，请登录...");
            window.location.href="../login.html";
        </script>
        <%
        }
    %>
    </tr>
</table>
<hr>

<script>
    function addCart(obj) {
        var goodsName = obj.parentElement.parentElement.firstElementChild.nextElementSibling.innerHTML;
        var goodsPrice = obj.parentElement.parentElement.firstElementChild.nextElementSibling.nextElementSibling.innerHTML;
        location.href = "addGoods.do?name="+goodsName+"&price="+goodsPrice+"&id="+<%=id%>;
    }
</script>

<H1 align="center">本系统的所有商品列表如下： <BR><BR>
    <TABLE width="400" border="1">
        <TR height="25">
            <td>图片</td>
            <TD>产品名称</TD>
            <td>单价</td>
            <TD>添加到购物车</TD>
        </TR>
        <TR>
            <td><img src="images/i9100g.jpg"/></td>
            <TD id="name1">pen</TD>
            <td id="price1">100</td>
<%--            <TD><A href = "list.html">添加到购物车</A></TD>--%>
            <td><button onclick="addCart(this)">添加到购物车</button></td>
        </TR>
        <TR>
            <td><img src="images/i9100g.jpg"/></td>
            <TD id="name2">notebook</TD>
            <td id="price2">200</td>
            <TD><button onclick="addCart(this)">添加到购物车</button></TD>
        </TR>
        <TR>
            <td><img src="images/i9100g.jpg"/></td>
            <TD id="name3">pencil case</TD>
            <td id="price3">300</td>
<%--            <TD><A href="javascript:void(0);list.html">添加到购物车</A></TD>--%>
            <td><button onclick="addCart(this)">添加到购物车</button></td>
        </TR>
        <TR>
            <td><img src="images/i9100g.jpg"/></td>
            <TD id="name4">pencil</TD>
            <td id="price4">400</td>
<%--            <TD><A href = "list.html">添加到购物车</A></TD>--%>
            <td><button onclick="addCart(this)">添加到购物车</button></td>
        </TR>
        <TR>
            <td><img src="images/i9100g.jpg"/></td>
            <TD>rubber</TD>
            <td>500</td>
<%--            <TD><A href = "list.html">添加到购物车</A></TD>--%>
            <td><button onclick="addCart(this)">添加到购物车</button></td>
        </TR>

    </TABLE>


    <BR>
    <a href="JSP/cart.jsp?username=<%=name%>">查看购物车</a>
</H1>

</BODY>
</HTML>