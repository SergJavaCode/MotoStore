package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;

import java.util.List;

public interface Store {
    public void addToStore(AbstractProduct product, int amountProduct, int priceProduct);//добавить товар на склад

    public void delFromStore(PriceAndAmountProductInterface priceAndAmountProduct);//удалить товар со склада

    public void setPriceOfProduct(PriceAndAmountProductInterface priceAndAmountProduct, int priceOfProduct);//поменять цену товарной позиции

    public int getAmountOfProduct(PriceAndAmountProductInterface priceAndAmountProduct);//получить количество единиц продукта в наличии

    public int getPriceOfProduct(PriceAndAmountProductInterface priceAndAmountProduct);//получить текущую цену продукта

    public void setAmountOfProduct(PriceAndAmountProductInterface priceAndAmountProduct, int amountOfProduct);//изменить количество продукта на складе

    public PriceAndAmountProductInterface getPriceAndAmountProduct(int index);//получить объект продукта со склада

    public void showPriceAndAmountProduct();//вывести товары на складе на экран

    public List<PriceAndAmountProductInterface> getListPAAProduct();//получить список товаров имеющихся на складе

}
