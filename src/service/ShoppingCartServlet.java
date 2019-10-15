package service;

import control.AddGoodsControl;
import control.LoginControl;
import control.RegisterControl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        //System.out.println(uri);
        if (uri.indexOf("login") >= 0) {

            /**
             * 登录
             */
            LoginControl.loginControl(req, resp);

        } else if (uri.indexOf("register") >= 0) {

           // System.out.println("注册进来了吗？");
            /**
             * 注册
             */
            RegisterControl.registerControl(req, resp);

        } else if(uri.contains("addGoods")){
            // System.out.println("添加购物车进来了吗?");
            AddGoodsControl.addGoodsControl(req, resp);
        }


    }


}
