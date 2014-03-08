package com.raytong.projecteuler.util;

import java.util.ArrayList;
import java.util.List;

public class MathUtil {
    private MathUtil() {
    }
    
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i=2; i<=n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> getDivisor(int n) {
        List<Integer> divisorList = new ArrayList<Integer>();
        for (int i=1; i<=n/2; i++) {
            if (n % i == 0) {
                divisorList.add(i);
            }
        }
        return divisorList;
    }
    
    public static int sumOfDivisors(List<Integer> divisorList) {
        int sum = 0;
        for (Integer i : divisorList) {
            sum += i;
        }
        return sum;
    }
}
