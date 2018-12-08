package com.example.utils;

import java.util.Random;

public final class MathUtils {
    /**
     * @param start
     * @param end
     * @return [start, end]范围内随机值
     */
    public static int random(int start, int end) {
        return start + new Random().nextInt(end - start + 1);
    }
}
