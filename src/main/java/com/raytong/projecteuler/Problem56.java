package com.raytong.projecteuler;

import java.math.BigInteger;

public class Problem56 {
    public static void main(String[] args) {
        int max = -1;
        for (int a=2; a<=99; a++) {
            for (int b=2; b<=99; b++) {
                BigInteger num = BigInteger.valueOf(a);
                num = num.pow(b);
                int sumOfDigits = sumOfDigits(num);
                max = Math.max(max, sumOfDigits);
            }
        }
        System.out.println(">>>" + max);
    }
    
    private static int sumOfDigits(BigInteger num) {
        String str = num.toString();
        int sum = 0;
        for (int i=0; i<str.length(); i++) {
            sum += str.charAt(i) - '1' + 1;
        }
        return sum;
    }
}
