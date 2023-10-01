package ru.sergjavacode;

public class Order extends AbstractOrder {
    private Order() {
    }

    ; // запрещаем пустойц контсруктор

    public Order(PriceAndAmountProductInterface productPAA, int amountOrder) {
        this.setProduct(productPAA);
        this.setAmountOrder(amountOrder);
    }
}
