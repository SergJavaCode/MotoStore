package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;
import ru.sergjavacode.product.ProductHandleProtection;
import ru.sergjavacode.product.ProductWheels;

import java.util.Scanner;

public class OnlineStoreEmulator {
    Scanner scanner = new Scanner(System.in);
    MotoStore motoStore = new MotoStore();
    Basket basket = new Basket();

    public void start() {


        RecommendationSystemIntrface recommendationSystem = new MotoRecommendationSystem();
        // заполняем склад товарами_____________________________________________________________________________
        AbstractProduct pirelli18on120 = new ProductWheels("Pirelli", "SevenDay", 18, 120);
        AbstractProduct kebda18on110 = new ProductWheels("Kenda", "Ibex", 18, 110);
        AbstractProduct petroshina18on140 = new ProductWheels("Petroshina", "Tractor", 18, 140);
        AbstractProduct kayoProtection = new ProductHandleProtection("Kayo", "HP coat");
        AbstractProduct tipsProtection = new ProductHandleProtection("Tips", "BlackR");
        AbstractProduct lucasProtection = new ProductHandleProtection("Lucas", "StrongEgg");
        motoStore.addToStore(pirelli18on120, 10, 10200);
        motoStore.addToStore(kebda18on110, 20, 12500);
        motoStore.addToStore(kayoProtection, 33, 5400);
        motoStore.addToStore(tipsProtection, 9, 3300);
        motoStore.addToStore(petroshina18on140, 55, 9800);
        motoStore.addToStore(lucasProtection, 26, 7400);
        //_______________________________________________________________________________________________________

        System.out.println("Добро опжаловать в магазин МотоБро!\n");
        System.out.println("Введите адрес доставки товаров:\n");
        String nextLine = scanner.nextLine();
        basket.setAddress(nextLine);
        System.out.println("Список доступных к покупке товаров:");
        motoStore.showPriceAndAmountProduct();
        showMenuRoot();
        while (true) {// меню списка доступных действий
            nextLine = scanner.nextLine();
            int commandNumber = 0;
            commandNumber = validationIntScaner(nextLine);
            switch (commandNumber) {
                case 1:
                    motoStore.showPriceAndAmountProduct();
                    showMenuRoot();
                    break;
                case 2:
                    /*System.out.print("\nВвведите номер товара: ");
                    nextLine = scanner.nextLine();
                    var numberProduct= validationIntScaner(nextLine);
                    System.out.print("\nВвведите требуемое количество: ");
                    nextLine = scanner.nextLine();
                    var amountProduct= validationIntScaner(nextLine);
                    AbstractOrder order = new Order(motoStore.getPriceAndAmountProduct(numberProduct-1),amountProduct);
                    if (basket.addToBasket(order)){
                        System.out.format("\nТовар %s %s в количестве %d шт. добавлен в корзину.\n", order.getProductPAA().getProduct().getBrand(),order.getProductPAA().getProduct().getNameProduct(), amountProduct);
                    } else {
                        System.out.println("Ошибка добавления товара в корзину.\n");
                    }*/
                    addToBasket();
                    showMenuRoot();
                    break;
                case 3:
                    basket.showBasket();
                    showMenuBasket();
                    menuBasketExecute();
                    break;
                case 4:
                    recommendationSystem.weRecommend(motoStore.getListPAAProduct());
                    showMenuRoot();
                    break;
                case 5:
                    System.out.println("\nВведите ключевое слово: ");
                    nextLine = scanner.nextLine();
                    System.out.printf("Список отфильтрованный по ключевому слову \"%s\":\n\n", nextLine);
                    motoStore.filterByKeyWord(nextLine);
                    showMenuRoot();
                    break;
                case 6:
                    int priceFilter = 0;
                    System.out.println("\nВведите цену для сортровки: ");
                    nextLine = scanner.nextLine();
                    priceFilter = validationIntScaner(nextLine);
                    System.out.println("\nВведите направление сортировки (\"больше\" или \"меньше\": ");
                    nextLine = scanner.nextLine();
                    if ("больше".equals(nextLine)) {
                        motoStore.filterByPrice(priceFilter, true);
                    } else if ("меньше".equals(nextLine)) {
                        motoStore.filterByPrice(priceFilter, false);
                    } else {
                        System.out.println("Вы ввели некорректное значение!");
                    }
                    showMenuRoot();
                    break;
                case 7:
                    System.out.println("\nВведите производителя: ");
                    nextLine = scanner.nextLine();
                    System.out.printf("Список отфильтрованный по производителю \"%s\":\n\n", nextLine);
                    motoStore.filterByBrand(nextLine);
                    showMenuRoot();
                    break;
                case 8:
                    motoStore.sortedByRating();
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Выберите действие.");
            }
        }
    }

    private void menuBasketExecute() {
        String nextLine;
        while (true) {
            int commandNumber = 0;
            nextLine = scanner.nextLine();
            commandNumber = validationIntScaner(nextLine);
            switch (commandNumber) {
                case 1:
                    basket.showBasket();
                    showMenuBasket();
                    break;
                case 2:
                    System.out.println("Стоимость товаров в корзине: " + basket.getCostBasket() + " руб.");
                    showMenuBasket();
                    break;
                case 3:
                    addToBasket();
                    showMenuBasket();
                    break;
                case 4:
                    System.out.print("\nВвведите номер удаляемой позиции в корзине: ");
                    nextLine = scanner.nextLine();
                    commandNumber = validationIntScaner(nextLine);
                    if (basket.delToBasket(basket.getOrder(commandNumber))) {
                        System.out.println("\nТовар успешно удален из корзины");
                    } else {
                        System.out.println("Ошибка удаления товара из корзины.\n");
                    }
                    showMenuBasket();
                    break;
                case 5:
                    if (basket.sendAnOrder()) {
                        System.out.println("Товары из корзины успешно отправлены по адресу: " + basket.getAddress());
                    }
                    showMenuBasket();
                    break;
                case 6:
                    System.out.println("Исполненные заказы: ");
                    if (basket.getbasketOrdersFulfilled().isEmpty()) {
                        System.out.println("Исполненные заказы отсутствуют.");
                    } else {
                        final int[] count = {1};
                        System.out.println("Ранее вы купили:\n");
                        basket.getbasketOrdersFulfilled().stream().forEach(o -> {
                            System.out.print(count[0] + ". ");
                            System.out.println(o.toString());
                            count[0] += 1;
                        });
                    }
                    System.out.print("Введите номер заказа для его повтора: ");
                    nextLine = scanner.nextLine();
                    commandNumber = validationIntScaner(nextLine);
                    if (basket.repeatSendAnOrder(commandNumber)) {
                        System.out.println("Заказ успешно повторён.");
                    } else {
                        System.out.println("Ошибка повторения заказа");
                    }
                    showMenuBasket();
                    break;
                case 7:
                    showMenuRoot();
                    break;
            }
            if (nextLine.equals("7")) {
                break;
            }
        }
    }

    private void addToBasket() {
        System.out.print("\nВвведите номер товара: ");
        String nextLine = scanner.nextLine();
        var numberProduct = validationIntScaner(nextLine);
        System.out.print("\nВвведите требуемое количество: ");
        nextLine = scanner.nextLine();
        var amountProduct = validationIntScaner(nextLine);
        AbstractOrder order = new Order(motoStore.getPriceAndAmountProduct(numberProduct - 1), amountProduct);
        if (basket.addToBasket(order)) {
            System.out.format("\nТовар %s %s в количестве %d шт. добавлен в корзину.\n", order.getProductPAA().getProduct().getBrand(), order.getProductPAA().getProduct().getNameProduct(), amountProduct);
        } else {
            System.out.println("Ошибка добавления товара в корзину.\n");
        }
    }

    private int validationIntScaner(String valueStr) {
        int valueInt = 0;
        try {
            valueInt = Integer.parseInt(valueStr);
        } catch (NumberFormatException e) {
            System.out.println("Введите корректное значение!");
        }
        return valueInt;
    }

    private void showMenuRoot() {
        System.out.println("\nОНОВНОЕ МЕНЮ\n" +
                "1. Показать список доступных к покупке товаров.\n" +
                "2. Добавить в корзину.\n" +
                "3. Показать корзину.\n" +
                "4. Просмотреть рекомендацию.\n" +
                "5. Фильтрация товаров по ключевым словам.\n" +
                "6. Фильтрация товаров по ценам.\n" +
                "7. Фильтрация товаров по производителям.\n" +
                "8. Фильтрация по рейтингу (кол-ву уже сделанных покупок.)\n" +
                "9. Выход из магазина.\n" +
                "Ведите номер команды: "
        );

    }

    private void showMenuBasket() {
        System.out.println("\nМЕНЮ КОРЗИНЫ\n" +
                "1. Показать список товаров в корзине.\n" +
                "2. Показать стоимость товаров в корзине.\n" +
                "3. Добавить товар в корзину.\n" +
                "4. Удалить твар из корзины.\n" +
                "5. Отправить заказ.\n" +
                "6. Повторить заказ.\n" +
                "7. Возврат в предыдущее(корневое) меню.\n" +
                "Ведите номер команды: "
        );
    }
}
