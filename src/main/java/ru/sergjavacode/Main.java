package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;
import ru.sergjavacode.product.ProductHandleProtection;
import ru.sergjavacode.product.ProductWheels;

public class Main {
    public static void main(String[] args) {
       /* MotoStore motoStore= new MotoStore();
        AbstractProduct pirelli18on120= new ProductWheels("Pirelli", "SevenDay", 18, 120);
        AbstractProduct kebda18on110= new ProductWheels("Kenda", "Ibex", 18, 110);
        AbstractProduct kayoProtection= new ProductHandleProtection("Kayo",  "HP coat");
        AbstractProduct tipsProtection= new ProductHandleProtection("Tips",  "BlackR");
        motoStore.addToStore(pirelli18on120,10,10200);
        motoStore.addToStore(kebda18on110, 20, 12500);
        motoStore.addToStore(kayoProtection, 33, 5400);
        motoStore.addToStore(tipsProtection,9, 3300);
        motoStore.addToStore(pirelli18on120,12,10200); //проверяем на отсутствие повторений товарных позиций


        BasketInterface basket = new Basket("Samara, Kirova str., 219");
        motoStore.showPriceAndAmountProduct();
        AbstractOrder order1= new Order(motoStore.getPriceAndAmountProduct(0),5);
        basket.addToBasket(order1);
        System.out.println(basket.getCostBasket());
        motoStore.filterByBrand("Pirelli");
        System.out.println();
        motoStore.filterByPrice(10_000, true);
        System.out.println();
        motoStore.filterByKeyWord("bl");
        System.out.println();

        System.out.println("___________________________");
        basket.sendAnOrder();
        motoStore.sortedByRating();*/
        OnlineStoreEmulator onlineStoreEmulator=new OnlineStoreEmulator();
        onlineStoreEmulator.start();

    }
}