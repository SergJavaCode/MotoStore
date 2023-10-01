package ru.sergjavacode;
public class AbstractOrder {
    private PriceAndAmountProduct productPAA;
    private int amountOrder;

    public void setProduct(PriceAndAmountProduct productPAA) {
        this.productPAA = productPAA;
    }

    public void setAmountOrder(int amountOrder) {
        this.amountOrder = amountOrder;
    }

    public PriceAndAmountProduct getProductPAA() {
        return productPAA;
    }

    public int getAmountOrder() {
        return amountOrder;
    }


    public int getCostOrder() {
        return amountOrder* productPAA.getPrice();
    }

    @Override
    public String toString() {
        return "Товар: " +
                productPAA.getProduct().getBrand() +
                " "+
                productPAA.getProduct().getNameProduct()+
                ",  в количестве " + amountOrder +" шт. "+
                "стоимостью "+
                getCostOrder() +" руб.";
    }
}
