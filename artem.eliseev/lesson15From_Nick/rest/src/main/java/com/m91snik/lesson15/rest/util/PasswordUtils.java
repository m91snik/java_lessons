package com.m91snik.lesson15.rest.util;

import org.springframework.security.core.token.Sha512DigestUtils;

/**
 * Created by m91snik on 12.08.15.
 */
public class PasswordUtils {

    public static String getPasswordHash(String password, String salt) {
        return Sha512DigestUtils.shaHex(password + salt);
    }
}
