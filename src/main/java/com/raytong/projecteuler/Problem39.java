package com.raytong.projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem39 {
    public static void main(String[] args) {
        Map<Integer, Integer> rightAngleMap = new HashMap<Integer, Integer>();
        int max = -1;
        int ansP = -1;
        for (int p=12; p<=1000; p++) {
            for (int i=1; i<=p-2; i++) {
                for (int j=i; j<=p-2; j++) {
                    int k = p - i - j;
                    if (isRightAngleTriangle(i, j, k)) {
                        Integer count = rightAngleMap.get(p);
                        if (count == null) {
                            count = 1;
                        } else {
                            count++;
                        }
                        rightAngleMap.put(p, count); 
                        if (count > max) {
                            max = count;
                            ansP = p;
                        }
                    }
                }
            }
        }
        System.out.println(">>>" + ansP);
    }
    
    private static boolean isRightAngleTriangle(int a, int b, int c) {
        return (a * a + b * b - c * c == 0);
    }
}
