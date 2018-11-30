package com.example.utils;

import java.sql.Timestamp;
import java.util.Date;

public final class TimeUtils {
    public static long nowMs() {
        return new Date().getTime();
    }
    public static Timestamp nowTimestamp() {
        return new Timestamp(nowMs());
    }
}
