package com.util;

import java.util.HashMap;
import java.util.Map;

public class DataUtils {
    private static Map<String, Object> sharedData = new HashMap<>();

    public static void storeData(String key, Object value) {
        sharedData.put(key, value);
    }

    public static <T> T getData(String key, Class<T> clazz) {
        return clazz.cast(sharedData.get(key));
    }
}
