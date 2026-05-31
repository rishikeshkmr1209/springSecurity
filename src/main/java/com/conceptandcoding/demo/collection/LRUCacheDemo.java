package com.conceptandcoding.demo.collection;

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.display(); // Output: {1=One, 2=Two, 3=Three}

        cache.get(1); // Accessing key 1 to make it recently used
        cache.put(4, "Four"); // This will evict key 2 (least recently used)
        cache.display(); // Output: {3=Three, 1=One, 4=Four}
    }

}

class LRUCache<K,V> {
    private final int capacity;
    private final java.util.LinkedHashMap<K,V> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new java.util.LinkedHashMap<K,V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<K,V> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void display() {
        System.out.println(map);
    }
}
