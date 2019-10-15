package service.serviceImp;

import entity.SCar;
import service.CarService;

import java.util.List;

public class CarServiceImp implements CarService {

    /**
     * 返回购物车商品总价格
     * @param car
     * @return
     */
    @Override
    public double account(List<SCar> car) {
        double price = 0;
        for (int i = 0; i<car.size();i++){
            price+=car.get(i).getSumPrice();
        }
        return price;
    }
}
