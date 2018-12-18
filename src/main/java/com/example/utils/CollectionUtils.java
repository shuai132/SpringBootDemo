package com.example.utils;

import java.util.Collection;
import java.util.function.Function;

public final class CollectionUtils {
    public static <T, V> boolean contains(Collection<T> collection, V value, Function<T, V> function) {
        for (var v : collection) {
            if (value.equals(function.apply(v))) {
                return true;
            }
        }
        return false;
    }
}
