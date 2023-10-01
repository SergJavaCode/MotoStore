package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;

import java.util.List;

public interface Store {
    public void addToStore(AbstractProduct product, int amountProduct, int priceProduct);

    public void delFromStore(PriceAndAmountProductInterface priceAndAmountProduct);

    public void setPriceOfProduct(PriceAndAmountProductInterface priceAndAmountProduct, int priceOfProduct);

    public int getAmountOfProduct(PriceAndAmountProductInterface priceAndAmountProduct);

    public int getPriceOfProduct(PriceAndAmountProductInterface priceAndAmountProduct);

    public void setAmountOfProduct(PriceAndAmountProductInterface priceAndAmountProduct, int amountOfProduct);

    public PriceAndAmountProductInterface getPriceAndAmountProduct(int index);

    public void showPriceAndAmountProduct();

    public List<PriceAndAmountProductInterface> getListPAAProduct();

}
