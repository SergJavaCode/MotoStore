package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;

public class PriceAndAmountProduct implements Comparable {
    public PriceAndAmountProduct(AbstractProduct product, int amount, int price) {
        this.product = product;
        this.price = price;
        this.amount = amount;
    }

    private AbstractProduct product;
    private int price;
    private int amount;
    private int purchased;

    public void setPurchased(int purchased) {
        this.purchased += purchased;
    }

    public int getPurchased() {
        return purchased;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    public AbstractProduct getProduct() {
        return this.product;
    }

    @Override
    public String toString() {
        return "Товар: " + product.getBrand() + " " + product.getNameProduct() +
                ", цена: " + price +
                ", доступное количество: " + amount;
    }


    public int getAmount() {
        return amount;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceAndAmountProduct that = (PriceAndAmountProduct) o;
        return (product.getBrand().equals(that.getProduct().getBrand())) && (product.getNameProduct().equals(that.getProduct().getNameProduct()));
    }

    @Override
    public int hashCode() {
        String concatParametrs = product.getBrand() + product.getNameProduct();
        return (concatParametrs.hashCode());
    }


    @Override
    public int compareTo(Object o) {
        PriceAndAmountProduct that = (PriceAndAmountProduct) o;
        if (this.purchased < that.purchased) {
            return 1;
        } else if (this.purchased == that.purchased) {
            return 0;
        } else return -1;

    }
}
