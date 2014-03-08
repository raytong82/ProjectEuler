package com.raytong.projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem14 {
    public static void main(String[] args) {
        Map<String, Long> cachedMap = new HashMap<String, Long>();
        cachedMap.put(String.valueOf(1), 1L);
        int maxNum = 1;
        long maxSize = 1;
        for (int i=2; i<=1000000; i++) {
            long n = i;
            long size = 0;
            while (n > 1) {
                size++;
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
                Long cachedSize = cachedMap.get(String.valueOf(n));
                if (cachedSize != null) {
                    cachedMap.put(String.valueOf(i), size + cachedSize);
                    if (size + cachedSize > maxSize) {
                        maxSize = size + cachedSize;
                        maxNum = i;
                    }
                    //System.out.println("number [" + i + "] with length [" + (size + cachedSize) + "]");
                    break;
                }
            }
        }
        System.out.println(">>> number [" + maxNum + "] has length [" + maxSize + "]");
    }
}