package entity;

/**
 * 个人购物车
 */
public class PersonalGoods {

    private String g_name;
    private String g_price;
    private int goodsNum;
    private int sumPrice;

    public String getG_name() {
        return g_name;
    }

    public String getG_price() {
        return g_price;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public int getSumPrice() {
        return sumPrice;
    }

//    public void setG_name(String g_name) {
//        this.g_name = g_name;
//    }
//
//    public void setG_price(String g_price) {
//        this.g_price = g_price;
//    }
//
//    public void setGoodsNum(int goodsNum) {
//        this.goodsNum = goodsNum;
//    }
//
//    public void setSumPrice(int sumPrice) {
//        this.sumPrice = sumPrice;
//    }

    @Override
    public String toString() {
        return "PersonalGoods{" +
                "g_name='" + g_name + '\'' +
                ", g_price='" + g_price + '\'' +
                ", goodsNum=" + goodsNum +
                ", sumPrice='" + sumPrice + '\'' +
                '}';
    }
}
