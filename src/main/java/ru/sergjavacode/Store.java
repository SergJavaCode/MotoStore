package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;

import java.util.List;

public interface Store {
    public void addToStore (AbstractProduct product, int amountProduct, int priceProduct);
    public void delFromStore(PriceAndAmountProduct priceAndAmountProduct);
    public void setPriceOfProduct(PriceAndAmountProduct priceAndAmountProduct, int priceOfProduct);
    public int getAmountOfProduct(PriceAndAmountProduct priceAndAmountProduct);
    public int getPriceOfProduct(PriceAndAmountProduct priceAndAmountProduct);
    public void setAmountOfProduct(PriceAndAmountProduct priceAndAmountProduct, int amountOfProduct);
    public PriceAndAmountProduct getPriceAndAmountProduct(int index);
    public void showPriceAndAmountProduct();
    public List<PriceAndAmountProduct> getListPAAProduct();

}
