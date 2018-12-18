package com.example.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ThreadUtils {
    @SneakyThrows
    public static void sleep(long millis) {
        Thread.sleep(millis);
    }
}
