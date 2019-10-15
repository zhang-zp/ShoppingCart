package dao;

import entity.Goods;
import entity.PersonalGoods;
import entity.SCar;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    /**
     * 用户注册成功生成一个空的购物车
     * @param uid
     */
   // void newCar(int uid) throws SQLException;

    /**
     * 添加商品到购物车
     * @param uid 用户ID
     * @param goods 商品对象
     * @throws SQLException
     */
    void addGoodsToCar(int uid,Goods goods) throws SQLException;

    /**
     * 清空购物车
     * @throws SQLException
     */

    void clearCar(int id) throws SQLException;

    /**
     * 展示购物车
     * @throws SQLException
     */
    List<SCar> showCar(int uid) throws SQLException;

    List<Goods> goodsList() throws SQLException;

    /**
     * 删除购物车中的某件商品
     * @param u_id
     * @param goodsName
     * @throws SQLException
     */
    void deleteGoods(int u_id,String goodsName) throws SQLException;
}
