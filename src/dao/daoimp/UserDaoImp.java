package dao.daoimp;

import dao.UserDao;
import entity.SUser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.C3p0Utils;

import java.sql.SQLException;

public class UserDaoImp implements UserDao {

    QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

    /**
     * 返回true则登录成功
     *
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public boolean login(SUser user) throws SQLException {
        String sql = "select * from s_user where U_id = ? and password = ?";
        SUser suser = queryRunner.query(sql, new BeanHandler<SUser>(SUser.class), user.getU_id(), user.getPassword());
        return suser != null;
    }

    /**
     * 注册
     *
     * @param user
     * @throws SQLException
     */
    @Override
    public void register(SUser user) throws SQLException {
        String sql = "insert into s_user(u_id,username,password) values(user_u_id.nextval,?,?)";
        queryRunner.update(sql, user.getUsername(), user.getPassword());
    }

    /**
     * 返回true则用户名不重复
     *
     * @param username
     * @return
     * @throws SQLException
     */
    @Override
    public boolean checkUsername(String username) throws SQLException {
        String sql = "select * from s_user where username = ?";
        return queryRunner.query(sql, new BeanHandler<SUser>(SUser.class), username) == null;
    }

    /**
     * 根据用户ID拿到用户名
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public String returnName(int id) throws SQLException {
        String sql = "select username from s_user where u_id = ?";
        SUser newUser = queryRunner.query(sql,new BeanHandler<SUser>(SUser.class),id);
        return newUser.getUsername();
    }

    /**
     * 返回用户ID
     *
     * @return
     */
    public int returnUid(String username) throws SQLException {
        String sql = "select u_id from s_user where username = ?";
        SUser newUser = queryRunner.query(sql, new BeanHandler<SUser>(SUser.class), username);
        return newUser.getU_id();
    }

}
