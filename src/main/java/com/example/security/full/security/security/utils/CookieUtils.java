package com.example.security.full.security.security.utils;

import com.example.security.full.security.security.config.Constants;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtils {

    public static Cookie generateCookie(String value) {
        Cookie cookie = new Cookie("jwt", value);
        cookie.setMaxAge((int) (Constants.EXPIRATION_TIME / 1000)); // expires in 10 days
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }
}
