package control;

import dao.UserDao;
import dao.daoimp.CarDaoImp;
import dao.daoimp.UserDaoImp;
import entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class AddGoodsControl {

    /**
     * 添加商品到购物车
     * @param req
     * @param resp
     */
    public static void addGoodsControl(HttpServletRequest req, HttpServletResponse resp) {

        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset = utf-8");

        String goodsName = req.getParameter("name");
        String goodsPrice = req.getParameter("price");
        String ID = req.getParameter("id");
        int userID = Integer.parseInt(ID);

        System.out.println(goodsName);
        System.out.println(goodsPrice);
        System.out.println("传过来的用户ID"+userID);

//添加商品的对象
        Goods goods = new Goods();
        goods.setG_name(goodsName);
        goods.setG_price(goodsPrice);

        CarDaoImp dao = new CarDaoImp();
        UserDao u_dao = new UserDaoImp();
        try {
            req.setAttribute("name",u_dao.returnName(userID));
            //System.out.println("test");
            dao.addGoodsToCar(userID,goods);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
