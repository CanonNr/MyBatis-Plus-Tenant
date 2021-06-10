package com.example.mybatisplus.tenant.config;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    private static final ThreadLocal<LocalUser> userThreadLocal = new ThreadLocal<LocalUser>();

    public static void addCurrentUser(LocalUser user) {
        userThreadLocal.set(user);
    }

    public static LocalUser getCurrentUser() {
        return userThreadLocal.get();
    }

    public static void remove() {
        userThreadLocal.remove();
    }
}
