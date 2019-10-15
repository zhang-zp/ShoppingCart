package entity;

/**
 * 购物车 对应表s_car
 */
public class SCar {
    private int u_id;
    private int g_id;//自动生成的
    private int g_number;

    private String g_name;
    private String g_price;
    private int goodsNum;
    private int sumPrice;
    private double account;

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public SCar() {
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public void setG_price(String g_price) {
        this.g_price = g_price;
    }

    public void setG_number(int g_number) {
        this.g_number = g_number;
    }

    public int getU_id() {
        return u_id;
    }

    public int getG_id() {
        return g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public String getG_price() {
        return g_price;
    }

    public int getG_number() {
        return g_number;
    }

    @Override
    public String toString() {
        return "SCar{" +
                "g_name='" + g_name + '\'' +
                ", g_price='" + g_price + '\'' +
                ", g_number=" + g_number +
                '}';
    }
}
