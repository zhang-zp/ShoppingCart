package control;

import dao.CarDao;
import dao.daoimp.CarDaoImp;
import dao.daoimp.UserDaoImp;
import entity.Goods;
import entity.SUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("*.user")
public class UserControl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        UserDaoImp userDao = new UserDaoImp();
        CarDao carDao = new CarDaoImp();

        if (uri.indexOf("login") >= 0) {
            String id = req.getParameter("u_id");
            int intID = Integer.parseInt(id);
            String password = req.getParameter("password");
            SUser suser = new SUser();
            suser.setU_id(intID);
            suser.setPassword(password);
            // System.out.println("LoginControl测试拿到后台password"+password);
            String name = null;
            try {
                name = userDao.returnName(intID);
                suser.setUsername(name);
                if (userDao.login(suser)) {
                    //用户信息
                    req.getSession().setAttribute("userInfo", suser);
                    //主界面商品列表list
                    List<Goods> list = carDao.goodsList();
                    req.getSession().setAttribute("list", list);
//                System.out.println("LoginControl测试拿到后台ID＝"+id+"int型ID"+intID);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } else {
                    req.setAttribute("error_msg", "用户名或密码错误");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (uri.indexOf("register") >= 0) {

            String username = req.getParameter("username");
            String password = req.getParameter("pwd");
            //System.out.println(username);
            //System.out.println(password);
            SUser user = new SUser();
            user.setUsername(username);
            user.setPassword(password);
            try {
                userDao.register(user);
                int id = userDao.returnUid(username);
                //System.out.println(id);
                req.setAttribute("id",id);
                req.getRequestDispatcher("regSuccess.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (uri.indexOf("checkUsername") >= 0) {
            String username = req.getParameter("username");
            try {
                if (userDao.checkUsername(username)) {
                    pw.write("msg用户名可以使用");
                } else {
                    pw.write("msg用户名已存在!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if(uri.indexOf("list")>=0){

        }
    }
}
