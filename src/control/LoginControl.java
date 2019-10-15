package control;

import dao.CarDao;
import dao.daoimp.CarDaoImp;
import dao.daoimp.UserDaoImp;
import entity.Goods;
import entity.SUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class LoginControl {

    /**
     * 登录功能的逻辑
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    public static void loginControl(HttpServletRequest req, HttpServletResponse resp) {
        // 设置编码格式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset = utf-8");
        // 拿到uri请求地址
        // String uri = req.getRequestURI();
        PrintWriter pw = null;
        //System.out.println(uri);
        // 请求时登录的时候
        // 拿到页面信息
        String id = null;
        id = req.getParameter("u_id");
        int intID = Integer.parseInt(id);
        String password = req.getParameter("password");

        SUser suser = new SUser();
        suser.setU_id(intID);
        suser.setPassword(password);
        String name = null;
        // System.out.println("LoginControl测试拿到后台password"+password);
        UserDaoImp dao = new UserDaoImp();
        try {
            name = dao.returnName(intID);
            suser.setUsername(name);
            pw = resp.getWriter();
            if (dao.login(suser)) {
                req.setAttribute("name", name);
                req.setAttribute("ID",id);
                req.getSession().setAttribute("userInfo",suser);
                CarDao carDaodao = new CarDaoImp();
                List<Goods> list = carDaodao.goodsList();
                req.setAttribute("list",list);
//                System.out.println("LoginControl测试拿到后台ID＝"+id+"int型ID"+intID);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else {
                req.setAttribute("error_msg","用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
