package com.raytong.projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem17 {
    public static void main(String[] args) {
        Map<Integer, String> cachedNumMap = new HashMap<Integer, String>();
        cachedNumMap.put(1, "one");
        cachedNumMap.put(2, "two");
        cachedNumMap.put(3, "three");
        cachedNumMap.put(4, "four");
        cachedNumMap.put(5, "five");
        cachedNumMap.put(6, "six");
        cachedNumMap.put(7, "seven");
        cachedNumMap.put(8, "eight");
        cachedNumMap.put(9, "nine");
        cachedNumMap.put(10, "ten");
        cachedNumMap.put(11, "eleven");
        cachedNumMap.put(12, "twelve");
        cachedNumMap.put(13, "thirteen");
        cachedNumMap.put(14, "fourteen");
        cachedNumMap.put(15, "fifteen");
        cachedNumMap.put(16, "sixteen");
        cachedNumMap.put(17, "seventeen");
        cachedNumMap.put(18, "eighteen");
        cachedNumMap.put(19, "nineteen");
        cachedNumMap.put(20, "twenty");
        cachedNumMap.put(30, "thirty");
        cachedNumMap.put(40, "forty");
        cachedNumMap.put(50, "fifty");
        cachedNumMap.put(60, "sixty");
        cachedNumMap.put(70, "seventy");
        cachedNumMap.put(80, "eighty");
        cachedNumMap.put(90, "ninety");
        String[] tensStr = new String[10];
        tensStr[2] = "twenty";
        tensStr[3] = "thirty";
        tensStr[4] = "forty";
        tensStr[5] = "fifty";
        tensStr[6] = "sixty";
        tensStr[7] = "seventy";
        tensStr[8] = "eighty";
        tensStr[9] = "ninety";
        
        
        long length = 0;
        for (int i=1; i<= 999; i++) {
            int num = i;
            String cachedNumStr = cachedNumMap.get(num);
            if (cachedNumStr != null) {
                length += cachedNumStr.length();
                System.out.println(cachedNumStr);
                continue;
            }
            if (num >= 100) {
                int hundreds = num / 100;
                num = num % 100;
                String hundredStr = cachedNumMap.get(hundreds);
                length += hundredStr.length();
                length += "hundred".length();
                System.out.print(hundredStr + " hundred");
                if (num > 0) {
                    length += "and".length();
                    System.out.print(" and");
                } else {
                    System.out.println();
                    continue;
                }
            }
            int tens = (num % 100) / 10;
            int ones = num % 10;
            cachedNumStr = cachedNumMap.get(num); //remained
            if (cachedNumStr != null) {
                length += cachedNumStr.length();
                System.out.println(" " + cachedNumStr);
                continue;
            }
            length += tensStr[tens].length();
            length += cachedNumMap.get(ones).length();
            System.out.print(" " + tensStr[tens]);
            System.out.println(" " + cachedNumMap.get(ones));
        }
        length += "onethousand".length();
        System.out.println(">>>" + length);
    }
}
