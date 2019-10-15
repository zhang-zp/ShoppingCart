package control;

import dao.daoimp.UserDaoImp;
import entity.SUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class RegisterControl {

    /**
     * 注册功能的逻辑
     * @param req
     * @param resp
     */
    public static void registerControl(HttpServletRequest req, HttpServletResponse resp) {
        // 设置编码格式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset = utf-8");

        UserDaoImp dao = new UserDaoImp();
        PrintWriter pw = null;

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        //System.out.println(username);
        //System.out.println(password);
        SUser user = new SUser();
        user.setUsername(username);
        user.setPassword(password);
        try {
            pw = resp.getWriter();
            if (dao.checkUsername(user.getUsername())) {
                dao.register(user);
                int id = dao.returnUid(username);
                //System.out.println(id);
                req.setAttribute("id",id);
                try {
                    req.getRequestDispatcher("regSuccess.jsp").forward(req,resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            } else {
                pw.write("用户名已存在!");
            }
        } catch (SQLException e) {
            pw.write("注册异常");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
