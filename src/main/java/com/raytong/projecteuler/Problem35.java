package com.raytong.projecteuler;

import com.raytong.projecteuler.util.MathUtil;
import com.raytong.projecteuler.util.StringUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem35 {
    public static void main(String[] args) {
        Set<String> circularPrimeSet = new HashSet<String>();
        Set<String> otherSet = new HashSet<String>();
        for (int i=2; i<=1000000; i++) {
            if (circularPrimeSet.contains(String.valueOf(i))
                    || otherSet.contains(String.valueOf(i))) {
                continue;
            }
            List<String> circularList = StringUtil.retrieveCircular(String.valueOf(i));
            if (!MathUtil.isPrime(i)) {
                otherSet.addAll(circularList);
                continue;
            }
            boolean isCircularPrime = true;
            for (String s : circularList) {
                if (!MathUtil.isPrime(Integer.valueOf(s))) {  
                    isCircularPrime = false;
                    break;
                }
            }
            if (isCircularPrime) {
                circularPrimeSet.addAll(circularList);
            } else {
                otherSet.addAll(circularList);
            }
        }
        System.out.println(circularPrimeSet);
        System.out.println(">>>" + circularPrimeSet.size());
    }
}
