<%--
  Created by IntelliJ IDEA.
  User: 95702
  Date: 2019/9/28
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title></title>
    <script src="js/ajax.js"></script>
    <script>
        function checkUsername(username) {
            $ajax({
                url:"checkUsername.user",
                type:"post",
                data:{
                    username:username
                },
                success:function(data){
                    document.getElementById("span").innerText=data.substring(3,data.length);
                    document.getElementById("span").style.color = "red";
                },
                error:function(error){
                    alert(error);
                }
            });
        }
        function init() {
            document.getElementById("span").innerText = "请输入常用的Email格式";
            document.getElementById("span").style.color = "black";
        }
    </script>
</head>

<body>
<center>
    <h2>用户注册</h2>
    <hr/>
    <form action="register.user" method="post">
        <table border="0">
            <tr>
                <td align="right">用户名</td>
                <td ><input type="text" name="username" onblur="checkUsername(this.value)" 
                            onfocus="init()"/></td>
                <td ><span id="span">请输入常用的Email格式</span></td>
            </tr>
            <tr>
                <td align="right">密&nbsp;&nbsp码</td>
                <td><input type="password" name="pwd"/></td>
                <td align="left"><span>密码必须为6~20位</span></td>
            </tr>
            <tr>
                <td align="right">重复密码</td>
                <td><input type="password" name="repwd"/></td>
                <td>&nbsp;<span></span></td>
            </tr><br />
            <tr>
                <td colspan="3" align="center">
                    <input type="reset" value="重置" />
                    <input type="submit" value="提交"/>	</td>
            </tr>
        </table>

    </form>
</center>
</body>
</html>