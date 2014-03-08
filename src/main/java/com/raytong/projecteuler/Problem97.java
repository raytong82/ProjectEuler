package com.raytong.projecteuler;

public class Problem97 {
    public static void main(String[] args) {
        /*
        BigInteger num = BigInteger.valueOf(2);
        num = num.pow(7830457);
        num.multiply(BigInteger.valueOf(28433));
        num.add(BigInteger.valueOf(1));
        String str = num.toString();
        System.out.println(">>>" + str.substring(str.length() - 10));
        */
        int power = 7830457;
        int factor = 28433;
        /*
        String str = Integer.toBinaryString(factor);
        StringBuilder sb = new StringBuilder(str.length() + power);
        sb.append(str);
        for (int i=0; i<power-1; i++) {
            sb.append('0');
        }
        sb.append('1'); // + 1
        BigInteger result = new BigInteger(sb.toString(), 2);
        String s = result.toString();
        System.out.println(">>>" + s.substring(s.length() - 10));
        */
    }
}
