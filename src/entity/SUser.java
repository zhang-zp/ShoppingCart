package entity;

/**
 * 用户类 对应s_user表
 */
public class SUser {
    private int u_id;//数据库自动生成的
    private String username;
    private String password;

    public SUser() {
    }

    public int getU_id() {
        return u_id;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
