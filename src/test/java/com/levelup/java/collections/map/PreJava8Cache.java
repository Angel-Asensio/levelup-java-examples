package com.levelup.java.collections.map;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PreJava8Cache {

    private Map<Integer, BigInteger> simpleCache = new HashMap<>();
    private Object simpleCacheLock = new Object();

    private BigInteger fibonacci(int n) {
        BigInteger fib;
        synchronized (simpleCacheLock) {
            fib = simpleCache.get(n);
            if (null == fib) {
                fib = (n <= 2) ? BigInteger.ONE : fibonacci(n - 1).add(fibonacci(n - 2));
                simpleCache.put(n, fib);
            }
        }
        return fib;
    }

    public static void main(String[] args) {
        new PreJava8Cache().run();
    }

    private void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("fibonacci(" + i + ") is " + fibonacci(i));
        }
    }

}
