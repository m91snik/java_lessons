package com.vega.server.until;

import org.springframework.security.core.token.Sha512DigestUtils;

/**
 * Created by Вася-Вега on 09.09.2015.
 */
public class PasswordUntil {

    public static String getPasswordHash(String password, String salt){
        return Sha512DigestUtils.shaHex(password + salt);
    }

}
