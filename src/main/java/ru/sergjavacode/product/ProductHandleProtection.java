package ru.sergjavacode.product;

import ru.sergjavacode.product.AbstractProduct;

public class ProductHandleProtection extends AbstractProduct {
    private ProductHandleProtection(){}// запрещаем пустойц контсруктор
    public ProductHandleProtection(String brand, String nameProduct) {
        this.setBrand(brand);
        this.setNameProduct(nameProduct);
    }
}
