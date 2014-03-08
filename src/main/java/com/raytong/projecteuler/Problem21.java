package com.raytong.projecteuler;

import com.raytong.projecteuler.util.MathUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem21 {
    public static void main(String[] args) {
        Set<String> amicableSet = new HashSet<String>();
        Set<String> unamicableSet = new HashSet<String>();
        for (int i=2; i<=10000; i++) {
            if (amicableSet.contains(String.valueOf(i)) || unamicableSet.contains(String.valueOf(i))) {
                continue;
            }
            List<Integer> divisorList = MathUtil.getDivisor(i);
            int sumOfDivisors = MathUtil.sumOfDivisors(divisorList);
            List<Integer> testDivisorList = MathUtil.getDivisor(sumOfDivisors);
            int testSumOfDivisors = MathUtil.sumOfDivisors(testDivisorList);
            if (i == testSumOfDivisors && sumOfDivisors != testSumOfDivisors) {
                amicableSet.add(String.valueOf(sumOfDivisors));
                amicableSet.add(String.valueOf(testSumOfDivisors));
            } else {
                unamicableSet.add(String.valueOf(sumOfDivisors));
                unamicableSet.add(String.valueOf(testSumOfDivisors));
            }
        }
        int sum = 0;
        for (String s : amicableSet) {
            sum += Integer.valueOf(s);
        }
        System.out.println(">>>" + sum);
    }
}