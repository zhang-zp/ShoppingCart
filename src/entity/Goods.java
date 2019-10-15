package entity;

/**
 * 商品信息表
 */
public class Goods {

    private String g_photo;
    private String g_name;
    private String g_price;


    public void setG_photo(String g_photo) {
        this.g_photo = g_photo;
    }
    public String getG_photo() {
        return g_photo;
    }

    public String getG_name() {
        return g_name;
    }

    public String getG_price() {
        return g_price;
    }


    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public void setG_price(String g_price) {
        this.g_price = g_price;
    }
}
