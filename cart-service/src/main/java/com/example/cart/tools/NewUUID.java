package com.example.cart.tools;

import java.util.UUID;

public class NewUUID {
    public static String get() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
