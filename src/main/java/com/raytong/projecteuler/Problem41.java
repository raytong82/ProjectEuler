package com.raytong.projecteuler;

import com.raytong.projecteuler.util.MathUtil;
import com.raytong.projecteuler.util.StringUtil;

import java.util.List;

public class Problem41 {
    public static void main(String[] args) {
        int max = -1;
        //String str = "123456789";
        String str = "1234567";
        // permutation of 123456789 and 12345678 would not be prime
        // because 1+2+3+4+5+6+7+8+9 = 45 is divisible by 3
        // same for 12345678
        for (int i=str.length(); i>=1; i--) {
            List<String> numList = StringUtil.retrieveCombination("", str.substring(0, i));
            boolean hasPrime = false;
            for (String s : numList) {
                if (MathUtil.isPrime(Integer.valueOf(s))) {
                    hasPrime = true;
                    max = Math.max(max, Integer.valueOf(s));
                }
            }
            if (hasPrime) {
                break;
            }
        }
        System.out.println(">>>" + max);
    }
}
