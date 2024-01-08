package utility;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

public class CacheManager {

    private static final Cache<String, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    private CacheManager() {
    }

    public static Object get(String key) {
        return cache.getIfPresent(key);
    }

    public static void put(String key, Object value) {
        cache.put(key, value);
    }
}
