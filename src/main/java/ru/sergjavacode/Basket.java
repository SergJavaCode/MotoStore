package ru.sergjavacode;

import java.util.ArrayList;
import java.util.List;

public class Basket implements BasketInterface {
    private String address;
    private static int costBasket;
    private List<AbstractOrder> basketOrders = new ArrayList<>();
    private List<AbstractOrder> basketOrdersFulfilled = new ArrayList<>();

    public Basket() {
    }

    public Basket(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean addToBasket(AbstractOrder order) {
        if (order.getProductPAA().getAmount() >= order.getAmountOrder()) {
            basketOrders.add(order);
            order.getProductPAA().setAmount(order.getProductPAA().getAmount() - order.getAmountOrder());
            return true;
        } else {
            System.out.println("Запрошенное количество товара превышает остаток на складе! Заказ не добавлен.");
            return false;
        }

    }

    @Override
    public AbstractOrder getOrder(int index) {
        return basketOrders.get(index);
    }

    @Override
    public List<AbstractOrder> getbasketOrdersFulfilled() {
        return basketOrdersFulfilled;
    }

    @Override
    public boolean delToBasket(AbstractOrder order) {
        return basketOrders.remove(order);
    }

    @Override
    public int getCostBasket() {
        basketOrders.stream().forEach(p -> {
            costBasket = costBasket + p.getCostOrder();
        });
        return costBasket;
    }

    @Override
    public boolean sendAnOrder() { // отправить заказ
        if (!address.isEmpty()) {
            basketOrders.stream().forEach(o -> o.getProductPAA().setPurchased(o.getAmountOrder())); //обновляем счетчик продаж товара
            DeliverySystemInterface deliverySystem = new MotoDeliverySystem(address);
            deliverySystem.sendOrder(); // посылаем товар
            basketOrders.stream().forEach(o -> { //добавляем заказы в исполнененные
                basketOrdersFulfilled.add(o);
            });
            basketOrders.clear(); // отчищаем корзину
            return true;
        } else {
            System.out.println("Добавьте адресс доставки.");
            return false;
        }
    }

    @Override
    public boolean repeatSendAnOrder(int index) {
        return this.addToBasket(basketOrdersFulfilled.get(index));
    }

    @Override
    public void showBasket() {
        if (basketOrders.isEmpty()) {
            System.out.println("Корзина пуста. Добавьте товар.");
        } else {
            final int[] count = {1};
            System.out.println("В корзине:\n");
            basketOrders.stream().forEach(o->{
                System.out.print(count[0] + ". ");
                System.out.println(o.toString());
                count[0] +=1;
            });
            System.out.println("Стоимость товаров в корзине: " + this.getCostBasket() + " руб.");
        }
    }

}
