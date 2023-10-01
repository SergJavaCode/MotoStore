package ru.sergjavacode;

import java.util.List;

public interface BasketInterface {
    public boolean addToBasket(AbstractOrder order); //добавить заказ в корзину
    public AbstractOrder getOrder(int index);
    public List<AbstractOrder> getbasketOrdersFulfilled();

    public boolean delToBasket(AbstractOrder order); //удалить заказ из корзины

    public int getCostBasket(); //получить сумму/стоимость товаров в корзине

    public boolean sendAnOrder(); //отправить товары из корзины получателю

    public boolean repeatSendAnOrder(int index); //повторить заказ
    public void showBasket(); //показать содержимое корзины
}
