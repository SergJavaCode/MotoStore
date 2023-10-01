package ru.sergjavacode;

import ru.sergjavacode.product.AbstractProduct;
import ru.sergjavacode.product.ProductHandleProtection;
import ru.sergjavacode.product.ProductWheels;

public class Main {
    public static void main(String[] args) {
        OnlineStoreEmulator onlineStoreEmulator = new OnlineStoreEmulator();
        onlineStoreEmulator.start();

    }
}