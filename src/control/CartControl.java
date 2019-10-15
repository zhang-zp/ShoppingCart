package control;

import dao.CarDao;
import dao.daoimp.CarDaoImp;
import dao.daoimp.UserDaoImp;
import entity.Goods;
import entity.SCar;
import entity.SUser;
import service.CarService;
import service.serviceImp.CarServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("*.cart")
public class CartControl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        UserDaoImp userDao = new UserDaoImp();
        CarDao carDao = new CarDaoImp();
        CarService carService = new CarServiceImp();
//      得到用户信息
        HttpSession session = req.getSession();
        SUser user = (SUser) session.getAttribute("userInfo");
        if(uri.indexOf("buy")>=0){

//            得到用户ID和商品名称和价格
            String goodsName = req.getParameter("g_name");
            String goodsPrice = req.getParameter("g_price");
//          构建商品对象
            Goods goods = new Goods();
            goods.setG_name(goodsName);
            goods.setG_price(goodsPrice);
//            添加到购物车
            try {
                carDao.addGoodsToCar(user.getU_id(),goods);
                List<SCar> cart = carDao.showCar(user.getU_id());
//                购物车商品总价值account
                req.getSession().setAttribute("account",carService.account(cart));
                req.getSession().setAttribute("cart",cart);
                pw.write("msg添加成功!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if(uri.indexOf("clear")>=0){
            try {
                carDao.clearCar(user.getU_id());
                List<SCar> cart = carDao.showCar(user.getU_id());
                req.getSession().setAttribute("cart",cart);
                //                购物车商品总价值account
                req.getSession().setAttribute("account",carService.account(cart));
                req.getRequestDispatcher("cart.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if(uri.indexOf("deleteGoods")>=0){
//            System.out.println("要删除"+req.getParameter("goodsName"));
            try {
//                执行删除操作后返回购物车列表
                carDao.deleteGoods(user.getU_id(),req.getParameter("goodsName"));
                List<SCar> cart = carDao.showCar(user.getU_id());
                req.getSession().setAttribute("cart",cart);
                req.getSession().setAttribute("account",carService.account(cart));
                req.getRequestDispatcher("cart.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
