package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MotoStore implements Store {
    private List<PriceAndAmountProductInterface> motoStore = new ArrayList<>();

    @Override
    public void addToStore(AbstractProduct product, int amountProduct, int priceProduct) {
        if (!(motoStore.stream().filter(o -> o.getProduct().equals(product)).count() > 0)) { //проверяем на отсутствие повторений товарных позиций на складе
            motoStore.add(new PriceAndAmountProduct(product, amountProduct, priceProduct)); // если такой позиции не было, добавляем на склад
        } else {
            System.out.printf("Товарная позиция %s уже имеется на складе.\n", product.getBrand() + " " + product.getNameProduct());
        }
    }

    @Override
    public void delFromStore(PriceAndAmountProductInterface priceAndAmountProduct) {
        motoStore.remove(priceAndAmountProduct);
    }

    @Override
    public void setPriceOfProduct(PriceAndAmountProductInterface priceAndAmountProduct, int priceOfProduct) {
        int i = motoStore.indexOf(priceAndAmountProduct);
        motoStore.get(i).setPrice(priceOfProduct);
    }

    @Override
    public int getAmountOfProduct(PriceAndAmountProductInterface priceAndAmountProduct) {
        int i = motoStore.indexOf(priceAndAmountProduct);
        return motoStore.get(i).getAmount();
    }

    @Override
    public int getPriceOfProduct(PriceAndAmountProductInterface priceAndAmountProduct) {
        int i = motoStore.indexOf(priceAndAmountProduct);
        return motoStore.get(i).getPrice();
    }

    @Override
    public void setAmountOfProduct(PriceAndAmountProductInterface priceAndAmountProduct, int amountOfProduct) {
        int i = motoStore.indexOf(priceAndAmountProduct);
        motoStore.get(i).setAmount(amountOfProduct);
    }

    @Override
    public PriceAndAmountProductInterface getPriceAndAmountProduct(int index) {
        return motoStore.get(index);
    }

    @Override
    public void showPriceAndAmountProduct() {
        motoStore.stream().forEach(o -> {
            System.out.format("%d |%-40s| Цена руб.: %-10d| Доступное кол-во: %-10d| Куплено шт.: %d \n", motoStore.indexOf(o) + 1, o.getProduct(), o.getPrice(), o.getAmount(), o.getPurchased());
        });

    }

    @Override
    public List<PriceAndAmountProductInterface> getListPAAProduct() {
        return motoStore;
    }

    public void sortedByRating() {
        motoStore.stream().sorted().forEach(o -> {
            System.out.format("%d |%-40s| Цена руб.: %-10d|  Доступное кол-во: %-10d| Куплено шт.: %d \n", motoStore.indexOf(o) + 1, o.getProduct(), o.getPrice(), o.getAmount(), o.getPurchased());
        });
    }

    public void filterByBrand(String brand) {
        List<PriceAndAmountProductInterface> motoStoreFiltered = new ArrayList<>(motoStore.stream().filter(o -> brand.toLowerCase().equals(o.getProduct().getBrand().toLowerCase())).collect(Collectors.toList()));
        if (motoStoreFiltered.isEmpty()) {
            System.out.println("Не найдено подходящих товаров!");
        } else {
            motoStoreFiltered.stream().forEach(System.out::println);
        }
    }

    public void filterByPrice(int border, boolean moreOrLess) {
        if (moreOrLess) {
            motoStore.stream().filter(o -> o.getPrice() > border).forEach(System.out::println);
        } else {
            motoStore.stream().filter(o -> o.getPrice() < border).forEach(System.out::println);
        }

    }

    public void filterByKeyWord(String key) {
        List<PriceAndAmountProductInterface> motoStoreFiltered = new ArrayList<>(motoStore.stream().filter(o -> o.getProduct().getNameProduct().toLowerCase().contains(key.toLowerCase()) || o.getProduct().getBrand().toLowerCase().contains(key.toLowerCase())).collect(Collectors.toList()));
        if (motoStoreFiltered.isEmpty()) {
            System.out.println("Не найдено подходящих товаров!");
        } else {
            motoStoreFiltered.stream().forEach(System.out::println);
        }
    }


}
