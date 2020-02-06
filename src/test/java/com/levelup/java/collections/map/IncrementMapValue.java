package com.levelup.java.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IncrementMapValue {

    public <K> void incrementPutIfAbsent(Map<K, Integer> map, K key) {
        map.putIfAbsent(key, 0);
        map.put(key, map.get(key) + 1);
    }

    @Test
    public void withPutIfAbsent(){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);

        incrementPutIfAbsent(hashMap, "A");
        incrementPutIfAbsent(hashMap, "B");

        System.out.println(hashMap);
    }

    public <K> void incrementMerge(Map<K, Integer> map, K key) {
        map.merge(key, 1, Integer::sum);

        // or use lambda expressions
        // map.merge(key, 1, (a,b) -> a + b);
    }

    @Test
    public void withMerge(){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);

        incrementMerge(hashMap, "A");
        incrementMerge(hashMap, "B");

        System.out.println(hashMap);
    }

    public <K> void incrementGetOrDefault(Map<K,Integer> map, K key) {
        Integer count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
    }


    @Test
    public void withGetOrDefault() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);

        incrementGetOrDefault(hashMap, "A");
        incrementGetOrDefault(hashMap, "B");

        System.out.println(hashMap);
    }

    public <K> void incrementComputeIfPresent(Map<K,Integer> map, K key) {
        if (map.computeIfPresent(key, (k, v) -> v + 1) == null) {
            map.put(key, 1);
        }
    }

    @Test
    public void withComputeIfPresent() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);

        incrementComputeIfPresent(hashMap, "A");
        incrementComputeIfPresent(hashMap, "B");

        System.out.println(hashMap);
    }

}
