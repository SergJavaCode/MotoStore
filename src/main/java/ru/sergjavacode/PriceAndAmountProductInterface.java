package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;

public interface PriceAndAmountProductInterface {
    public void setPurchased(int purchased);// запоминаем число покупок данного товара

    public int getPurchased();// получаем число покупок данного товара

    public void setAmount(int amount); //устанавливаем количество доступных единиц товара

    public AbstractProduct getProduct(); //получаем объект конкретного продукта

    public int getAmount();//получаем количество доступных единиц товара

    public int getPrice();//получаем цену конкретного товара

    public void setPrice(int price); //устанавливаем цену конкретного товара
}
