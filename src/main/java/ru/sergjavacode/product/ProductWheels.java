package ru.sergjavacode.product;

public class ProductWheels extends AbstractProduct {
    private int radius;
    private int width;

    private ProductWheels() {
    }// запрещаем пустойц контсруктор

    public ProductWheels(String brand, String nameProduct, int radius, int width) {
        this.setBrand(brand);
        this.setNameProduct(nameProduct);
        this.radius = radius;
        this.width = width;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getRadius() {
        return radius;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductWheels that = (ProductWheels) o;
        return that.radius == radius && that.width == width && (this.getBrand().equals(that.getBrand())) && (this.getNameProduct().equals(that.getNameProduct()));
    }

    @Override
    public int hashCode() {
        String concatParametrs = this.getBrand() + this.getNameProduct() + Integer.toString(radius) + Integer.toString(width);
        return (concatParametrs.hashCode());
    }

}
