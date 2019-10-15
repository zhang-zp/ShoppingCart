<%--
  Created by IntelliJ IDEA.
  User: 95702
  Date: 2019/8/14
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--<% int id = (int)request.getAttribute("id");%>--%>
<div style="color: red">你的ID为${id}请牢记!</div>
<div id="box"></div>
<script>
    //5秒跳转页面
    var b = document.getElementById("box");
    //b.innerHTML = "5秒后跳转登录页面";
    b.innerText = "5秒后跳转登录页面"
    var time = 5;
    //每隔一秒执行定时器
    var timer = setInterval(function(){
        if(time>0){
            time--;
            b.innerHTML=time+"秒后跳转登录页面";
        }else{
            //终止定时器
            window.location.href="login.jsp";
            timer.clearInterval();
        }
    },1000);
</script>
</body>
</html>
