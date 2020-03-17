package com.levelup.java.collections.map;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Java8Cache {

    private Map<Integer, BigInteger> betterCache = new ConcurrentHashMap<>();

    private BigInteger fibonacci(int n) {
        return betterCache.computeIfAbsent(n, (i) -> (i <= 2) ? BigInteger.ONE : fibonacci(i - 1).add(fibonacci(i - 2)));
    }

    public static void main(String[] args) {
        new Java8Cache().run();
    }

    private void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("fibonacci(" + i + ") is " + fibonacci(i));
        }
    }
}




