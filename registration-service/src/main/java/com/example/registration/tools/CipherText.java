package com.example.registration.tools;

import org.springframework.util.DigestUtils;

public class CipherText {

    public static String getCipherText(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}