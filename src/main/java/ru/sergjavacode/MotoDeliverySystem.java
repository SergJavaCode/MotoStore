package ru.sergjavacode;

public class MotoDeliverySystem implements DeliverySystemInterface {
    private String address;

    private MotoDeliverySystem() {
    }// запрещаем пустойц контсруктор

    public MotoDeliverySystem(String address) {
        this.address = address;
    }

    @Override
    public void sendOrder() {
        System.out.println("Товар отправлен по адресу: " + address);
    }
}
