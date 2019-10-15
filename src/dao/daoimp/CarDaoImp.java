package dao.daoimp;

import dao.CarDao;
import entity.Goods;
import entity.SCar;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.List;

public class CarDaoImp implements CarDao {

    QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

//    @Override
//    public void newCar(int uid) throws SQLException {
//        String sql = "insert into s_car(U_ID) values(?)";
//        queryRunner.update(sql,uid);
//    }

    @Override
    public void addGoodsToCar(int uid,Goods goods) throws SQLException {
        String sql = "insert into s_car(U_ID,G_NAME,G_PRICE,G_NUMBER) values(?,?,?,?)";
        queryRunner.update(sql,uid,goods.getG_name(),goods.getG_price(),1);
    }

    @Override
    public void clearCar(int id) throws SQLException {
        String sql = "delete from s_car where u_id=?";
        queryRunner.update(sql,id);
    }

    @Override
    public List<SCar> showCar(int uid) throws SQLException {
        String sql = "select g_name,g_price,sum(g_number) goodsNum,sum(g_number)*g_price sumPrice " +
                "from s_car where u_id = ? group by g_name,g_price";
        return queryRunner.query(sql,new BeanListHandler<SCar>(SCar.class),uid);
    }

    @Override
    public List<Goods> goodsList() throws SQLException {
        String sql = "select * from S_LIST";
        return queryRunner.query(sql,new BeanListHandler<Goods>(Goods.class));
    }

    @Override
    public void deleteGoods(int u_id, String goodsName) throws SQLException {
        String sql = "delete from s_car where u_id=? and g_name=?";
        queryRunner.update(sql,u_id,goodsName);
    }
}
