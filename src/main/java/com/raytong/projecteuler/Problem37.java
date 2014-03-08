package com.raytong.projecteuler;

import com.raytong.projecteuler.util.MathUtil;
import com.raytong.projecteuler.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem37 {
    public static void main(String[] args) {
        List<Integer> truncablePrimeList = new ArrayList<Integer>();
        int i = 23;
        while (truncablePrimeList.size() < 11) {
            List<String> truncatedNumList = StringUtil.retrieveTruncated(String.valueOf(i));
            boolean isAllPrime = true;
            for (String s : truncatedNumList) {
                if (!MathUtil.isPrime(Integer.valueOf(s))) {
                    isAllPrime = false;
                    break;
                }
            }
            if (isAllPrime) {
                truncablePrimeList.add(i);
            }
            i += 2;
        }
        long total = 0;
        for (Integer p : truncablePrimeList) {
            total += p;
            System.out.println(p);
        }
        System.out.println(">>>" + total);
    }
}
