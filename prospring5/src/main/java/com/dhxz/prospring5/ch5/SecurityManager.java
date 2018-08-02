package com.dhxz.prospring5.ch5;

import java.util.Optional;

public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String userName,String password) {
        threadLocal.set(UserInfo.builder()
                .userName(userName)
                .password(password)
                .build());
    }

    public void logout() {
        threadLocal.remove();
    }

    public Optional<UserInfo> getLoggedOnUser() {
        return Optional.ofNullable(threadLocal.get());
    }
}
