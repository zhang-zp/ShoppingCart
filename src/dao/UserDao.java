package dao;

import entity.SUser;

import java.sql.SQLException;

/**
 * 用户dao层
 */
public interface UserDao {
    boolean login(SUser user) throws SQLException;
    void register(SUser user) throws SQLException;
    boolean checkUsername(String username) throws SQLException;
    String returnName(int id) throws SQLException;
    int returnUid(String username) throws SQLException;
}
