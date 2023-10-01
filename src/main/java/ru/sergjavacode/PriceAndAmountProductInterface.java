package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;

public interface PriceAndAmountProductInterface {
    public void setPurchased(int purchased);

    public int getPurchased();

    public void setAmount(int amount);

    public AbstractProduct getProduct();

    public int getAmount();

    public int getPrice();

    public void setPrice(int price);
}
